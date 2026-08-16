package com.example.riderservice.demo.controller;


import com.example.riderservice.demo.entity.RideEntity;
import com.example.riderservice.demo.service.Rideservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ridecontroller
{
    private final Rideservice rideservice;

    public Ridecontroller(Rideservice rideservice) {
        this.rideservice = rideservice;
    }

    @PostMapping("/createride")
    public RideEntity createRide(@RequestBody  RideEntity rideEntity){
        return rideservice.createRide(rideEntity);
    }
}
