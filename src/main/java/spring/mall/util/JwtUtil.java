package spring.mall.util;

import io.jsonwebtoken.*;
import spring.mall.web.user.model.User;
import spring.mall.web.user.model.UserSimple;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    private static int time = 1000 * 60 * 60 * 24;
    private static final String signature = "admin";
    public static String createToken(User user) {
        JwtBuilder jwtBuilder = Jwts.builder();
        return jwtBuilder.setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", user.getUsername())
                .claim("password", user.getPassword())
                .claim("user_id", user.getId())
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
    }

    public static UserSimple parseToken(String token) {
        Jws<Claims> claimsJws = validateToken(token);
        if (claimsJws == null) {
            return null;
        }
        Claims claims = claimsJws.getBody();
        String username = (String) claims.get("username");
        long user_id = (Integer) claims.get("user_id");
        return new UserSimple(user_id, username);
    }

    public static Jws<Claims> validateToken(String token) {
        if (token == null) return null;
        try {
            return Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return null;
        }
    }
}
