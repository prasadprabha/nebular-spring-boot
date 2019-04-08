package com.springboot.nebular.model.db;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	
    private Long id;
    private String username;
    private String password;
    private String middleName;
    private String firstName;
    private String lastName;
	private Set<Role> roles;
    
    public User() {
        super();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

}