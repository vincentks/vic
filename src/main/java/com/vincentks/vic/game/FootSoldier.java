package com.vincentks.vic.game;

import java.util.UUID;

// TODO review how to address this item type: are they needed when fighting is implemented?
public class FootSoldier implements MobileItem {
	private final UUID id = UUID.randomUUID();

	@Override
	public Effort buildEffort() {
		return new Effort(1);
	}

	@Override
	public UUID getId() {
		return id;
	}
}
