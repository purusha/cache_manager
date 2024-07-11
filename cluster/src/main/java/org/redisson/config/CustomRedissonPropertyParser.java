package org.redisson.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class CustomRedissonPropertyParser implements RedissonAutoConfigurationCustomizer {

	private final CustomRedisConfig customRedisConfig;

	public CustomRedissonPropertyParser(CustomRedisConfig customRedisConfig) {
		this.customRedisConfig = customRedisConfig;
	}

	@Override
	public void customize(Config configuration) {

		RedisClusterMode clusterMode = customRedisConfig.getClusterMode();

		switch (clusterMode) {
		case SINGLE:
			setupSingleServer(configuration);
			break;
		case CLUSTER:
			setupCluster(configuration);
			break;
		default:
			throw new UnsupportedOperationException("I don't know how to configure it -> " + clusterMode);
		}

		configuration.setCodec(new CompatibleKryo5Codec());

	}

	private void setupSingleServer(Config configuration) {
		String address = customRedisConfig.getAddress();
		log.info("Setup single server {}", address);

		SingleServerConfig singleServerConfig = configuration.getSingleServerConfig();
		singleServerConfig.setAddress(address);
		singleServerConfig.setPassword(customRedisConfig.getPassword());
		singleServerConfig.setConnectionMinimumIdleSize(customRedisConfig.getConnectionMinimumIdleSize());
		singleServerConfig.setConnectionPoolSize(customRedisConfig.getConnectionPoolSize());
		singleServerConfig.setIdleConnectionTimeout(customRedisConfig.getIdleConnectionTimeout());
	}

	private void setupCluster(Config configuration) {
		String address = customRedisConfig.getAddress();
		log.info("Setup cluster {}", address);

		configuration.setSingleServerConfig(null);

		ClusterServersConfig clusterServersConfig = new ClusterServersConfig();
		clusterServersConfig.setNodeAddresses(getAddresses(address));
		clusterServersConfig.setPassword(customRedisConfig.getPassword());

		int connectionPoolSize = customRedisConfig.getConnectionPoolSize();
		clusterServersConfig.setSlaveConnectionPoolSize(connectionPoolSize);
		clusterServersConfig.setMasterConnectionPoolSize(connectionPoolSize);

		int connectionMinimumIdleSize = customRedisConfig.getConnectionMinimumIdleSize();
		clusterServersConfig.setSlaveConnectionMinimumIdleSize(connectionMinimumIdleSize);
		clusterServersConfig.setMasterConnectionMinimumIdleSize(connectionMinimumIdleSize);

		clusterServersConfig.setIdleConnectionTimeout(customRedisConfig.getIdleConnectionTimeout());

		configuration.useClusterServers(clusterServersConfig);
	}

	private List<String> getAddresses(String address) {
		return Arrays.asList(address.split(","));
	}
}
