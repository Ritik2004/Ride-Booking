package com.example.riderservice.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverResponse {
    private Long id;
    private String name;
    private String phone;
    private String licenseNumber;
    private String status;

}
