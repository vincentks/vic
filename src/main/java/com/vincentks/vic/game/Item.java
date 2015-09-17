package com.vincentks.vic.game;

import java.util.UUID;

// TODO add definition of each of the interfaces in this hierarchy
public interface Item
{
  Effort buildEffort();

  UUID getId();
}
