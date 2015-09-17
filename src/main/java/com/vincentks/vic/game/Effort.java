package com.vincentks.vic.game;

import java.util.UUID;

// TODO: this is not an item
public class Effort implements Item, Cyclable
{
  public static final Effort noEffort = new Effort(0)
  {
    @Override
    public Effort cycle()
    {
      return this;
    }
  };
  private final double effort;

  public Effort(double effort)
  {
    this.effort = effort;
  }

  public double getEffort()
  {
    return effort;
  }

  @Override
  public Effort cycle()
  {
    if (this == noEffort)
      return noEffort;
    return new Effort(effort + 1);
  }

  @Override
  public Effort buildEffort()
  {
    return noEffort;
  }

  @Override
  public UUID getId()
  {
    return null;
  }

}
