package com.jvlcode.spring_boot_demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.Date;


public class JwtUtil {
    private static final String secretKey="DRTzrF1MvvwpDO3P/VjqAmpp0vYSYWdtrccAqGE6Ud4=";
    private final SecretKey bitKey= Keys.hmacShaKeyFor(secretKey.getBytes());

    public String authTokenGenerator(UserDetails userDetails){
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(bitKey,Jwts.SIG.HS256)
                .compact();
    }
}
