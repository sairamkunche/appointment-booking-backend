package com.project.appointmentbooking.controller;

import com.project.appointmentbooking.DTO.AppointmentDto;
import com.project.appointmentbooking.entity.*;
import com.project.appointmentbooking.repository.AppointmentsRepository;
import com.project.appointmentbooking.service.LocationService;
import com.project.appointmentbooking.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceContoller {

    @Autowired
    ServiceService serviceService;

    @Autowired
    LocationService locationService;



    @CrossOrigin
    @ResponseBody
    @PostMapping("/createServiceType")
    public ServiceType createServiceType(@RequestBody ServiceType serviceType) {
        ServiceType save = serviceService.createServiceType(serviceType);
        return save;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("/addNewService")
    public ServiceLocation addNewService(@RequestBody ServiceLocation serviceLocation) {
        try{
        Location location = new Location();
        location.setName(serviceLocation.getLocation());
        location.setCountry("United States");
        location = locationService.createLocation(location);}
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        ServiceLocation save = serviceService.addService(serviceLocation);

        return save;
    }


    @CrossOrigin
    @GetMapping("/getServicesType/{location}")
    @ResponseBody
    public List<String> getServicesType(@PathVariable String location) {
        List<String> save = serviceService.getServicesNames(location);
        return save;
    }

    @CrossOrigin
    @GetMapping("/getService/{location}/{service}")
    @ResponseBody
    public List<ServiceLocation> getServiceLocation(@PathVariable String location,@PathVariable String service) {
        List<ServiceLocation> save = serviceService.getServices(location,service);
        return save;
    }

    @CrossOrigin
    @GetMapping("/getAllServics")
    @ResponseBody
    public List<ServiceLocation> getServiceLocation() {
        List<ServiceLocation> save = serviceService.getAllServices();
        return save;
    }

    @CrossOrigin
    @GetMapping("/getServiceById/{id}")
    @ResponseBody
    public ServiceLocation getServiceById(@PathVariable long id){
        ServiceLocation save = serviceService.getServiceById(id);
        return save;
    }


    @CrossOrigin
    @ResponseBody
    @PostMapping("/bookAppointment")
    public String bookAppointment(@RequestBody Appointments appointments) {
        Appointments save = serviceService.bookAppointment(appointments);
        return "success";
    }

    @CrossOrigin
    @GetMapping("/getUserAppointments/{email}")
    @ResponseBody
    public List<AppointmentDto> getUserAppointments(@PathVariable String email){
        List<AppointmentDto> save = serviceService.fetchAppointmentsForUsers(email);
        return save;
    }


}
