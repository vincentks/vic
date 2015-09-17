package com.vincentks.vic.game;

import static com.vincentks.vic.game.City.INITIAL_POPULATION;
import static com.vincentks.vic.game.RelevanceLevel.NORMAL;
import static com.vincentks.vic.game.Terrain.DESERT;
import static com.vincentks.vic.game.util.TestFixture.EMPTY_CITY;
import static com.vincentks.vic.game.util.TestFixture.NULL_ACTOR;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.vincentks.vic.game.util.MobileItemWithEffort;

public class GameDiffWrapperTest
{
  @Test
  public void testCycle_EmptyDiff() throws Exception
  {
    final CycleDiffCollector cycleDiffCollector = new CycleDiffCollector();
    new GameDiffWrapper(
        new GameImpl(),
        NULL_ACTOR,
        cycleDiffCollector
    ).cycle();

    assertThat(cycleDiffCollector.getDiffs(), emptyIterable());
  }

  @Test
  public void testCycle_CityBuildingUnit() throws Exception
  {
    final CycleDiffCollector cycleDiffCollector = new CycleDiffCollector();
    final Game game = new GameImpl();
    final City city = EMPTY_CITY;
    game.add(NULL_ACTOR, city);
    final GameDiffWrapper wrapper = new GameDiffWrapper(
        game,
        NULL_ACTOR,
        cycleDiffCollector
    );
    wrapper.cycle();
    city.build(new MobileItemWithEffort(1));
    wrapper.cycle();

    final CycleDiff cycleDiff = cycleDiffCollector.getDiffs().iterator().next();
    assertThat(cycleDiff.getLevel(), is(NORMAL));
    assertThat(cycleDiff.getMessage(), containsString("Created 1 new unit(s)"));
  }

  @Test
  public void testCycle_CityPopulationEvolution() throws Exception
  {
    final CycleDiffCollector cycleDiffCollector = new CycleDiffCollector();
    // TODO create a game builder?
    final Game game = new GameImpl();
    final City city = new CityBuilder()
        .setName("Amsterdam")
        .setLocation(new Location(DESERT))
        .setPopulation(INITIAL_POPULATION)
        .build();
    game.add(NULL_ACTOR, city);
    final GameDiffWrapper wrapper = new GameDiffWrapper(
        game,
        NULL_ACTOR,
        cycleDiffCollector
    );
    wrapper.cycle();
    wrapper.cycle();

    final CycleDiff cycleDiff = cycleDiffCollector.getDiffs().iterator().next();
    assertThat(cycleDiff.getLevel(), is(NORMAL));
    assertThat(cycleDiff.getMessage(), containsString("Population changed to 1210 (+110)"));
  }
}