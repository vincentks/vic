package com.vincentks.vic.game;

public interface ActiveItem extends Cyclable
{
  void moveTo(Location location);

  Location getCurrentLocation();
}
