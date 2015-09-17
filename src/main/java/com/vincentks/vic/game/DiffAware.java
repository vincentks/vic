package com.vincentks.vic.game;

import java.util.Collection;

public interface DiffAware extends Cyclable
{
  Collection<CycleDiff> diff(Item itemInPreviousCycle);
}
