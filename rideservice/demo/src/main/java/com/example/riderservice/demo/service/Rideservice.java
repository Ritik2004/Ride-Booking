package com.example.riderservice.demo.service;

import com.example.driverservice.entity.DriverEntity;
import com.example.riderservice.demo.entity.RideEntity;
import com.example.riderservice.demo.repository.RideRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;

@Service
public class Rideservice {
    private final RideRepository rideRepository;
    private final RestClient restClient;

    public Rideservice(RideRepository rideRepository,RestClient restClient){
        this.rideRepository=rideRepository;
        this.restClient=restClient;
    }
    public RideEntity createRide(RideEntity rideEntity){
        //1) Get available rider
        //2 Assign driver
        //3 change status
        //4 save rider
        List<DriverEntity> drivers = restClient
                .get()
                .uri("http://localhost:8081/available")
                .retrieve()
                .body(new ParameterizedTypeReference<List<DriverEntity>>() {});
        System.out.println(drivers);
        return rideRepository.save(rideEntity);
    }
}
