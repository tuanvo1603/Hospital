package project.hospital.api.treatment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.managingpatient.ManagingInpatientService;
import project.hospital.service.treatment.TreatmentService;

@Component
public class UpdateTreatmentForInpatientApi {

    private final ManagingInpatientService managingInpatientService;

    private final ResidentDoctorService residentDoctorService;

    private final TreatmentService treatmentService;

    public UpdateTreatmentForInpatientApi(ManagingInpatientService managingInpatientService,
                                          ResidentDoctorService residentDoctorService,
                                          TreatmentService treatmentService) {
        this.managingInpatientService = managingInpatientService;
        this.residentDoctorService = residentDoctorService;
        this.treatmentService = treatmentService;
    }

    public ResponseEntity<String> updateTreatmentForInpatient(Treatment treatment, Long doctorId, Long patientId) {
        residentDoctorService.checkExistenceOfEmployee(patientId);
        managingInpatientService.isManagedPatientByDoctor(doctorId, patientId);
        treatmentService.updateTreatment(patientId, treatment);
        return ResponseEntity.ok("Update treatment successfully.");
    }
}
