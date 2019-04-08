package com.springboot.nebular;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.nebular.authentication.service.UserService;
import com.springboot.nebular.model.db.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;


	@Test
	public void testUserDetails() {
		System.out.println("Database URL is : "+ env.getProperty("spring.datasource.url"));
		User userDetails  = userService.findByUsername("prasad.suseela@gmail.com");
		System.out.println(userDetails.getUsername());
	}
	
	@Test
	public void testSaveUser() {
/*		System.out.println("Saving to : "+ env.getProperty("spring.datasource.url") );
		User user = new User();
		user.setId(1L);
		user.setUsername("prasadprabha07@gmail.com");
		user.setPassword("password123");
		user.setFirstName("Prasad");
		user.setMiddleName("Prabha");
		user.setLastName("Suseela");
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setId(1L);
		role.setName("admin");
		roles.add(role);
		userService.saveRole(role);
		user.setRoles(roles);
		User userDetails  = userService.save(user);
		System.out.println(userDetails.getUsername() + " && " +userDetails.getPassword());*/
	}

}