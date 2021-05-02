package com.vincentks.vic.game;

public interface LocationManager {
	Location getLocation(MobileItem item);

	void move(MobileItem item, Location location);
}
