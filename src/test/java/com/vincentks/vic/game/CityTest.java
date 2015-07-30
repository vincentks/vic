package com.vincentks.vic.game;

import static java.util.Optional.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;

public class CityTest
{
  private static City emptyCity = new City("Amsterdam");

  @Test
  public void testTick_Empty() throws Exception
  {
    assertThat(
        emptyCity.cycle().getPopulation(),
        is(0)
    );
  }

  @Test
  public void testTick_10PerCentGrowth() throws Exception
  {
    assertThat(
        new City("Amsterdam", 1000, new Location(Terrain.DESERT)).cycle().getPopulation(),
        is(1100)
    );
  }

  @Test
  public void testCurrentActivity_IsNothing() throws Exception
  {
    assertThat(emptyCity.currentActivity(), is(empty()));
  }

  @Test
  public void testCurrentActivity_NewElement() throws Exception
  {
    City city = new City("Amsterdam");
    city.build(new CityElement(new Effort(2)));

    final City postCycleCity = city.cycle();

    assertThat(postCycleCity.currentlyBuilding().get(), isA(Item.class));
  }

  @Test
  public void testCity_BuildsItemOnCycle() throws Exception
  {
    City city = new City("Amsterdam");
    city.build(new CityElement(new Effort(2)));
    city.build(new CityElement(new Effort(2)));

    final City postCycleCity = city.cycle().cycle().cycle().cycle();

    assertThat(postCycleCity.getElements(), iterableWithSize(2));
    assertThat(postCycleCity.currentlyBuilding(), is(Optional.empty()));
  }

  @Test
  public void testCity_GrowthBasedOnTerrain() throws Exception
  {
    City city = new City("Amsterdam", 1000);

    assertThat(city.getGrowthFactor(), is(1.0));
  }
}