package com.yesh.kardex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yesh.kardex.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}