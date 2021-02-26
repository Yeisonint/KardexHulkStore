package com.yesh.kardex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesh.kardex.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query(nativeQuery = true,value = "SELECT * FROM ROL WHERE NOMBRE=:name")
	public Role findByName(@Param("name")String name);
}