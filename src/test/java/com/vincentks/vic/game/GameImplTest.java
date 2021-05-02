package com.vincentks.vic.game;

import static com.vincentks.vic.game.util.TestFixture.EMPTY_CITY;
import static com.vincentks.vic.game.util.TestFixture.NULL_ACTOR;
import static com.vincentks.vic.game.util.TestFixture.NULL_DIFF_AWARE_ITEM;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.vincentks.vic.game.util.NullActor;

public class GameImplTest {

	@Test
	public void testTurn_EmptyGame() {
		CycleSummary cycleSummary = new GameImpl().cycle();

		assertEquals(0, cycleSummary.numberOfItems());
	}

	@Test
	public void testCycle_TrackNumberOfTurns() {
		final CycleSummary cycleSummary = new GameImpl().cycle();

		assertThat(cycleSummary.getId(), is(1));
	}

	@Test
	public void testCycle_ItemGeneratesOneActionUponTurn() {
		final Game game = new GameImpl();
		game.add(NULL_ACTOR, NULL_DIFF_AWARE_ITEM);

		final CycleSummary cycleSummary = game.cycle();

		assertEquals(1, cycleSummary.numberOfItems());
	}

	@Test
	public void testCycle_SegregateSummaryByOwner() {
		final Game game = new GameImpl();
		final Actor actor = new NullActor();
		game.add(actor, NULL_DIFF_AWARE_ITEM);

		game.add(new NullActor(), NULL_DIFF_AWARE_ITEM);
		game.add(new NullActor(), NULL_DIFF_AWARE_ITEM);

		final CycleSummary cycleSummary = game.cycle();

		assertEquals(3, cycleSummary.numberOfItems());
		assertEquals(1, cycleSummary.itemsFor(actor).numberOfItems());
	}

	@Test
	public void testCycle_ShouldYieldNewItems() {
		Item preTurnItem = EMPTY_CITY;
		final Game game = new GameImpl();
		game.add(NULL_ACTOR, preTurnItem);

		final CycleSummary cycleSummary = game.cycle();

		assertThat(cycleSummary.contains(preTurnItem), is(false));
	}
}
