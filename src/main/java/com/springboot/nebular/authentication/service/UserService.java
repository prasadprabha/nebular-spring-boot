package com.springboot.nebular.authentication.service;

import java.util.List;

import com.springboot.nebular.model.db.Role;
import com.springboot.nebular.model.db.User;

public interface UserService {
	
    User save(User user);
    
    User findByUsername(String username);
    
	void saveRole(Role role);
	
	List<Role> getRoles(String username);
	
}