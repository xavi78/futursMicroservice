package com.geekshubs.auth.infrastructure.services.jwt;

import javax.servlet.http.HttpServletRequest;

public interface JwtService {
    String getJwt(String username, HttpServletRequest request);
}
