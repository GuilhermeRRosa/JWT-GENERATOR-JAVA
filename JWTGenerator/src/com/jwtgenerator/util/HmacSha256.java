package com.jwtgenerator.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256 {
	
	public static String sign(String secret, String data) {
		try {
			Mac sha256Hmac = Mac.getInstance("HmacSHA256");
			
			SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
			sha256Hmac.init(secretKey);
			
			byte[] signedBytes = sha256Hmac.doFinal(data.getBytes("UTF-8"));
			
			return Base64Url.encode(signedBytes);
		} catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
			throw new RuntimeException("Erro assinando com HMAC SHA256");
		}
	}

}
