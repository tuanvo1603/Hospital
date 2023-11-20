package project.hospital.controller.admincontroller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import project.hospital.dto.PatientDTO;
import project.hospital.service.admin.DischargingPatientService;

@RestController
@Configuration
public class AdminDischarging {
    private final DischargingPatientService dischargingPatientService;
    @Autowired
    public AdminDischarging(DischargingPatientService dischargingPatientService) {
        this.dischargingPatientService = dischargingPatientService;
    }

    @PostMapping("/discharge-patient")
    public void dischargePatient(@RequestBody PatientDTO patientDTO) {
        dischargingPatientService.deleteRecord(patientDTO);
    }


}
