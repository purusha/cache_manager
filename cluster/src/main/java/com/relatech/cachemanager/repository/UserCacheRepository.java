package com.relatech.cachemanager.repository;

import com.relatech.cachemanager.model.UserCache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCacheRepository extends JpaRepository<UserCache, Long> {

}
