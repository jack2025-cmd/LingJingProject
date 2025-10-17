package com.gzu.divination.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    // JWT 密钥
    private static final String SECRET = "PCBBoardDetection@2025-4-23@114yajyusenpai514###1919810!";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    // 过期时间：1 天（毫秒）
    private static final long EXPIRATION = 86400000L;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 生成 Token（包含 Long 类型的 id）
     */
    public static String generateToken(Long id) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(id))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY)
                .compact();
    }

    /**
     * 解析 Token，用户 id
     */
    public static Long getUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

        // 解析token
        Object idObj = claims.get("id");
        if (idObj instanceof Integer) {
            return ((Integer) idObj).longValue();
        } else if (idObj instanceof Long) {
            return (Long) idObj;
        } else if (idObj instanceof String) {
            return Long.parseLong((String) idObj);
        } else {
            throw new IllegalArgumentException("Token 中的 id 类型不合法");
        }
    }

    /**
     * 密码加密
     */
    public static String encodePassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * 密码验证
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
