package com.vincentks.vic.game;

import java.util.Map;

import com.google.common.collect.Maps;

public class LocationManagerImpl implements LocationManager
{
  private final Map<ActiveItem, Location> items = Maps.newHashMap();

  @Override
  public Location getLocation(ActiveItem item)
  {
    return items.get(item);
  }

  @Override
  public void move(ActiveItem item, Location location)
  {
    items.put(item, location);
  }
}
