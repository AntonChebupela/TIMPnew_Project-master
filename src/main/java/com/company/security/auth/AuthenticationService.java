package com.company.security.auth;


import com.company.token.TokenService;
import com.company.user.Role;
import com.company.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.company.user.User;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .role(Role.CLIENT)
                .build();
        repository.save(user);
        String privateKey = tokenService.generatePrivateKey(user, 1000* 60 * 60 * 24* 15);
        String publicKey = tokenService.generatePublicKey(user, 1000* 60 * 30);
        return AuthenticationResponse.builder().privateKey(privateKey).publicKey(publicKey).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.getByUsername(request.getUsername())
                .orElseThrow();
        String privateKey = tokenService.generatePrivateKey(user, 1000* 60 * 60 * 24* 15);
        String publicKey = tokenService.generatePublicKey(user, 1000* 60 * 30);
        return AuthenticationResponse.builder().privateKey(privateKey).publicKey(publicKey).build();
    }
}