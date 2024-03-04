package com.example.demo.security;

import org.springframework.security.oauth2.jose.jws.MacAlgorithm;

public class SecurityUtils {

    public static final String AUTHORITIES_KEY = "auth";

    public static final MacAlgorithm JWT_ALGORITHM = MacAlgorithm.HS512;
}
