package com.relatech.cachemanager.service;

import com.relatech.cachemanager.cache.CacheManager;
import com.relatech.cachemanager.dto.UserCacheDTO;
import com.relatech.cachemanager.mapper.UserCacheMapper;
import com.relatech.cachemanager.repository.UserCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final UserCacheRepository userCacheRepository;

    private final UserCacheMapper userMapper;

    private final CacheManager cacheManager;

    public List<UserCacheDTO> getUsers() {
        return userMapper.userCachesToUserCacheDTOs(userCacheRepository.findAll());
    }

    public List<UserCacheDTO> cacheUsers(List<UserCacheDTO> users) {
        return cacheManager.cacheUsers(users);
    }

    public List<UserCacheDTO> getCachedUsers() {
        return cacheManager.getCachedUsers();
    }

    public List<UserCacheDTO> deleteCachedUsers() {
        return cacheManager.deleteCachedUsers();
    }
}
