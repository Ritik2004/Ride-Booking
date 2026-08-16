package com.example.riderservice.demo.service;

import com.example.riderservice.demo.entity.RideEntity;
import com.example.riderservice.demo.repository.RideRepository;
import org.springframework.stereotype.Service;

@Service
public class Rideservice {
    private final RideRepository rideRepository;

    public Rideservice(RideRepository rideRepository){
        this.rideRepository=rideRepository;
    }

    public RideEntity createRide(RideEntity rideEntity){
        return rideRepository.save(rideEntity);
    }
}
