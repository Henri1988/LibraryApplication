package com.example.LibraryApplication.service.register;
import com.example.LibraryApplication.domain.user.contact.ContactService;
import com.example.LibraryApplication.service.authorizer.AuthorizerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/profile")
public class RegisterController {
    @Resource
    private AuthorizerService authorizerService;
    @Resource
    private RegisterService registerService;

    @PostMapping("/register")
    @Operation(summary = "Adds new user")
    public RegisterResponse registerNewUser(@RequestBody RegisterRequest request) throws Exception {
        authorizerService.authorizeAsAdmin(request.getUserSessionId());
        return registerService.registerNewUser(request);
    }

    @GetMapping("/user-info/by/id")
    @Operation(summary = "Finds user info by id")
    public RegisterRequest findUserInfoById (@RequestParam Integer id, @RequestParam Integer userSessionId) throws Exception {
        authorizerService.authorizeAsAdmin(userSessionId);
        return registerService.findUserInfoById(id, userSessionId);
    }


    @GetMapping("/user-info/by/lastName")
    @Operation(summary = "Finds user info by last name")
    public RegisterRequest findUserInfoByLastName (@RequestParam String lastName, @RequestParam Integer userSessionId) throws Exception {
        authorizerService.authorizeAsAdmin(userSessionId);
        return registerService.findUserInfoByLastName(lastName, userSessionId);
    }

}
