package com.vincentks.vic.game.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import com.vincentks.vic.game.CityBuilder;
import com.vincentks.vic.game.CycleDiff;
import com.vincentks.vic.game.Effort;
import com.vincentks.vic.game.Item;

public class NullItem implements Item
{
  @Override
  public Item cycle()
  {
    // TODO how to address this?
    return new CityBuilder().setName(null).build();
  }

  @Override
  public UUID getId()
  {
    return UUID.randomUUID();
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
