package com.springboot.nebular.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class ApplicationUser {
	
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("password")
    private String password;
    
    @JsonProperty("firstName")
    @JsonInclude( JsonInclude.Include.NON_NULL)
    private String firstName;
    
    @JsonProperty("lastName")
    @JsonInclude( JsonInclude.Include.NON_NULL)
    private String lastName;
    
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


	public void setId(long id) {
		this.id = id;
	}
	@JsonProperty("roles")
    private List<String> roles;
    
    
    public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	public long getId() {
        return id;
    }
    
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}