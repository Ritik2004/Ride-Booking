package com.example.riderservice.demo.service;

import com.example.riderservice.demo.dto.DriverResponse;
import com.example.riderservice.demo.entity.RideEntity;
import com.example.riderservice.demo.entity.Ridestatus;
import com.example.riderservice.demo.repository.RideRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;

import static com.example.riderservice.demo.entity.Ridestatus.DRIVER_ASSIGNED;

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
        List<DriverResponse> drivers = restClient
                .get()
                .uri("http://localhost:8081/available")
                .retrieve()
                .body(new ParameterizedTypeReference<List<DriverResponse>>() {});

        if (drivers.isEmpty()) {
            System.out.println("No available driver");
            return null;
        }

        long id = drivers.get(0).getId();
        rideEntity.setDriverId(id);
        rideEntity.setStatus(Ridestatus.DRIVER_ASSIGNED);
        System.out.println("Drivers are"+ drivers);
        return rideRepository.save(rideEntity);
    }

    public RideEntity acceptRide( Long rideId){
         RideEntity ride = rideRepository.findById(rideId)
                 .orElseThrow(()->new RuntimeException("Ride Not found"));

         ride.setStatus(Ridestatus.ACCEPTED);
         Long driveId = ride.getDriverId();
         restClient
                 .put()
                 .uri("http://localhost:8081/updatedriverstatus/{driveId}", driveId)
                 .contentType(MediaType.APPLICATION_JSON)
                 .body("\"BUSY\"")
                 .retrieve()
                 .toBodilessEntity();
         return rideRepository.save(ride);


    }
    public RideEntity startRide(Long rideId) {
        RideEntity ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));
        ride.setStatus(Ridestatus.STARTED);
        return rideRepository.save(ride);
    }
    public RideEntity completeRide(Long rideId){
        RideEntity ride = rideRepository.findById(rideId)
                .orElseThrow(()->new RuntimeException("Ride not found"));
        ride.setStatus(Ridestatus.COMPLETED);
        return rideRepository.save(ride);
    }
}

