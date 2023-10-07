package com.ionhax.demo.config;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.ionhax.demo.utils.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter{

    private final JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                final String authHeader = request.getHeader("Authorization");
                final String token;
                final String username;


                if(authHeader == null || authHeader.startsWith("Beared ")){
                    filterChain.doFilter(request, response);
                    return;
                }
                token = authHeader.substring(7);
                username = jwtUtil.extractUserEmail(token);
                // String token = authHeader.substring(7);
                // String username;
    }
    
}
