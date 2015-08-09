package com.vincentks.vic.game;

public class Effort implements Cyclable
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
}
