package com.example.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import static com.example.constants.constant.SECRET_KEY;

@Service
public class JWTService implements UserDetailsService {
    public String generateToken(UserDetails userDetails) {
       return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

    }
    public Key getKey() {
       byte[]bytes= Decoders.BASE64.decode(SECRET_KEY);
       return Keys.hmacShaKeyFor(bytes);
    }
public <T> T exportToken(String token, String claim, Class<T> type) {
        Claims claims = getClaims(token);
        return claims.get(claim, type);
    }
    public Claims getClaims(String Token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(Token)
                .getBody();
    }
    public boolean isTokenValid(String token) {
        Date expirationDate = exportToken(token, Claims.EXPIRATION, Date.class);
        return new Date().before(expirationDate);
    }
    public String getUsernameFromToken(String token) {
        return exportToken(token, Claims.SUBJECT, String.class);
    }



    @Override
    public UserDetails loadUserByUsername(String username) {
        // Replace this with your actual user retrieval logic
        return User.withUsername(username)
                .password("password") // Replace with the actual password
                .authorities(Collections.emptyList())
                .build();
    }

}
