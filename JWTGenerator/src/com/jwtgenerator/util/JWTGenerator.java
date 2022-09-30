package com.jwtgenerator.util;

public class JWTGenerator {

	public static void main(String[] args) {
		
		//Secrete used for sign the object with HmacSha256
		String secret = "ggcodigossecret";
		
		//Header of the JWT
		String header = "{ \"alg\": \"HS256\" }";
		
		//body payload of the JWT
		String payload = "{ \"jwt:nome\": \"João\", \"jwt:admin\": true }";
		
		//Header + payload encoded with Base64
		String encodedData = Base64Url.encode(header) + "." + Base64Url.encode(payload);
		
		//the encodedData is signed with the algoritm defined in header		
		String signature = HmacSha256.sign(secret, encodedData);
		
		//The final object jwt its a combination of encodedData with Signature (header.payload.signature)
		String jwt = encodedData + "." + signature;

		System.out.println(jwt);
		
	}	
}
