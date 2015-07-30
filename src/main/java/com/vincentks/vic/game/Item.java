package com.vincentks.vic.game;

import java.util.Optional;

public interface Item extends Tick
{
  Optional<Item> currentActivity();

  Effort buildEffort();

  @Override
  Item cycle();
}
