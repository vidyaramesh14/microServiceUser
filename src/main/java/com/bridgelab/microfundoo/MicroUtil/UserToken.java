package com.bridgelab.microfundoo.MicroUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

public class UserToken {
private static String TOKEN_SECRET="zZrq0sZK1yt9RJk51RTJ/jeU6WERbvr8nqKMWQJRX1E=";
	
	public static String generateToken(Long id) throws Exception
	{
		try {
			
			Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
			String token=JWT.create().withClaim("id",id).sign(algorithm);
			return token;		
		}
		catch(Exception exception)
		{
			throw new Exception("Token Not Generated");
		}
	}
	public static Long verifyToken(String token) throws Exception	{
		Long id;
		Verification verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));	
		JWTVerifier jwtVerifier = verification.build();		
		DecodedJWT decodedJWT = jwtVerifier.verify(token);
		Claim claim = decodedJWT.getClaim("id");
		id = claim.asLong();
		System.out.println("qwwwwwwwweqeqweqee"+id);
		return id;
	}
	
}
