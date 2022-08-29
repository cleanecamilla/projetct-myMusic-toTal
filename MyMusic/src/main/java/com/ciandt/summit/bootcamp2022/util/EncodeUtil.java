package com.ciandt.summit.bootcamp2022.util;

import java.util.Base64;

public class EncodeUtil {
    public static String encode(String toEncode){
        return Base64.getEncoder().encodeToString(toEncode.getBytes());
    }

    public static String decode(String base64){
        return new String(Base64.getDecoder().decode(base64));
    }

    public static String encodeAuth(String username, String token){
        return encode(username + ":" + token);
    }

    public static String decodeUsername(String base64){
        return decode(base64).split(":")[0];
    }

    public static String decodeToken(String base64){
        return decode(base64).split(":")[1];
    }
}
