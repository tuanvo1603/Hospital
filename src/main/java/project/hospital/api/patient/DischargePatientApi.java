package project.hospital.api.patient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.patient.CommonPatientService;

@Component
public class DischargePatientApi {

    private final AdministratorService administratorService;

    private final CommonPatientService commonPatientService;

    public DischargePatientApi(AdministratorService administratorService,
                               CommonPatientService commonPatientService) {
        this.administratorService = administratorService;
        this.commonPatientService = commonPatientService;
    }

    public ResponseEntity<String> dischargePatient(Long administratorId, Long patientId) {
        administratorService.checkExistenceOfEmployee(administratorId);
        commonPatientService.dischargePatient(patientId);
        return ResponseEntity.ok("Discharge successfully");
    }
}
