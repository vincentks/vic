package com.vincentks.vic.game;

import java.util.Optional;

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
  public Optional<Item> currentActivity()
  {
    return Optional.empty();
  }

  @Override
  public Effort buildEffort()
  {
    return effort;
  }
}
