package com.vincentks.vic.game.event;

import static com.vincentks.vic.game.util.TestFixture.NULL_ACTOR;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import com.vincentks.vic.game.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SettleEventTest {
	@Mock
	private Game game;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSettle_NewCityIsCreated_SettlerIsRemoved() {
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
