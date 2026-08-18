package com.example.riderservice.demo.controller;


import com.example.riderservice.demo.entity.RideEntity;
import com.example.riderservice.demo.service.Rideservice;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/rides/{rideId}/accept")
    public RideEntity acceptRide(@PathVariable Long rideId){
      return rideservice.acceptRide(rideId);
    }

    @PutMapping("/rides/{rideId}/start")
    public RideEntity startRide(@PathVariable Long rideId){
        return rideservice.startRide(rideId);
    }
    @PutMapping("/rides/{rideId}/completed")
    public RideEntity completeRide(@PathVariable Long rideId){
        return rideservice.completeRide(rideId);
    }
}
