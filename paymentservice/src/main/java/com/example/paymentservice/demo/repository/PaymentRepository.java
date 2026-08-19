package com.example.paymentservice.demo.repository;

import com.example.paymentservice.demo.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity ,Long> {
}
