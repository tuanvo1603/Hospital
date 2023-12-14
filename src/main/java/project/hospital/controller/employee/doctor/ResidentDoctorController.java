package project.hospital.controller.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.exception.IncorrectIdException;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.service.employee.doctor.ResidentDoctorService;

@RestController
@RequestMapping("/resident-doctor/{employeeId}")
public class ResidentDoctorController {

    private final ResidentDoctorService residentDoctorService;

    @Autowired
    public ResidentDoctorController(ResidentDoctorService residentDoctorService) {
        this.residentDoctorService = residentDoctorService;
    }

    @PutMapping("/add-prescription-detail/{patientId}")
    public ResponseEntity<Void> updateInpatient(
            @RequestBody PrescriptionDetail prescriptionDetail,
            @PathVariable Long employeeId,
            @PathVariable Long patientId) throws PatientCanNotBeFoundException, IncorrectIdException
    {
        residentDoctorService.addPrescriptionDetail(prescriptionDetail, employeeId, patientId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-patient/{citizenId}")
    public Patient getManagedPatient(@PathVariable String citizenId) {
        return residentDoctorService.searchInpatientByCitizenId(citizenId);
    }
}
