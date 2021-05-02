package com.vincentks.vic.game;

public class SettleEvent implements Event {
	private final Settler settler;
	private final Actor actor;
	private final Game game;
	private final String name;
	private final Location location;

	public SettleEvent(
		Settler settler,
		String name,
		Actor actor,
		Game game,
		Location location
	) {
		this.settler = settler;
		this.name = name;
		this.actor = actor;
		this.game = game;
		this.location = location;
	}

	@Override
	public Item execute() {
		final City city = new CityBuilder()
			.setLocation(location)
			.setPopulation(City.INITIAL_POPULATION)
			.setName(name)
			.build();
		game.add(actor, city);
		game.remove(actor, settler);
		return settler;
	}
}
