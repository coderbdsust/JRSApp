package com.jrsapp.cache;

public enum Channel {
	App(1), Web(2), Desktop(3);

	int value;

	Channel(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}

}
