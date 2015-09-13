package com.vincentks.vic.game;

public interface ActiveItem extends Cyclable, Item
{
  void moveTo(Location location);

  Location getCurrentLocation();
}
