package assignment.lab5.controller;

import assignment.lab5.domain.dto.LoginRequestDto;
import assignment.lab5.domain.dto.LoginResponseDto;
import assignment.lab5.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/authenticate")
@RestController
public class AuthenticationController {

    final private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto);
    }
}
