package com.vincentks.vic.game;

public class SettleEvent implements Event
{
  private final Settler  settler;
  private final Actor    actor;
  private final Game     game;
  private final String   cityName;
  private final Location cityLocation;

  public SettleEvent(
      Settler settler,
      String cityName,
      Actor actor,
      Game game,
      Location cityLocation
  )
  {
    this.settler = settler;
    this.cityName = cityName;
    this.actor = actor;
    this.game = game;
    this.cityLocation = cityLocation;
  }

  @Override
  public Item execute()
  {
    // TODO items should not belong to a city: how to deal with deaths?
//    settler.die();
    final City city = new CityBuilder()
        .setLocation(cityLocation)
        .setPopulation(City.INITIAL_POPULATION)
        .setName(cityName)
        .build();
    game.add(actor, city);
    return settler;
  }
}
