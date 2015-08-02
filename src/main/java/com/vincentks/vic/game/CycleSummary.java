package com.vincentks.vic.game;

import java.util.Optional;
import java.util.UUID;

public interface CycleSummary
{
  int numberOfItems();

  boolean contains(Item item);

  CycleSummary itemsFor(Actor actor);

  int getId();

  Iterable<Item> getItems();

  Optional<Item> getById(UUID itemId);
}
