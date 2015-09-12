package com.vincentks.vic.game;

import static com.vincentks.vic.game.util.TestFixture.NULL_ACTOR;
import static com.vincentks.vic.game.util.TestFixture.NULL_ITEM;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.vincentks.vic.game.util.NullActor;

public class GameImplTest
{

  @Test
  public void testTurn_EmptyGame() throws Exception
  {
    CycleSummary cycleSummary = new GameImpl().cycle();

    assertEquals(0, cycleSummary.numberOfItems());
  }

  @Test
  public void testCycle_TrackNumberOfTurns() throws Exception
  {
    final CycleSummary cycleSummary = new GameImpl().cycle();

    assertThat(cycleSummary.getId(), is(1));
  }

  @Test
  public void testCycle_ItemGeneratesOneActionUponTurn() throws Exception
  {
    final Game game = new GameImpl();
    game.add(NULL_ACTOR, NULL_ITEM);

    final CycleSummary cycleSummary = game.cycle();

    assertEquals(1, cycleSummary.numberOfItems());
  }

  @Test
  public void testCycle_SegregateSummaryByOwner() throws Exception
  {
    final Game game = new GameImpl();
    final Actor actor = new NullActor();
    game.add(actor, NULL_ITEM);

    game.add(new NullActor(), NULL_ITEM);
    game.add(new NullActor(), NULL_ITEM);

    final CycleSummary cycleSummary = game.cycle();

    assertEquals(3, cycleSummary.numberOfItems());
    assertEquals(1, cycleSummary.itemsFor(actor).numberOfItems());
  }

  @Test
  public void testCycle_ShouldYieldNewItems() throws Exception
  {
    Item preTurnItem = new CityBuilder().setName("amsterdam").build();
    final Game game = new GameImpl();
    game.add(NULL_ACTOR, preTurnItem);

    final CycleSummary cycleSummary = game.cycle();

    assertThat(cycleSummary.contains(preTurnItem), is(false));
  }
}
