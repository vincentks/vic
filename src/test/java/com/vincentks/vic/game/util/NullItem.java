package com.vincentks.vic.game.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import com.vincentks.vic.game.CityBuilder;
import com.vincentks.vic.game.CycleDiff;
import com.vincentks.vic.game.Effort;
import com.vincentks.vic.game.Item;
import com.vincentks.vic.game.ItemType;

public class NullItem implements Item
{
  @Override
  public Item cycle()
  {
    return new CityBuilder().build();
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
    return new Effort(0);
  }

  @Override
  public Collection<CycleDiff> diff(Item itemInPreviousCycle)
  {
    return Collections.emptyList();
  }

}
