package com.example.driverservice.controller;

import com.example.driverservice.entity.DriverEntity;
import com.example.driverservice.entity.Driverstatus;
import com.example.driverservice.service.DriverService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {


    private final DriverService driverService;


    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/savedriver")
    public DriverEntity saveDriver(@RequestBody DriverEntity driverEntity){
        return driverService.createDriver(driverEntity);
    }

    @GetMapping("/getDriverById/{id}")
    public DriverEntity getDriverById(@PathVariable Long id){
        return driverService.getDriverById(id);
    }

    @PutMapping("/updatedriverstatus/{id}")
    public DriverEntity updateDriverStatus(
            @PathVariable Long id,
            @RequestBody  Driverstatus status){
        return driverService.updateDriverstatus(id,status);
    }

}
