package com.springboot.nebular.model.db;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role  implements java.io.Serializable,GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String name;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
	@Override
	@Transient
    public String getAuthority() {
        return this.name;
    }

	
    public void setAuthority(String name) {
		this.name = name;
    }
    
	@Override
	public String toString() {
		return name;
	}
}