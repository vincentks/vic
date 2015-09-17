package com.vincentks.vic.game;

import java.util.UUID;

// TODO review how to address this item type: are they needed when fighthing is implemented?
public class FootSoldier implements MobileItem
{

  @Override
  public Effort buildEffort()
  {
    return new Effort(1);
  }

  @Override
  public UUID getId()
  {
    return UUID.randomUUID();
  }

}