package com.user.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.config.JwtService;
import com.user.model.Role;
import com.user.model.User;
import com.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationReponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
                userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationReponse.builder()
        .token(jwtToken).build();

                        
    }

    public AuthenticationReponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken( request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();

        return null;
    }
    
}
