package com.wipro.training3.coursedetails.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wipro.training3.coursedetails.config.ApplicationConfig;

@Component
public class JwtTokenVerifier extends OncePerRequestFilter{

	private JwtUtility util;
	private ApplicationConfig appConfig;
	
	List<Map<String, String>> authorities = null;
	
	public JwtTokenVerifier(JwtUtility util,
			ApplicationConfig appConfig) {
		this.util = util;
		this.appConfig = appConfig;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request
			, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        String jwt = null;
        String username = null;
        
        if(authorizationHeader!=null
        		&& authorizationHeader.startsWith("Bearer ")) {
        	jwt = authorizationHeader.substring(7);
        	username = util.extractUserName(jwt);
        	authorities = (List<Map<String, String>>) 
        			util.extractAllClaims(jwt).get("authorities");
        }
        
        if(username!=null) {
			if(util.validateToken(jwt, username)) {
				
				Set<SimpleGrantedAuthority> simpleGrantedAuthorities
				          = authorities.stream()
				           .map(m -> new SimpleGrantedAuthority(m.get("authority")))
				           .collect(Collectors.toSet());
				
				UsernamePasswordAuthenticationToken usrCred 
				       = new UsernamePasswordAuthenticationToken(
						username,null,simpleGrantedAuthorities);
				usrCred.setDetails(new WebAuthenticationDetailsSource()
					   .buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usrCred);
			}
		}
    	filterChain.doFilter(request, response);
	}
}
