package com.relatech.cachemanager.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserCache implements Serializable {

    @Id
    private Long id;

    private String username;
    private String password;
    private String role;
    private String status;

    private LocalDateTime created;

    @Column(name = "last_update")
    private LocalDateTime modified;
}
