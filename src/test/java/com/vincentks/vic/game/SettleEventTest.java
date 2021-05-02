package com.vincentks.vic.game;

import static com.vincentks.vic.game.util.TestFixture.NULL_ACTOR;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SettleEventTest {
	@Mock
	private Game game;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSettle_NewCityIsCreated_SettlerIsRemoved() throws Exception {
		Settler settler = new Settler();
		final LocationManager locationManager = new LocationManagerImpl();
		new MoveEvent(settler, new Location(Terrain.STANDARD, 2, 2), locationManager).execute();
		final SettleEvent settleEvent = new SettleEvent(
			settler,
			"Haarlem",
			NULL_ACTOR,
			game,
			locationManager.getLocation(settler)
		);
		settleEvent.execute();

		verify(game).add(eq(NULL_ACTOR), any(City.class));
		verify(game).remove(eq(NULL_ACTOR), eq(settler));
	}
}
