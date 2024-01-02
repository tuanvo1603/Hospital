package project.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Outpatient;
import project.hospital.service.employee.admin.UpdatePatientService;

@Controller
public class HomePage {
    @GetMapping("/homepage")
    public String getHomePage(){
        return "homepage/index";
    }

}
