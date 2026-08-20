package com.example.riderservice.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private Long rideId;
    private Long userId;
    private double amount;
    private String status;
}
