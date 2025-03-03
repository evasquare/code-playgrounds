package com.evasquare.jwt_authentication.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    private long id;

    @Nonnull
    private String username;
    @Nonnull
    private String hashedPassword;
    @Nonnull
    private String userRole;
}
