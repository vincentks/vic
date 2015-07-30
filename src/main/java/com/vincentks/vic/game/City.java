package com.vincentks.vic.game;

import static com.vincentks.vic.game.Terrain.STANDARD;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import com.google.common.collect.FluentIterable;

public class City implements StaticItem
{
  private final String           name;
  private final Integer          population;
  private final Location         location;
  private final Optional<Item>   currentlyBuilding;
  private final Collection<Item> elements;
  private final Effort           buildEffortSpent;
  private final Queue<Item>      buildQueue;

  public City(String name)
  {
    this(name, 0);
  }

  public City(String name, int population)
  {
    this(name, population, new Location(STANDARD));
  }

  public City(String name, int population, Location location)
  {
    this(
        name,
        population,
        location,
        new Effort(0),
        Optional.empty(),
        Collections.emptyList(),
        new LinkedList<>()
    );
  }

  public City(
      String name,
      int population,
      Location location,
      Effort buildEffortSpent,
      Optional<Item> currentlyBuilding,
      Collection<Item> elements,
      Queue<Item> buildQueue
  )
  {
    this.name = name;
    this.population = population;
    this.location = location;
    this.buildEffortSpent = buildEffortSpent;
    this.currentlyBuilding = currentlyBuilding;
    this.elements = elements;
    this.buildQueue = buildQueue;
  }

  @Override
  public Optional<Item> currentActivity()
  {
    return currentlyBuilding;
  }

  @Override
  public Effort buildEffort()
  {
    return new Effort(0);
  }

  @Override
  public void build(Item item)
  {
    this.buildQueue.add(item);
  }

  @Override
  public Optional<Item> currentlyBuilding()
  {
    return currentlyBuilding;
  }

  @Override
  public City cycle()
  {
    // TODO move all this logic to a builder?
    // TODO the city should be able to build more than one unit in one cycle, given that its production effort is much higher than what is required by a given unit
    // TODO add cycle diff service
    Effort buildEffortSpent = getBuildEffortSpent().cycle();
    Optional<Item> itemToBuild = currentlyBuilding;
    if (!itemToBuild.isPresent())
      itemToBuild = Optional.ofNullable(buildQueue.poll());
    final Optional<Item> itemBuilt = buildItem(buildEffortSpent, itemToBuild);
    if (shouldNewItemBeBuilt(itemBuilt))
    {
      itemToBuild = Optional.ofNullable(buildQueue.poll());
      if (itemToBuild.isPresent())
        buildEffortSpent = new Effort(0);
    }

    Collection<Item> nextTickElements = appendToElementsIfNecessary(itemBuilt);

    return new City(
        name,
        population + Double.valueOf(population * getGrowthFactor()).intValue(),
        location,
        buildEffortSpent,
        itemToBuild,
        nextTickElements,
        buildQueue
    );
  }

  private static boolean shouldNewItemBeBuilt(Optional<Item> itemBuilt)
  {
    return itemBuilt.isPresent();
  }

  private Collection<Item> appendToElementsIfNecessary(Optional<Item> itemBuild)
  {
    if (itemBuild.isPresent())
      return FluentIterable
          .from(elements)
          .append(itemBuild.get())
          .toList();
    return elements;
  }

  private static Optional<Item> buildItem(Effort buildEffortSpent, Optional<Item> itemToBuild)
  {
    if (isBuildingReady(buildEffortSpent, itemToBuild))
      return Optional.of(itemToBuild.get());
    return Optional.empty();
  }

  private static boolean isBuildingReady(Effort buildEffortSpent, Optional<Item> itemToBuild)
  {
    return itemToBuild.isPresent()
        && itemToBuild.get().buildEffort().getEffort() <= buildEffortSpent.getEffort();
  }

  public Integer getPopulation()
  {
    return population;
  }

  public double getGrowthFactor()
  {
    return location.getGrowthFactor();
  }

  public String getName()
  {
    return name;
  }

  public Collection<Item> getElements()
  {
    return elements;
  }

  public Effort getBuildEffortSpent()
  {
    return buildEffortSpent;
  }
}
