package com.deadman.taskmapper.infrastructure.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.deadman.taskmapper.domain.auth.User;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {
    private final String secret = "secret";
    private final Algorithm algorithm = Algorithm.HMAC256(secret);

    public String generateToken(User user) {
       return JWT.create()
               .withClaim("userId", user.getId())
               .withSubject(user.getEmail())
               .withExpiresAt(Instant.now().plusSeconds(180))
               .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {
        try {
            DecodedJWT decodedToken = JWT.require(algorithm)
                    .build()
                    .verify(token);

            JWTUserData userData = JWTUserData.builder()
                    .userId(decodedToken.getClaim("userId").asLong())
                    .email(decodedToken.getSubject())
                    .build();
            return Optional.of(userData);
        } catch (JWTVerificationException exception) {
            return Optional.empty();
        }
    }
}
