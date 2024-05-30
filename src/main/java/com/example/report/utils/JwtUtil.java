package com.example.report.utils;

import com.example.report.pojo.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtUtil {
    private static final String KEY = "JWT_SIGN_KEY";
    private static final long expireTime = 1000 * 60 * 60;
    public String generate(UserEntity user) {
        String username = String.valueOf(user.getUser_id());
        Claims claims = Jwts.claims().setSubject(username);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(SignatureAlgorithm.HS256, KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
    }
    public boolean validate(String token) {
        return getClaims(token) != null && isExpired(token);
    }
    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }
    public Boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(KEY.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }
}
