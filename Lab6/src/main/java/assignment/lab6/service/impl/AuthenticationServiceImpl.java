package assignment.lab6.service.impl;

import assignment.lab6.domain.dto.LoginRequestDto;
import assignment.lab6.domain.dto.LoginResponseDto;
import assignment.lab6.domain.dto.RefreshTokenRequestDto;
import assignment.lab6.service.AuthenticationService;
import assignment.lab6.util.JWTUtil;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

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
        String refreshToken = jwtUtil.generateRefreshToken(userDetailsDto);

        return new LoginResponseDto(accessToken, refreshToken);
    }

    @Override
    public LoginResponseDto refresh(RefreshTokenRequestDto refreshTokenRequestDto) {
        String refreshToken = refreshTokenRequestDto.getRefreshToken();
        String username = null;

        try {
            username = jwtUtil.getUsernameFromRefreshToken(refreshToken);
        }
        catch (JwtException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if(userDetails == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        String newAccessToken = jwtUtil.generateAccessToken(userDetails);

        return new LoginResponseDto(newAccessToken, refreshToken);
    }
}
