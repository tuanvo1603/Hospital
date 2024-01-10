package project.hospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/home")
    public String getHomePage(HttpServletRequest request) {
        if(request.isUserInRole("RESIDENT_DOCTOR"))
            return "resident-doctor-menu";
        else if(request.isUserInRole("SPECIALIST_DOCTOR"))
            return "specialist-doctor-menu";
        else if(request.isUserInRole("NURSE"))
            return "nurse-menu";
        else if(request.isUserInRole("TECHNICIAN"))
            return "technician-menu";
        else if(request.isUserInRole("DEAN"))
            return "dean-menu";
        else if(request.isUserInRole("ADMINISTRATOR"))
            return "admin-menu";

        return "patient-menu";
    }
}
