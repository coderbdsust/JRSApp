package com.jrsapp.cache;

public enum Service {
	PROFILE_SAVE(1), PROFILE_INFO(2), PROFIILE_UPDATE(3), PROFILE_DELETE(4);

	int value;

	Service(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}
}
