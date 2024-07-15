//package org.dafe.tripTix.constant;
//
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//import java.security.Key;
//import java.util.Base64;
//
//public class SecretKeyGenerator {
//    public static void main(String[] args) {
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
//        System.out.println("Generated secret key: " + base64Key);
//    }
//}
