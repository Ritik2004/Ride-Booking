package com.example.paymentservice.demo.controller;


import com.example.paymentservice.demo.entity.PaymentEntity;
import com.example.paymentservice.demo.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping("/payments")
    public PaymentEntity createPayment(@RequestBody PaymentEntity paymentEntity){
        return paymentService.createPayment(paymentEntity);
    }

    @PutMapping("/payments/{paymentId}/process")
    public PaymentEntity updatePayment(@PathVariable Long paymentId){
        return paymentService.updatePayment(paymentId);
    }
}
