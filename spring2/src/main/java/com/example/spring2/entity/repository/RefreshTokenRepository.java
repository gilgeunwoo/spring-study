package com.example.spring2.entity.repository;

import com.nimbusds.oauth2.sdk.token.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> fintByRefreshToken(String refreshToken);
}
