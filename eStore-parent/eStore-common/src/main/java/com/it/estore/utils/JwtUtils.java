package com.it.estore.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * JWT工具类
 */
public class JwtUtils {

    // 令牌有效期 10min
    private static final Long JWT_TTL = 6000000L;

    // 令牌信息
    private static final String JWT_KEY = "zeng&#long*%yin$!666";

    public static String createJWT(String id,String subject,Long ttlMillis){
        // 指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 当前系统时间
        long nowMillis = System.currentTimeMillis();
        // 令牌签发时间
        Date now = new Date();

        // 如果令牌有效期为null，则默认设置10分钟
        if(ttlMillis==null){
            ttlMillis=JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        // 生成秘钥
        SecretKey secretKey = generateKey();

        // 封装Jwt令牌信息
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("zenglongyin")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);
        return builder.compact();
    }

    /**
     * 生成加密 SecretKey
     * @return SecretKey
     */
    public static SecretKey generateKey(){
        byte[] encode = Base64.getEncoder().encode(JWT_KEY.getBytes());
        SecretKey secretKey = new SecretKeySpec(encode,0,encode.length,"AES");
        return secretKey;
    }

    /**
     * 解析令牌数据
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey secretKey = generateKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
