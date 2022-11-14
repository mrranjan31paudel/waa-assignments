package assignment.lab5.service.impl;

import assignment.lab5.domain.dto.LoginRequestDto;
import assignment.lab5.domain.dto.LoginResponseDto;
import assignment.lab5.service.AuthenticationService;
import assignment.lab5.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    final private AuthenticationManager authenticationManager;
    final private UserDetailsService userDetailsService;
    final private JWTUtil jwtUtil;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()));

        UserDetails userDetailsDto = userDetailsService.loadUserByUsername(loginRequestDto.getUsername());
        String accessToken = jwtUtil.generateAccessToken(userDetailsDto);

        return new LoginResponseDto(accessToken);
    }
}
