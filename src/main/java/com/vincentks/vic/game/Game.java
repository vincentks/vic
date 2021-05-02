package com.vincentks.vic.game;

public interface Game {
	CycleSummary cycle();

	void add(Actor actor, Item item);

	void remove(Actor actor, Item item);
}
