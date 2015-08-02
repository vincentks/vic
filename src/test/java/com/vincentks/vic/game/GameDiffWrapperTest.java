package com.vincentks.vic.game;

import static com.vincentks.vic.game.RelevanceLevel.NORMAL;
import static com.vincentks.vic.game.Terrain.DESERT;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.vincentks.vic.game.util.NullActor;

public class GameDiffWrapperTest
{

  // TODO move this to a global test fixture?
  private static final NullActor NULL_ACTOR = new NullActor();

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
  public void testCycle_CityEvolution() throws Exception
  {
    final CycleDiffCollector cycleDiffCollector = new CycleDiffCollector();
    // TODO create a game builder?
    final Game game = new GameImpl();
    final City city = new CityBuilder()
        .setName("Amsterdam")
        .setLocation(new Location(DESERT))
        .setPopulation(1000)
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