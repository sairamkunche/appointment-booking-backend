package com.project.appointmentbooking.repository;

import com.project.appointmentbooking.entity.Location;
import com.project.appointmentbooking.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,String> {

    @Override
    Optional<ServiceType> findById(String s);

}

