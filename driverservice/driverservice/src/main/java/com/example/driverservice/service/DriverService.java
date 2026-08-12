package com.example.driverservice.service;


import com.example.driverservice.entity.DriverEntity;
import com.example.driverservice.entity.Driverstatus;
import com.example.driverservice.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;


    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public DriverEntity createDriver(DriverEntity driverEntity){
        return driverRepository.save(driverEntity);
    }

    public DriverEntity getDriverById(Long id){
        return driverRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Driver not found with id"+id));
    }

    public DriverEntity updateDriverstatus(Long id, Driverstatus status){
        DriverEntity driverEntity = driverRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Driver not found with id"+id));
        driverEntity.setStatus(status);

        return driverRepository.save(driverEntity);
    }
}
