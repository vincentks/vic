package com.vincentks.vic.game.util;

import java.util.Optional;

import com.vincentks.vic.game.City;
import com.vincentks.vic.game.Effort;
import com.vincentks.vic.game.Item;

public class NullItem implements Item
{
  @Override
  public Item cycle()
  {
    // TODO how to address this?
    return new City(null);
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
}
