package com.relatech.cachemanager.controller;

import com.relatech.cachemanager.dto.UserCacheDTO;
import com.relatech.cachemanager.service.CacheService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class CacheController {

    private final CacheService service;

    @Operation(description = "Get all users from database")
    @GetMapping("/users")
    List<UserCacheDTO> users() {
        return service.getUsers();
    }

    @Operation(description = "Get all users from cache")
    @GetMapping("/users/cached")
    List<UserCacheDTO> cachedUsers() {
        return service.getCachedUsers();
    }

    @Operation(description = "Put users on cache")
    @PostMapping("/users/cache")
    List<UserCacheDTO> cacheUsers(@RequestBody List<UserCacheDTO> users) {
        return service.cacheUsers(users);
    }

    @Operation(description = "Delete all users from cache")
    @DeleteMapping("/users/cached")
    List<UserCacheDTO> deleteCachedUsers() {
        return service.deleteCachedUsers();
    }
}
