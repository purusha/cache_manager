package org.redisson.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomRedisConfig {

	private RedisClusterMode clusterMode = RedisClusterMode.SINGLE;

	private String address;

	private String password;

	private int connectionMinimumIdleSize;

	private int connectionPoolSize;

	private int idleConnectionTimeout;
}

