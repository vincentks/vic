package com.vincentks.vic.game;

public class MoveEvent implements Event
{
  private final MobileItem      item;
  private final Location        targetLocation;
  private final LocationManager locationManager;

  public MoveEvent(MobileItem item, Location targetLocation, LocationManager locationManager)
  {
    this.item = item;
    this.targetLocation = targetLocation;
    this.locationManager = locationManager;
  }

  @Override
  public Item execute()
  {
    locationManager.move(item, targetLocation);
    return item;
  }
}
