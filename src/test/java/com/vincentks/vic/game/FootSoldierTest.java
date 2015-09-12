package com.vincentks.vic.game;

import static com.vincentks.vic.game.Terrain.STANDARD;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FootSoldierTest
{
  @Test
  public void testMove_SimpleMove() throws Exception
  {
    ActiveItem item = FootSoldier.create(
        new Location(STANDARD),
        new LocationManagerImpl()
    );
    item.moveTo(new Location(STANDARD, 1, 0));
    item.cycle();
    item.cycle();

    assertThat(item.getCurrentLocation().getX(), is(1));
    assertThat(item.getCurrentLocation().getY(), is(0));
  }
}
