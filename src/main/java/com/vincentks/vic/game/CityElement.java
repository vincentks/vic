package com.vincentks.vic.game;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

public class CityElement implements Item
{
  private final Effort effort;

  public CityElement(Effort effort)
  {
    this.effort = effort;
  }

  @Override
  public Item cycle()
  {
    return new CityElement(effort);
  }

  @Override
  public UUID getId()
  {
    return UUID.randomUUID();
  }

  @Override
  public ItemType getType()
  {
    return ItemType.STATIC;
  }

  @Override
  public Optional<Item> currentActivity()
  {
    return Optional.empty();
  }

  @Override
  public Effort buildEffort()
  {
    return effort;
  }

  @Override
  public Collection<CycleDiff> diff(Item itemInPreviousCycle)
  {
    return Collections.emptyList();
  }
}
