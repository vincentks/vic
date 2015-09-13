package com.vincentks.vic.game;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

public class FootSoldier implements ActiveItem
{
  private Optional<Location>    targetLocation;
  private final LocationManager locationManager;

  private FootSoldier(LocationManager locationManager)
  {
    this.locationManager = locationManager;
  }

  public static ActiveItem create(Location currentLocation, LocationManager locationManager)
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
  public Optional<Item> currentActivity()
  {
    return Optional.empty();
  }

  @Override
  public Effort buildEffort()
  {
    return new Effort(1);
  }

  @Override
  public Item cycle()
  {
    if (targetLocation.isPresent())
    {
      locationManager.move(this, targetLocation.get());
      targetLocation = Optional.empty();
    }
    return this;
  }

  @Override
  public UUID getId()
  {
    return UUID.randomUUID();
  }

  @Override
  public ItemType getType()
  {
    return ItemType.ACTIVE;
  }

  @Override
  public Collection<CycleDiff> diff(Item itemInPreviousCycle)
  {
    return Collections.emptyList();
  }
}
