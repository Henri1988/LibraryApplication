package com.example.LibraryApplication.domain.user.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("select u from UserRole u where u.user.id = ?1")
    UserRole findUserRole(Integer userId);

}