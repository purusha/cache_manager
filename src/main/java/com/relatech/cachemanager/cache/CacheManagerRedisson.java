package com.relatech.cachemanager.cache;

import com.relatech.cachemanager.dto.UserCacheDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class CacheManagerRedisson implements CacheManager {

    private static final String USERS_KEY = "users";

    private final RedissonClient redisson;

    @Override
    public List<UserCacheDTO> cacheUsers(List<UserCacheDTO> users) {

        RBucket<List<UserCacheDTO>> bucket = redisson.getBucket(USERS_KEY);
        if (!bucket.isExists()) {
            log.info("Put user on cache.");
            bucket.set(users, 2, TimeUnit.MINUTES);
        }
        log.info("Retrieving user from cache.");
        return bucket.get();
    }

    @Override
    public List<UserCacheDTO> getCachedUsers() {

        RBucket<List<UserCacheDTO>> bucket = redisson.getBucket(USERS_KEY);

        return bucket.get();
    }

    @Override
    public List<UserCacheDTO> deleteCachedUsers() {

        RBucket<List<UserCacheDTO>> bucket = redisson.getBucket(USERS_KEY);
        if (bucket.isExists()) {
            bucket.delete();
        }
        return bucket.get();
    }
}
