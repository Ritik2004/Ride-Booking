package com.example.driverservice.repository;

import com.example.driverservice.entity.DriverEntity;
import com.example.driverservice.entity.Driverstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
    List<DriverEntity> findByStatus(Driverstatus status);
}

