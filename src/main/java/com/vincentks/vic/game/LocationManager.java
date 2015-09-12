package com.vincentks.vic.game;

public interface LocationManager
{
  Location getLocation(ActiveItem item);

  void move(ActiveItem item, Location location);
}
