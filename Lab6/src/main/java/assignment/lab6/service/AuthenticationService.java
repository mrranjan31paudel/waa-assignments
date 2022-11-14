package assignment.lab6.service;

import assignment.lab6.domain.dto.LoginRequestDto;
import assignment.lab6.domain.dto.LoginResponseDto;
import assignment.lab6.domain.dto.RefreshTokenRequestDto;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);

    LoginResponseDto refresh(RefreshTokenRequestDto refreshTokenRequestDto);
}
