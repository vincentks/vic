package com.vincentks.vic.game.util;

import java.util.UUID;

import com.vincentks.vic.game.Effort;
import com.vincentks.vic.game.MobileItem;

public class MobileItemWithEffort implements MobileItem
{
  private final int effort;

  public MobileItemWithEffort(int effort)
  {
    this.effort = effort;
  }

  @Override
  public Effort buildEffort()
  {
    return new Effort(effort);
  }

  @Override
  public UUID getId()
  {
    return null;
  }
}
