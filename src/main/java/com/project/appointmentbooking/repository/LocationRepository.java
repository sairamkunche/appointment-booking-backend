package com.project.appointmentbooking.repository;

import com.project.appointmentbooking.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,String> {

    @Override
    Optional<Location> findById(String s);

    @Query("SELECT name FROM Location location")
    List<String> getDistinctLocation();
}
