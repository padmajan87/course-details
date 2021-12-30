package com.wipro.training3.coursedetails.util;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.wipro.training3.coursedetails.config.ApplicationConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtility {

	private ApplicationConfig appConfig;
	
	public JwtUtility(ApplicationConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	public String extractUserName(String token) {
		return extractClaim(token,(claims)->claims.getSubject());
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token,(claims)->claims.getExpiration());
	}
	
	
	public <T> T extractClaim(String token,Function<Claims,T> claimResolver ) {
		Claims allClaims = extractAllClaims(token);
		return claimResolver.apply(allClaims);
	}
	
	public Claims extractAllClaims(String token) {
		return Jwts.parser()
				.setSigningKey(appConfig.getJwtKey().getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date(System.currentTimeMillis()));
	}
	
	public Boolean validateToken(String token,String user) {
		final String username=extractUserName(token);
		return (username.equals(user)) && !isTokenExpired(token);
	}
}
