package com.project.appointmentbooking.service;

import com.project.appointmentbooking.entity.Location;
import com.project.appointmentbooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public Location createLocation(Location location) {
        Location save = locationRepository.save(location);
        return save;
    }

    public List<String> getLocations() {
        List<String> locations = locationRepository.getDistinctLocation();
        return locations;
    }
}
