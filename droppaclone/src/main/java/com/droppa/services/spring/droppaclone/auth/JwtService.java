/**
 * 
 */
package com.droppa.services.spring.droppaclone.auth;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * @author Ernest Mampana
 *
 */
@Service
public class JwtService {

	private static final String SECRETE_KEY = "";

	public String extractedUsername(String jwtToken) {

		return extractClaim(jwtToken, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsresolver) {
		final Claims claims = extractAllClaims(token);
		return claimsresolver.apply(claims);

	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRETE_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();

	}

	public boolean isTokenValid(String token, UserDetails userDetals) {
		final String username = extractedUsername(token);
		return (username.equals(userDetals.getUsername())) && !isTokenexpired(token);
	}

	private boolean isTokenexpired(String token) {
		return extractEpiration(token).before(new Date());
	}

	private Date extractEpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

}
