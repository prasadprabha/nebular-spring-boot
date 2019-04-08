package com.springboot.nebular.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.nebular.model.db.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}

