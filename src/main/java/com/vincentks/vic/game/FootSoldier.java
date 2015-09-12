package com.vincentks.vic.game;

import java.util.Optional;

public class FootSoldier implements ActiveItem
{
  private Optional<Location>    targetLocation;
  private final LocationManager locationManager;

  private FootSoldier(LocationManager locationManager)
  {
    this.locationManager = locationManager;
  }

  public static FootSoldier create(Location currentLocation, LocationManager locationManager)
  {
    final FootSoldier result = new FootSoldier(locationManager);
    locationManager.move(result, currentLocation);
    return result;
  }

  @Override
  public void moveTo(Location location)
  {
    this.targetLocation = Optional.of(location);
  }

  @Override
  public Location getCurrentLocation()
  {
    return locationManager.getLocation(this);
  }

  @Override
  public Cyclable cycle()
  {
    if (targetLocation.isPresent())
    {
      locationManager.move(this, targetLocation.get());
      targetLocation = Optional.empty();
    }
    return this;
  }
}
