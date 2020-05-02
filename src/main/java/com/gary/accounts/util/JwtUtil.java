package com.gary.accounts.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtil {

    private static final String SUBJECT = "accounts-api";

    private static final String AUDIENCE = "accounts-web";

    private static final String USER_ID = "user_id";

    public static String createToken(Long userId, String password){
        return createToken(userId, password, 2L);
    }

    public static String createToken(Long userId, String apiKey, Long expireTime){
        Map<String, Object> header = new HashMap<>(2);
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        LocalDateTime expireDate = LocalDateTime.now().plusMinutes(expireTime);
        ZoneId zoneId = ZoneId.systemDefault();
        return JWT.create().withHeader(header).withSubject(SUBJECT).withAudience(AUDIENCE)
                .withClaim(USER_ID, userId).withIssuedAt(new Date()).withExpiresAt(Date.from(expireDate.atZone(zoneId).toInstant()))
                .sign(Algorithm.HMAC256(apiKey));
    }

    public static boolean validationToken(String token, String apiKey){
        DecodedJWT jwt = JWT.decode(token);
        return true;
    }

}
