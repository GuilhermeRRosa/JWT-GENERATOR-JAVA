package com.jwtgenerator.util;

public class JWTGenerator {

	public static void main(String[] args) {
		
		String secret = "ggcodigossecret";
		
		String header = "{ \"alg\": \"HS256\" }";
		String payload = "{ \"jwt:nome\": \"João\", \"jwt:admin\": true }";
		
		String encodedData = Base64Url.encode(header) + "." + Base64Url.encode(payload);
		
		String signature = HmacSha256.sign(secret, encodedData);
		
		String jwt = encodedData + "." + signature;

		System.out.println(jwt);
		
	}
	
}
