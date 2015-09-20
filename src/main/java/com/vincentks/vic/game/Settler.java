package com.vincentks.vic.game;

import java.util.UUID;

public class Settler implements MobileItem
{
  private final UUID id = UUID.randomUUID();

  @Override
  public Effort buildEffort()
  {
    return new Effort(1);
  }

  @Override
  public UUID getId()
  {
    return id;
  }
}
