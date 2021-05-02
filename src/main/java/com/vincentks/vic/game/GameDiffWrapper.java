package com.vincentks.vic.game;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameDiffWrapper implements Game {
	private static final Logger logger = LogManager.getLogger(GameDiffWrapper.class);

	private final Game game;
	private final Actor actor;
	private final CycleDiffCollector collector;
	private CycleSummary previousCycleSummary;

	public GameDiffWrapper(
		Game game,
		Actor actor,
		CycleDiffCollector collector
	) {
		this.game = game;
		this.actor = actor;
		this.collector = collector;
	}

	@Override
	public CycleSummary cycle() {
		final CycleSummary result = game.cycle();
		if (previousCycleSummary != null) {
			collector.clear();
			for (DiffAware item : result.itemsFor(actor).getItems()) {
				logger.info("Summary for " + item);
				final Optional<Item> itemInPreviousCycle = previousCycleSummary.getById(item.getId());
				itemInPreviousCycle.ifPresent(value -> collector.collect(item.diff(value)));
			}
		}
		previousCycleSummary = result;
		return result;
	}

	@Override
	public void add(Actor actor, Item item) {
		game.add(actor, item);
	}

	@Override
	public void remove(Actor actor, Item item) {
		game.remove(actor, item);
	}
}
