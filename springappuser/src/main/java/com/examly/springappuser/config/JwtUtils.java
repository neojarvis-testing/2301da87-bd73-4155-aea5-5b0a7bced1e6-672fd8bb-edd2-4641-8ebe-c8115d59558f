package com.examly.springappuser.config;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    private final String jwtSecret = "examlysecret";
    private final long jwtExpiration = 86400000;
    public String generateToken(Authentication authentication){
        UserDetails userPrincipal = (UserDetails)authentication.getPrincipal();
        return jwts.builder().setSubject(userPrincipal.getUsername()).claim("roles",userPrincipal.getAuthorities().toString())
        .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+jwtExpiration))
        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
            jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
