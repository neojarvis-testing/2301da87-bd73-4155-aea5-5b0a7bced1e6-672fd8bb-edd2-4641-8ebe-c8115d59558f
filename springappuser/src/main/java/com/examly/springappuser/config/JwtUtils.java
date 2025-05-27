package com.examly.springappuser.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private long jwtExpiration;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public long getJwtExpiration() {
        return jwtExpiration;
    }
    public String generateToken(String email){
        return Jwts.builder().setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+jwtExpiration))
        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }
        catch(JwtException|IllegalArgumentException e){
            return false;
        }
    }
    // public String generateToken(Authentication authentication) {
    //     UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
    //     return Jwts.builder().setSubject(userPrincipal.getUsername())
    //             .claim("roles", userPrincipal.getAuthorities().stream()
    //             .map(GrantedAuthority::getAuthority).toList())
    //             .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
    //             .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    // }

    // public String extractUsername(String token) {
    //    return extractAllClaims(token).getSubject();
    // }

    // public boolean validateToken(String token) {
    //     try {
    //         extractAllClaims(token);
    //         return true;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }
    // private Claims extractAllClaims(String token){
    //     return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    // }
}
