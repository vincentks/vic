package com.vincentks.vic.game;

import java.util.Map;

import com.google.common.collect.Maps;

public class LocationManagerImpl implements LocationManager
{
  private final Map<MobileItem, Location> items = Maps.newHashMap();

  @Override
  public Location getLocation(MobileItem item)
  {
    return items.get(item);
  }

  @Override
  public void move(MobileItem item, Location location)
  {
    items.put(item, location);
  }
}
