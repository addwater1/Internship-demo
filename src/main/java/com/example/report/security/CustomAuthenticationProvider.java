package com.example.report.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authentication.getName());
        String rawPassword = String.valueOf(authentication.getCredentials());
        if (!passwordEncoder.matches(rawPassword, userDetails.getPassword()))
            throw new BadCredentialsException("Authentication Error");
        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                userDetails.getPassword()
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
