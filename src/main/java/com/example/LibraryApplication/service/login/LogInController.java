package com.example.LibraryApplication.service.login;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class LogInController {

    @Resource
    private LogInService logInService;

    @PostMapping("/login")
    @Operation(summary = "Login into system")
    public LogInResponse logInRequest(@RequestBody LogInRequest request) {
        return logInService.logInRequest(request);
    }
}
