package com.gislab.zhsou.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: dai
 * @date: 2022/5/9
 */
public class JWTUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;
    private static final String SECRET = "ZHSOU";

    public static String generateToken(Long userId) {
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(CLAIM_KEY_USERNAME, userId);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(Instant.now().toEpochMilli() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public static Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationDate(token);
        return expirationDate.before(Date.from(Instant.now()));
    }

    public static Date getExpirationDate(String token) {
        return getClaims(token).getExpiration();
    }

    public static Long getUserId(String token) {
        return Long.valueOf(getClaims(token).getSubject());
    }
}
