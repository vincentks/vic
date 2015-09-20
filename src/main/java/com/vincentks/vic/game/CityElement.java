package com.vincentks.vic.game;

import java.util.UUID;

public class CityElement implements Item, Cyclable
{
  private final Effort effort;
  private final UUID id = UUID.randomUUID();

  public CityElement(Effort effort)
  {
    this.effort = effort;
  }

  @Override
  public Cyclable cycle()
  {
    return new CityElement(effort);
  }

  @Override
  public UUID getId()
  {
    return id;
  }

  @Override
  public Effort buildEffort()
  {
    return effort;
  }
}
