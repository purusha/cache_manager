package com.relatech.cachemanager.config;

import org.redisson.config.CustomRedisConfig;
import org.redisson.config.CustomRedissonPropertyParser;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "cachemanager.redis")
	public CustomRedisConfig customRedisConfig() {
		return new CustomRedisConfig();
	}

	@Bean
	public CustomRedissonPropertyParser customerRedissonPropertyParser(CustomRedisConfig customRedisConfig) {
		return new CustomRedissonPropertyParser(customRedisConfig);
	}
}
