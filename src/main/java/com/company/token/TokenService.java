package com.company.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenService {


    public String generatePrivateKey( UserDetails userDetails, long expiration) {
        return generatePrivateKey(null, userDetails, expiration);
    }
    public String generatePublicKey( UserDetails userDetails, long expiration) {
        return generatePublicKey(null, userDetails, expiration);
    }
    public String generatePrivateKey(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKeys().getPrivate(), SignatureAlgorithm.RS256)
                .compact();
    }
    public String generatePublicKey(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKeys().getPublic(), SignatureAlgorithm.RS256)
                .compact();
    }

    private KeyPair getSignInKeys() {
        return Keys.keyPairFor(SignatureAlgorithm.RS256);
    }
}
