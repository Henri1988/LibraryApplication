package com.example.LibraryApplication.service.authorizer;

import com.example.LibraryApplication.domain.user.userrole.UserRole;
import com.example.LibraryApplication.domain.user.userrole.UserRoleService;
import com.example.LibraryApplication.domain.user.usersession.UserSession;
import com.example.LibraryApplication.domain.user.usersession.UserSessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class AuthorizerService {
    @Resource
    UserSessionService userSessionService;
    @Resource
    UserRoleService userRoleService;

    final int ADMIN_ROLE_ID = 2;
    final int USER_ROLE_ID = 1;

    public void authorizeAsAdmin(int userSessionId) throws Exception {
        authorize(userSessionId, ADMIN_ROLE_ID);
    }

    public void authorizeAsUser(int userSessionId) throws Exception {
        authorize(userSessionId, USER_ROLE_ID);
    }

    private void authorize(int userSessionId, int roleId) throws Exception {
        Optional<UserSession> userSession = userSessionService.getById(userSessionId);
        if (userSession.isEmpty()) {
            throw new AuthenticationException("Session not found");
        }
        if (userSession.get().getExpiresAt().isBefore(LocalDate.now())) {
            throw new AuthenticationException("Session expired");
        }

        Optional<UserRole> userRole = userRoleService.getUserRoleByUserIdAndRoleId(
                userSession.get().getUser().getId(),
                roleId);
        if (userRole.isEmpty()) {
            throw new AuthenticationException("User role not allowed");
        }
    }
}
