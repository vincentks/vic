package com.vincentks.vic.game;

import java.util.Optional;

public interface ItemProducer extends DiffAware {
	Optional<Item> currentActivity();

	void build(Item item);

	Optional<Item> currentlyBuilding();
}
