package com.example.paymentservice.demo.service;

import com.example.paymentservice.demo.entity.PaymentEntity;
import com.example.paymentservice.demo.entity.Paymentstatus;
import com.example.paymentservice.demo.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }

    public PaymentEntity createPayment(PaymentEntity paymentEntity){
           return paymentRepository.save(paymentEntity);
    }

    public PaymentEntity updatePayment(Long id){
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Payment not found with id"+ id));
        paymentEntity.setCreatedAt(LocalDateTime.now());
        paymentEntity.setStatus(Paymentstatus.SUCCESS);
        return paymentRepository.save(paymentEntity);
    }
}
   