package com.springboot.nebular.security.filters;

import static com.springboot.nebular.constants.SecurityConstants.HEADER_STRING;
import static com.springboot.nebular.constants.SecurityConstants.SECRET;
import static com.springboot.nebular.constants.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);
	
    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
    
    
    @SuppressWarnings("unchecked")
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
        	Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
        	
        	String user = (null != claims.get("email")) ? claims.get("email").toString() : "";
        	List<String> roles  = (null != claims.get("roles")) ? (List<String> ) claims.get("roles") : null;
        	Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        	for (String role : roles) {
        		authorities.add(new SimpleGrantedAuthority(role));
        	}
            
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null,authorities);
            }
            return null;
        }
        return null;
    }
}