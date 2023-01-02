package com.example.LibraryApplication.domain.user.userrole;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;


@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;


    public UserRole getUserRoleById(Integer userId) {
        return userRoleRepository.findUserRole(userId);

    }

    public Optional<UserRole> getUserRoleByUserIdAndRoleId(Integer userId, int roleId) {
        return userRoleRepository.findUserRoleByUserIdAndRoleId(userId, roleId);
    }
}
