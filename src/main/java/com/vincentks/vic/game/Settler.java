package com.vincentks.vic.game;

import java.util.UUID;

public class Settler implements MobileItem
{
  @Override
  public Effort buildEffort()
  {
    return new Effort(1);
  }

  @Override
  public UUID getId()
  {
    // TODO will this be repeated everywhere...?
    return UUID.randomUUID();
  }
}
