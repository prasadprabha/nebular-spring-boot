package com.springboot.nebular.controller;

import static com.springboot.nebular.constants.SecurityConstants.HEADER_STRING;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.nebular.authentication.service.UserService;
import com.springboot.nebular.model.db.Role;
import com.springboot.nebular.model.db.User;
import com.springboot.nebular.response.LoginResponse;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/auth/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse login(User user,HttpServletResponse response) {
		String jwtToken = response.getHeader(HEADER_STRING);
		LoginResponse loginResponse = new LoginResponse();
		LoginResponse.Data data = loginResponse.new Data();
		data.setToken(jwtToken);
		loginResponse.setData(data);
		return loginResponse;
    }
	
	@RequestMapping(value = "/auth/logout", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<LoginResponse> logout(HttpServletRequest request,HttpServletResponse response) throws Exception {
		SecurityContextHolder.clearContext();
        HttpSession session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        if (null != request.getCookies()) {
        	for(Cookie cookie : request.getCookies()) {
            	cookie.setMaxAge(0);
        	}
        }
        
        response.addHeader(HEADER_STRING,"");
        LoginResponse authResult = new LoginResponse();
		return new ResponseEntity<LoginResponse>(authResult, HttpStatus.OK);
	}
	
	
   @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
	   Role admin = new Role();
	   admin.setName("Admin");
	   admin.setId(1L);
	   Set<Role> roles = new HashSet<Role>();
	   roles.add(admin);
	   user.setRoles(roles);
	   userService.save(user);
    }
   
   
	@RequestMapping(value = "/get-application-name", method = RequestMethod.GET)
    public String getApplicationName() {
        return "Welcome to Nebular Spring Boot Application";
    }

}
