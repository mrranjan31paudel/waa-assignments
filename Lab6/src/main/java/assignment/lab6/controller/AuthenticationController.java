package assignment.lab6.controller;

import assignment.lab6.domain.dto.LoginRequestDto;
import assignment.lab6.domain.dto.LoginResponseDto;
import assignment.lab6.domain.dto.RefreshTokenRequestDto;
import assignment.lab6.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

    @PostMapping("/refresh")
    public LoginResponseDto refreshToken(@Valid @RequestBody RefreshTokenRequestDto refreshTokenRequestDto) {
        return authenticationService.refresh(refreshTokenRequestDto);
    }
}
