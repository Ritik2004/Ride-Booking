package com.example.riderservice.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="rides")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class RideEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long driverId;
    private String pickup;
    private String destination;
    private double fare;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private Ridestatus status;
}
