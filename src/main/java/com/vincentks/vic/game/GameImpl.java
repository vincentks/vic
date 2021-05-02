package com.vincentks.vic.game;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class GameImpl implements Game {
	private final List<Pair<Actor, Item>> items = Lists.newArrayList();
	private int cycleId;

	@Override
	public void add(Actor actor, Item item) {
		items.add(new Pair<>(actor, item));
	}

	@Override
	public void remove(Actor actor, Item item) {
		items.remove(new Pair<>(actor, item));
	}

	@Override
	public CycleSummary cycle() {
		for (int i = 0; i < items.size(); i++) {
			final Pair<Actor, Item> pair = items.get(i);
			if (pair.getSecond().isCyclable()) {
				final Cyclable cyclable = (Cyclable) pair.getSecond();
				final Item item = cyclable.cycle();
				items.set(i, new Pair<>(pair.getFirst(), item));
			}
		}
		return new CycleSummaryImpl(++cycleId, this.getDiffAwareItems(items));
	}

	private Collection<Pair<Actor, DiffAware>> getDiffAwareItems(List<Pair<Actor, Item>> items) {
		return items
			.stream()
			.filter(pair -> pair.getSecond().isDiffAware())
			.map(pair -> new Pair<>(pair.getFirst(), (DiffAware) pair.getSecond()))
			.collect(Collectors.toList());
	}
}
