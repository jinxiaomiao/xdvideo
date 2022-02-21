package net.xdclass.xdvideo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.xdvideo.domain.User;

import java.util.Date;

/**
 * @author jinxm
 * @date 2022-02-18
 * @description jwt工具类
 */
public class JwtUtils {

    public static final  String SUBJECT = "xdclass";

    //过期时间，毫秒，一周
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    public static final String APPSECRET = "xd666";


    public static String geneJsonWebToken(User user) {

        if(user == null || user.getId() == null ||
        user.getName() == null || user.getHeadImg() == null) {
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET)
                .compact();
        return token;
    }

    /**
     * 检验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
       try {
           Claims claims = Jwts.parser().setSigningKey(APPSECRET)
                   .parseClaimsJws(token).getBody();
           return claims;
       } catch (Exception e) {
           return null;
       }

    }

}
