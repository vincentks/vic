package com.vincentks.vic.game.event;

import com.vincentks.vic.game.Item;
import com.vincentks.vic.game.Location;
import com.vincentks.vic.game.LocationManager;
import com.vincentks.vic.game.MobileItem;

public class MoveEvent implements Event {
	private final MobileItem item;
	private final Location location;
	private final LocationManager manager;

	public MoveEvent(
		MobileItem item,
		Location location,
		LocationManager manager
	) {
		this.item = item;
		this.location = location;
		this.manager = manager;
	}

	@Override
	public Item execute() {
		manager.move(item, location);
		return item;
	}
}
