package com.yasar.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yasar.exception.ErrorType;
import com.yasar.exception.UserProfileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {
    @Value("${jwt.secret}")
    private String secretkey;
    @Value("${jwt.issuer}")
    private String issuer;
    private Long expiration = 1000 * 60 * 5L;


    public Optional<Long> getAuthIdFromToken(String token) {
        DecodedJWT jwt = verifyToken(token);
        Long authId = jwt.getClaim("authId").asLong();
        return Optional.ofNullable(authId);
    }

    public Optional<String> getAuthRoleFromToken(String token) {
        DecodedJWT jwt = verifyToken(token);
        String role = jwt.getClaim("role").asString();
        return Optional.ofNullable(role);
    }


    public DecodedJWT verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC512(secretkey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(issuer).build();
        DecodedJWT jwt = jwtVerifier.verify(token);
        return Optional.ofNullable(jwt).orElseThrow(() -> new UserProfileException(ErrorType.INVALID_TOKEN));
    }
}
