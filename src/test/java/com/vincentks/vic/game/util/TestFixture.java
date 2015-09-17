package com.vincentks.vic.game.util;

import com.vincentks.vic.game.City;
import com.vincentks.vic.game.CityBuilder;

public class TestFixture
{
  public static final NullActor         NULL_ACTOR           = new NullActor();

  public static final NullDiffAwareItem NULL_DIFF_AWARE_ITEM = new NullDiffAwareItem();

  public static City EMPTY_CITY = new CityBuilder()
      .setName("Amsterdam")
      .build();

}
