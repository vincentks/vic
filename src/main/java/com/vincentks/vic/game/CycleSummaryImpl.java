package com.vincentks.vic.game;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class CycleSummaryImpl implements CycleSummary {
	private Collection<Pair<Actor, DiffAware>> items;
	private int id;

	public CycleSummaryImpl(int id, Collection<Pair<Actor, DiffAware>> items) {
		this.id = id;
		this.items = items;
	}

	@Override
	public int numberOfItems() {
		return items.size();
	}

	@Override
	public boolean contains(Item item) {
		return items
			.stream()
			.anyMatch(actorItemPair -> actorItemPair.getSecond().equals(item));
	}

	@Override
	public CycleSummary itemsFor(Actor actor) {
		final Collection<Pair<Actor, DiffAware>> items = this.items
			.stream()
			.filter(actorItemPair -> actor.equals(actorItemPair.getFirst()))
			.collect(Collectors.toList());
		return new CycleSummaryImpl(getId(), items);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Iterable<DiffAware> getItems() {
		return items
			.stream()
			.map(Pair::getSecond)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<Item> getById(UUID itemId) {
		for (Item item : getItems())
			if (item.getId().equals(itemId))
				return Optional.of(item);
		return Optional.empty();
	}
}
