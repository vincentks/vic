package com.vincentks.vic.game.util;

import java.util.UUID;

import com.vincentks.vic.game.Effort;
import com.vincentks.vic.game.MobileItem;

public class NullMobileItem implements MobileItem {
	@Override
	public Effort buildEffort() {
		return Effort.noEffort;
	}

	@Override
	public UUID getId() {
		return UUID.randomUUID();
	}

}
