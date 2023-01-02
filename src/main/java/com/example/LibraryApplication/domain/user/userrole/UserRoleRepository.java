package com.example.LibraryApplication.domain.user.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("select u from UserRole u where u.user.id = ?1")
    UserRole findUserRole(Integer userId);

    @Query("select u from UserRole u where u.user.id = ?1 and u.role.id = ?2")
    Optional<UserRole> findUserRoleByUserIdAndRoleId(Integer userId, int roleId);
}