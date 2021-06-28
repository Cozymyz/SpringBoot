package com.example.demo.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import com.example.demo.mapper.UserMapper;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;


public class JWTUtil {
    // 过期时间 24 小时
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;
    // 密钥
    private static final String SECRET = "hwt";

    @Resource
    private UserMapper userMapper;
    /**
     * 生成 token
     */
    public static String createToken(String username) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    //到期时间
                    .withExpiresAt(date)
                    //创建一个新的JWT，并使用给定的算法进行标记
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 校验 token 是否正确
     */
    public static boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public  Integer getUserid(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String name= jwt.getClaim("username").asString();
            System.out.println("name:"+name);
            UserExample example=new UserExample();
            UserExample.Criteria criteria=example.createCriteria();
            criteria.andUsernameEqualTo(name);
            List<User> users=userMapper.selectByExample(example);
            System.out.println("user:"+users.get(0).toString());
            return users.get(1).getId();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getUserphone(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userphone").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
