package com.web.demo.security.filter;

import com.web.demo.security.jwt.JwtUtils;
import com.web.demo.security.services.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        final String headerAuth = request.getHeader("Authorization");
        if (StringUtils.isEmpty(headerAuth) || (!StringUtils.startsWith(headerAuth, "Bearer ")
                && !StringUtils.startsWith(headerAuth, "Basic "))) {
            logger.error("Cannot set user authentication: {}");
        }
        if (StringUtils.isNotEmpty(headerAuth) && StringUtils.startsWith(headerAuth, "Bearer ")) {
            try {
                String jwt = parseJwt(headerAuth);
                if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                    String username = jwtUtils.getUserNameFromJwtToken(jwt);
                    loadUserByName(username,request);
                }
            } catch (Exception e) {
                logger.error("Cannot set user authentication: {}", e);
            }
        } else if (StringUtils.isNotEmpty(headerAuth) && StringUtils.startsWith(headerAuth, "Basic ")) {
            String credentials = getUsernameAndPassword(request);
            boolean validCred = credentialsNullCheck(credentials);
            if (validCred) {
                String username = credentials.split(":")[0];
                String password = credentials.split(":")[1];
                System.out.println("username::" + username + "===password::" + password);
                loadUserByName(username,request);
            }
        }

        filterChain.doFilter(request, response);
    }

    private void loadUserByName(String username,HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private boolean credentialsNullCheck(String credentials) {
        if (credentials.indexOf(":") >= 3
                && (credentials.length() - credentials.indexOf(":")) >= 3) {
            return true;
        }
        return false;
    }

    private String getUsernameAndPassword(HttpServletRequest request) {
        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        return new String(Base64.getDecoder().decode(authorization.substring(6)));
    }

    private String parseJwt(String headerAuth) {

        if (StringUtils.isNotEmpty(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
