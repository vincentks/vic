package com.vincentks.vic.game;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.vincentks.vic.game.util.NullMobileItem;

public class MoveEventTest
{

  @Test
  public void testExecute() throws Exception
  {
    MobileItem item = new NullMobileItem();
    LocationManager manager = new LocationManagerImpl();

    new MoveEvent(
        item,
        new Location(Terrain.STANDARD, 6, 7),
        manager
    ).execute();

    assertThat(manager.getLocation(item).getX(), is(6));
    assertThat(manager.getLocation(item).getY(), is(7));
  }
}