package com.vincentks.vic.game;

public class CycleDiff
{
  private final RelevanceLevel level;
  private final String message;

  public CycleDiff(RelevanceLevel level, String message)
  {
    this.level = level;
    this.message = message;
  }

  public RelevanceLevel getLevel()
  {
    return level;
  }

  public String getMessage()
  {
    return message;
  }
}
