package com.vincentks.vic.game;

public class Location
{
  private final Terrain terrain;

  public Location(Terrain terrain)
  {
    this.terrain = terrain;
  }

  public double getGrowthFactor()
  {
    return terrain.getGrowthFactor();
  }
}
