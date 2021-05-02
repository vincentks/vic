package com.vincentks.vic.game;

public class Location {
	private final Terrain terrain;
	private final Integer y;
	private final Integer x;

	public Location(Terrain terrain) {
		this(terrain, 0, 0);
	}

	public Location(Terrain terrain, int x, int y) {
		this.terrain = terrain;
		this.x = x;
		this.y = y;
	}

	public double getGrowthFactor() {
		return terrain.getGrowthFactor();
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}
}
