package com.example.spring2.service;

import com.example.spring2.dto.request.SignupRequest;
import com.example.spring2.dto.response.TokenResponse;
import com.example.spring2.entity.RefreshToken;
import com.example.spring2.entity.Role;
import com.example.spring2.entity.User;
import com.example.spring2.entity.repository.RefreshTokenRepository;
import com.example.spring2.entity.repository.UserRepository;
import com.example.spring2.exception.InvalidTokenException;
import com.example.spring2.exception.RefreshTokenNotFoundException;
import com.example.spring2.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceIpm implements AuthService {

    @Value("${jwt.exp.refresh}")
    private Long REFRESH_TOKEN_EXPIRATION_TIME;

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequest signupRequest) {
        userRepository.save(User.builder()
                .username(signupRequest.getUsername())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .role(Role.ROLE_USER)
                .build());
    }

    @Transactional
    public TokenResponse createToken(String username) {
        String accessToken = jwtTokenProvider.createAccessToken(username);
        String refreshToken = jwtTokenProvider.createRefreshToken(username);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .username(username)
                        .refreshToken(refreshToken)
                        .refreshTokenExpiration(REFRESH_TOKEN_EXPIRATION_TIME)
                        .build());

        return new TokenResponse(accessToken, refreshToken);
    }

    @Override
    @Transactional
    public TokenResponse reissue(String refreshToken) {
        if (!JwtTokenProvider.isRefreshToken(refreshToken)) {
            throw InvalidTokenException.EXCEPTION;
        }

        RefreshToken newRefreshToken = refreshTokenRepository.fintByRefreshToken(refreshToken)
                .map(refresh -> refreshTokenRepository.save(
                        refresh.update(REFRESH_TOKEN_EXPIRATION_TIME)
                ))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        return new TokenResponse(jwtTokenProvider.createAccessToken(newRefreshToken.getUsername()), refreshToken);
    }
}
