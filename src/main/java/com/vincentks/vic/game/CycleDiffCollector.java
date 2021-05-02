package com.vincentks.vic.game;

import java.util.Collection;

import com.google.common.collect.Lists;

public class CycleDiffCollector {
	private Collection<CycleDiff> diffs = Lists.newArrayList();

	public Iterable<CycleDiff> getDiffs() {
		return diffs;
	}

	public void clear() {
		diffs = Lists.newArrayList();
	}

	public void collect(Collection<CycleDiff> diff) {
		diffs.addAll(diff);
	}
}
