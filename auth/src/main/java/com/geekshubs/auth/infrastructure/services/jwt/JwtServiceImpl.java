package com.geekshubs.auth.infrastructure.services.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl implements JwtService{
    private String secretKey = "clave_secreta";
    Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Override
    public String getJwt(String username, HttpServletRequest request) {

        logger.info("Accediento a la creación del jwt");
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        String token= Jwts
                    .builder()
                    .claim("ip", request.getRemoteAddr())
                    .setId("futurs")
                    .setSubject(username)
                    .claim("authorities",grantedAuthorities.stream()
                                   .map(GrantedAuthority::getAuthority)
                                    .collect(Collectors.toList()))
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis()+6000000))
                    .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()).compact();
                    return "Bearer " + token;

    }
}
