package assignment.lab6.filter;

import assignment.lab6.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    final private JWTUtil jwtUtil;
    final private UserDetailsService userDetailsService;

    public JWTFilter(JWTUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        UserDetails userDetails = null;

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")){
            String requestPath = request.getServletPath();
            String requestMethod = request.getMethod();

            if(!(requestMethod.equals("POST") && (requestPath.equals("/api/v1/users") ||
                    requestPath.equals("/api/v1/authenticate")))) {
                response.sendError(401);
                return;
            }
        }
        else {
            String token = authorizationHeader.substring(7);

            try {
                jwtUtil.validateAccessToken(token);
            }
            catch (ExpiredJwtException e) {
                if(!request.getServletPath().equals("/api/v1/authenticate/refresh")) {
                    response.sendError(401, "TOKEN_EXPIRED");
                    return;
                }
            }
            catch (JwtException e) {
                System.out.println(e.getMessage());
                response.sendError(401);
                return;
            }

            String username = jwtUtil.getUsernameFromToken(token);
            userDetails = userDetailsService.loadUserByUsername(username);

            if(username == null || userDetails == null) {
                response.sendError(401); // Unknown user, so unauthorized
                return;
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
