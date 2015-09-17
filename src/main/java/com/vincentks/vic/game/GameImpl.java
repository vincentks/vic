package com.vincentks.vic.game;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class GameImpl implements Game
{
  private List<Pair<Actor, Item>> items = Lists.newArrayList();
  private int cycleId;

  @Override
  public CycleSummary cycle()
  {
    for (int i = 0; i < items.size(); i++)
    {
      final Pair<Actor, Item> actorItemPair = items.get(i);
      // TODO come up with a mechanism better than checking for classes
      if (Cyclable.class.isAssignableFrom(actorItemPair.getSecond().getClass()))
      {
        final Cyclable cyclable = (Cyclable) actorItemPair.getSecond();
        final Item item = cyclable.cycle();
        items.set(i, new Pair<>(actorItemPair.getFirst(), item));
      }
    }
    return new CycleSummaryImpl(++cycleId, getDiffAwareItems(items));
  }

  private Collection<Pair<Actor, DiffAware>> getDiffAwareItems(List<Pair<Actor, Item>> items)
  {
    // TODO come up with a mechanism better than checking for classes
    return items
        .stream()
        .filter(actorItemPair -> DiffAware.class.isAssignableFrom(actorItemPair.getSecond().getClass()))
        .map(actorItemPair -> new Pair<>(actorItemPair.getFirst(), (DiffAware) actorItemPair.getSecond()))
        .collect(Collectors.toList());
  }

  @Override
  public void add(Actor actor, Item item)
  {
    items.add(new Pair<>(actor, item));
  }
}
