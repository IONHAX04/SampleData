package com.ionhax.demo.utils;

public class JwtUtil {

    public String extractUserEmail(String token) {
        return extractClaim(token, Claims);
    }
    
}
