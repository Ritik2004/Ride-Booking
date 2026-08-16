package com.example.riderservice.demo.repository;

import com.example.riderservice.demo.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, Long> {

}
