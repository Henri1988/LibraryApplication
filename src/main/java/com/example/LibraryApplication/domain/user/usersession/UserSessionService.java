package com.example.LibraryApplication.domain.user.usersession;

import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.domain.user.userrole.UserRole;
import com.example.LibraryApplication.domain.user.userrole.UserRoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Optional;


@Service
public class UserSessionService {
    @Resource
    private UserSessionRepository userSessionRepository;

    public UserSession createNewSession(User user) {
        UserSession userSession = new UserSession();
        userSession.setUser(user);
        userSession.setExpiresAt(LocalDate.now().plusDays(14));
        userSessionRepository.save(userSession);

        return userSession;
    }

    public Optional<UserSession> getById(int userSessionId) {
        return userSessionRepository.getUserSessionById(userSessionId);
    }
}
