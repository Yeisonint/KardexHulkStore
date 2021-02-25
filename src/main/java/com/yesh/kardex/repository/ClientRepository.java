package com.yesh.kardex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yesh.kardex.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}