package com.vincentks.vic.game;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;

public class CityBuilder {
	private String name = "Amsterdam";
	private int population = 0;
	private UUID id = UUID.randomUUID();
	private Location location = new Location(Terrain.STANDARD);
	private Effort buildEffortSpent = new Effort(0);
	private Optional<Item> currentlyBuilding = Optional.empty();
	private Collection<Item> elements = Collections.emptyList();
	private Queue<Item> buildQueue = new LinkedList<>();

	public CityBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public CityBuilder setPopulation(int population) {
		this.population = population;
		return this;
	}

	public CityBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public CityBuilder setLocation(Location location) {
		this.location = location;
		return this;
	}

	public CityBuilder setBuildEffortSpent(Effort buildEffortSpent) {
		this.buildEffortSpent = buildEffortSpent;
		return this;
	}

	public CityBuilder setCurrentlyBuilding(Optional<Item> currentlyBuilding) {
		this.currentlyBuilding = currentlyBuilding;
		return this;
	}

	public CityBuilder setElements(Collection<Item> elements) {
		this.elements = elements;
		return this;
	}

	public CityBuilder setBuildQueue(Queue<Item> buildQueue) {
		this.buildQueue = buildQueue;
		return this;
	}

	public City build() {
		return new City(
			id,
			name,
			population,
			location,
			buildEffortSpent,
			currentlyBuilding,
			elements,
			buildQueue
		);
	}
}
