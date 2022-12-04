package com.project.appointmentbooking.controller;

import com.project.appointmentbooking.entity.Location;
import com.project.appointmentbooking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
   LocationService locationService;

    @CrossOrigin
    @PostMapping("/createlocation")
    @ResponseBody
    public Location createLocation(@RequestBody Location location) {
        Location save = locationService.createLocation(location);
        return save;
    }


    @CrossOrigin
    @GetMapping("/getLocations")
    @ResponseBody
    public List<String> getLocations() {
        List<String> save = locationService.getLocations();
        return save;
    }




}
