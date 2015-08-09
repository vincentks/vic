package com.vincentks.vic.game;

import java.util.Optional;
import java.util.UUID;

public interface Item extends Cyclable, DiffAware
{
  Optional<Item> currentActivity();

  Effort buildEffort();

  @Override
  Item cycle();

  UUID getId();
}
