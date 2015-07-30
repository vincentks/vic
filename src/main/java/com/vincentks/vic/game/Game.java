package com.vincentks.vic.game;

public interface Game
{
  CycleSummary cycle();

  void add(Actor actor, Item city);
}
