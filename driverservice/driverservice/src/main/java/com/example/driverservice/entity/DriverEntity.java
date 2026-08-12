package com.example.driverservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String licenseNumber;
    @Enumerated(EnumType.STRING)
    private Driverstatus status;
}
