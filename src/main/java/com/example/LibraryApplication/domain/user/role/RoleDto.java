package com.example.LibraryApplication.domain.user.role;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private Integer id;
    private String name;
}