package com.project.appointmentbooking.repository;

import com.project.appointmentbooking.entity.ServiceLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceLocation,Long> {

    @Override
    Optional<ServiceLocation> findById(Long s);


    @Query("SELECT distinct(service) FROM ServiceLocation serviceLocation where location= ?1")
    List<String> getDistinctService(String location);


    List<ServiceLocation> getServiceLocationByLocationAndService(String location,String service);
}

