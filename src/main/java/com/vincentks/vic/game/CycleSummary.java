package com.vincentks.vic.game;

public interface CycleSummary
{
  int numberOfItems();

  boolean contains(Item item);

  CycleSummary itemsFor(Actor actor);

  int getId();
}
