package com.vincentks.vic.game;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameDiffWrapper implements Game
{
  private static final Logger logger = LogManager.getLogger(GameDiffWrapper.class);

  private final Game  game;
  private final Actor actor;
  private final CycleDiffCollector cycleDiffCollector;
  private CycleSummary previousCycleSummary;

  public GameDiffWrapper(Game game, Actor actor, CycleDiffCollector cycleDiffCollector)
  {
    this.game = game;
    this.actor = actor;
    this.cycleDiffCollector = cycleDiffCollector;
  }

  @Override
  public CycleSummary cycle()
  {
    final CycleSummary result = game.cycle();
    if (previousCycleSummary != null)
    {
      cycleDiffCollector.clear();
      for (DiffAware item : result.itemsFor(actor).getItems())
      {
        logger.info("Summary for " + item);
        final Optional<Item> itemInPreviousCycle = previousCycleSummary.getById(item.getId());
        if (itemInPreviousCycle.isPresent())
          cycleDiffCollector.collect(item.diff(itemInPreviousCycle.get()));
      }
    }
    previousCycleSummary = result;
    return result;
  }

  @Override
  public void add(Actor actor, Item city)
  {
    game.add(actor, city);
  }
}
