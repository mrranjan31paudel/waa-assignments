package assignment.lab5.service;

import assignment.lab5.domain.dto.LoginRequestDto;
import assignment.lab5.domain.dto.LoginResponseDto;

public interface AuthenticationService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
