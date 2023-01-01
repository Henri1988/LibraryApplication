package com.example.LibraryApplication.domain.user.user;

import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.domain.user.user.UserMapper;
import com.example.LibraryApplication.domain.user.user.UserRepository;
import com.example.LibraryApplication.service.login.LogInRequest;
import com.example.LibraryApplication.service.register.RegisterRequest;
import com.example.LibraryApplication.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;


@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRepository userRepository;
    @Resource
    private ValidationService validationService;


    public User addNewUser(RegisterRequest request) {
        User user = userMapper.toEntity(request);
        String username = request.getUserName();
        boolean userExists = userRepository.existsByUsername(username);
        validationService.userNameAlreadyExists(username, userExists);
        userRepository.save(user);
        return user;
    }


    public User findUserInfoById(Integer id) {
        Optional<User> user = userRepository.findUserById(id);
        return user.get();
    }

    public User getUserById(Integer userId) {
        return userRepository.getById(userId);
    }

    public User getValidUser(LogInRequest request) {
        Optional<User> user = userRepository.findByUsernameAndPassword(request.getUserName(), request.getPassword());
        validationService.userExists(user);
        return user.get();
    }
}
