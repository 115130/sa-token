package com.bysj.satoken.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtils {
    //过期时间
    private static final long EXPIRE = 1000 * 60 * 60 * 24;
    //加密密钥
    private static final String APP_SECRET = "GYd1as2FSdsYUgY43UIGg43yDSAgDSAuDSyUdsY65dU564Gd3YU3GYUG0Y3U";

    /**
     * 校验token是否正确
     *
     * @param token    jwt密匙
     * @param username
     * @param id
     * @return
     */
    public static boolean verify(String token, String id,
                                 String username, String nike,
                                 String authority) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(APP_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("id", id)
                    .withClaim("email", username)
                    .withClaim("authority", authority)
                    .withClaim("nike", nike)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("email").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getAuthority(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("authority").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getNike(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("nike").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("id").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param id       用户id
     * @return 加密的token
     */
    public static String sign(String id,
                              String username, String nike,
                              String authority) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE);
        Algorithm algorithm = Algorithm.HMAC256(APP_SECRET);
        // 附带username信息
        return JWT.create()
                .withClaim("id", id)
                .withClaim("email", username)
                .withClaim("authority", authority)
                .withClaim("nike", nike)
                .withExpiresAt(date)
                .sign(algorithm);
    }

}
