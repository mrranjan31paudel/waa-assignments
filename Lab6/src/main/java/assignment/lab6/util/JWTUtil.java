package assignment.lab6.util;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    final private static long ACCESS_TOKEN_LIFE_IN_MS = 2 * 60 * 1000; // 2 minutes
    final private static long REFRESH_TOKEN_LIFE_IN_MS = 60 * 30 * 1000; // 30 minutes
    final private static String JWT_ACCESS_TOKEN_SECRET = "uieowslkdfjksf45";
    final private static String JWT_REFRESH_TOKEN_SECRET = "asfasdf";

    public String generateAccessToken(UserDetails userDetailsDto) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetailsDto.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_LIFE_IN_MS))
                .signWith(SignatureAlgorithm.HS512, JWT_ACCESS_TOKEN_SECRET)
                .compact();
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_LIFE_IN_MS))
                .signWith(SignatureAlgorithm.HS256, JWT_REFRESH_TOKEN_SECRET)
                .compact();
    }

    public String getUsernameFromToken(String token, String secret) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String getUsernameFromAccessToken(String token) {
        return getUsernameFromToken(token, JWT_ACCESS_TOKEN_SECRET);
    }

    public String getUsernameFromRefreshToken(String token) {
        return getUsernameFromToken(token, JWT_REFRESH_TOKEN_SECRET);
    }

    public void validateAccessToken(String token) {
        validateToken(token, JWT_ACCESS_TOKEN_SECRET);
    }

    public void validateRefreshToken(String token) {
        validateToken(token, JWT_REFRESH_TOKEN_SECRET);
    }

    private void validateToken(String token, String secret) {
        Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
    }
}
