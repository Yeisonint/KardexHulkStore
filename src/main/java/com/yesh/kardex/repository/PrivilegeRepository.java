package com.yesh.kardex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesh.kardex.model.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	@Query(nativeQuery = true,value = "SELECT * FROM PRIVILEGIOS WHERE NOMBRE=:name")
	public Privilege findByName(@Param("name")String name);
}