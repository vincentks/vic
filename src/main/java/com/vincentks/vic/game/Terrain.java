package com.vincentks.vic.game;

public enum Terrain {
	STANDARD(1), DESERT(.1);

	private final double growthFactor;

	Terrain(double growthFactor) {
		this.growthFactor = growthFactor;
	}

	public double getGrowthFactor() {
		return growthFactor;
	}
}
