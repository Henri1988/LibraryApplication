package com.example.LibraryApplication.service.login;
import com.example.LibraryApplication.domain.user.contact.Contact;
import com.example.LibraryApplication.domain.user.contact.ContactService;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.domain.user.user.UserService;
import com.example.LibraryApplication.domain.user.userrole.UserRole;
import com.example.LibraryApplication.domain.user.userrole.UserRoleService;
import com.example.LibraryApplication.domain.user.usersession.UserSession;
import com.example.LibraryApplication.domain.user.usersession.UserSessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
@Slf4j
public class LogInService {

    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private ContactService contactService;

    @Resource
    private UserSessionService userSessionService;

    public LogInResponse logInRequest(LogInRequest request) {
        LogInResponse logInResponse = new LogInResponse();

        User user = userService.getValidUser(request);
        Integer userId = user.getId();
        logInResponse.setUserId(userId);

        Contact contact = contactService.getUserFirstLastNameById(userId);
        logInResponse.setPersonName(contact.getFirstName() + " " + contact.getLastName());

        UserRole userRole = userRoleService.getUserRoleById(userId);
        logInResponse.setUserRoleId(userRole.getRole().getId());

        UserSession userSession = userSessionService.createNewSession(user);
        logInResponse.setUserSessionId(userSession.getId());

        return logInResponse;

    }
}
