package assignment.lab5.util;

import assignment.lab5.domain.dto.UserAuthDetailsDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    final private static long ACCESS_TOKEN_LIFE_IN_MS = 60 * 60 * 1000; // 1 hour
    final private static String JWT_SECRET = "uieowslkdfjksf45";

    private String doGenerateToken(Map<String, Object> claims, UserDetails subject) {
        UserAuthDetailsDto userAuthDetailsDto = (UserAuthDetailsDto) subject;

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userAuthDetailsDto.getUsername())
                .setSubject(userAuthDetailsDto.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_LIFE_IN_MS))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String generateAccessToken(UserDetails userAuthDetailsDto) {
        Map<String, Object> claims = new HashMap<>();

        return doGenerateToken(claims, userAuthDetailsDto);
    }
}
