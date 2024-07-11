package com.relatech.cachemanager.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserCacheDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String role;
    private String status;
    private LocalDateTime created;
    private LocalDateTime modified;
}
