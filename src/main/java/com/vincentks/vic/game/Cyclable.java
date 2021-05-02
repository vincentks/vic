package com.vincentks.vic.game;

public interface Cyclable extends Item {
	Cyclable cycle();

	@Override
	default boolean isCyclable() {
		return true;
	}
}
