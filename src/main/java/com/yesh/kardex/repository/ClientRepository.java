package com.yesh.kardex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yesh.kardex.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query(nativeQuery = true,value = "SELECT * FROM CLIENTE WHERE USUARIO=:username")
	public Client findByUsername(@Param("username")String username);

	@Query(nativeQuery = true,value = "SELECT * FROM CLIENTE WHERE CORREO=:email")
	public Client findByEmail(@Param("email")String email);

}