
package com.vincentks.vic.game;

import static com.vincentks.vic.game.City.INITIAL_POPULATION;
import static com.vincentks.vic.game.util.TestFixture.EMPTY_CITY;
import static java.util.Optional.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;

public class CityTest {
	@Test
	public void testCycle_Empty() throws Exception {
		assertThat(
			EMPTY_CITY.cycle().getPopulation(),
			is(0)
		);
	}

	@Test
	public void testCycle_10PerCentGrowth() throws Exception {
		final City city = new CityBuilder()
			.setName("Amsterdam")
			.setPopulation(INITIAL_POPULATION)
			.setLocation(new Location(Terrain.DESERT))
			.build();

		assertThat(
			city.cycle().getPopulation(),
			is(1100)
		);
	}

	@Test
	public void testCurrentActivity_IsEmpty() throws Exception {
		assertThat(EMPTY_CITY.currentActivity(), is(empty()));
	}

	@Test
	public void testCurrentActivity_NewElement() throws Exception {
		City city = EMPTY_CITY;
		city.build(new CityElement(new Effort(2)));

		final City postCycleCity = city.cycle();

		assertThat(postCycleCity.currentlyBuilding().get(), isA(Item.class));
	}

	@Test
	public void testCity_BuildsItemOnCycle() throws Exception {
		City city = EMPTY_CITY;
		city.build(new CityElement(new Effort(2)));
		city.build(new CityElement(new Effort(2)));

		final City postCycleCity = city.cycle().cycle().cycle().cycle();

		assertThat(postCycleCity.getElements(), iterableWithSize(2));
		assertThat(postCycleCity.currentlyBuilding(), is(Optional.empty()));
	}

	@Test
	public void testCity_GrowthBasedOnTerrain() throws Exception {
		City city = new CityBuilder()
			.setName("Amsterdam")
			.setPopulation(INITIAL_POPULATION)
			.build();

		assertThat(city.getGrowthFactor(), is(1.0));
	}
}
