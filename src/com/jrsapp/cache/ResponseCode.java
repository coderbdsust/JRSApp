package com.jrsapp.cache;

public enum ResponseCode {

	SUCCESS(0), FAILED(1), TIMEOUT(-1), PENDING(2), UNKNOWN(-2);

	int value;

	ResponseCode(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}

}
