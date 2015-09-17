package com.vincentks.vic.game.util;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import com.vincentks.vic.game.Cyclable;
import com.vincentks.vic.game.CycleDiff;
import com.vincentks.vic.game.DiffAware;
import com.vincentks.vic.game.Effort;
import com.vincentks.vic.game.Item;

public class NullDiffAwareItem implements DiffAware
{
  @Override
  public Collection<CycleDiff> diff(Item itemInPreviousCycle)
  {
    return Collections.emptyList();
  }

  @Override
  public Cyclable cycle()
  {
    return this;
  }

  @Override
  public Effort buildEffort()
  {
    return Effort.noEffort;
  }

  @Override
  public UUID getId()
  {
    return UUID.randomUUID();
  }

}
