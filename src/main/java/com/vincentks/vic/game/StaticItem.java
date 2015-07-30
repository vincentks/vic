package com.vincentks.vic.game;

import java.util.Optional;

public interface StaticItem extends Item
{
  void build(Item item);

  Optional<Item> currentlyBuilding();
}
