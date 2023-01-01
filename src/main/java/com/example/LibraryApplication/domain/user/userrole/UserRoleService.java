package com.example.LibraryApplication.domain.user.userrole;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;


    public UserRole getUserRoleById(Integer userId) {
        return userRoleRepository.findUserRole(userId);

    }
}
