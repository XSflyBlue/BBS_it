package com.neusoft.bbs.commons.config;

public class PowerConfig {
	
	public static int valueOfPower(Identity identity, Status status) {
		return identity.value()+status.value();
	}
}
