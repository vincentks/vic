package com.vincentks.vic.game;

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
    this.items = this.items
        .stream()
        .map(GameImpl::cycle)
        .collect(Collectors.toList());
    return new CycleSummaryImpl(++cycleId, items);
  }

  private static Pair<Actor, Item> cycle(Pair<Actor, Item> actorItemPair)
  {
    return new Pair<>(
        actorItemPair.getFirst(),
        actorItemPair.getSecond().cycle()
    );
  }

  @Override
  public void add(Actor actor, Item item)
  {
    items.add(new Pair<>(actor, item));
  }
}
