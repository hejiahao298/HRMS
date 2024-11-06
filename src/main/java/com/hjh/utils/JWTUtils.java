package com.hjh.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hjh.entity.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    private static final String SIGN="123";

    /**
     * 生成Token，header.payload.sign
     */
    public static String getToken(User user){
        Calendar ins = Calendar.getInstance();
        ins.add(Calendar.DATE,3); // 默认3天过期

        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        Map<String,Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("slg","HS256");
        builder.withHeader(header);

        // payload
        builder.withClaim("username",user.getUsername());
        builder.withClaim("admin",user.getUserId());

        // 指定令牌过期时间
        builder.withExpiresAt(ins.getTime());


        String token = builder.sign(Algorithm.HMAC256(SIGN));

        return token;
    }

    /**
     * 验证token合法性
     */
    public static DecodedJWT verify(String token){

        // 创建验证对象,需要算法一致，签名一致
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }

}
