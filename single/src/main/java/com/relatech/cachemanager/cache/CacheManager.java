package com.relatech.cachemanager.cache;

import com.relatech.cachemanager.dto.UserCacheDTO;

import java.util.List;

public interface CacheManager {

    List<UserCacheDTO> cacheUsers(List<UserCacheDTO> users);

    List<UserCacheDTO> getCachedUsers();

    List<UserCacheDTO> deleteCachedUsers();
}
