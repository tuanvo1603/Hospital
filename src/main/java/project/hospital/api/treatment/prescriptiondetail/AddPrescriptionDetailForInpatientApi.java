package project.hospital.api.treatment.prescriptiondetail;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.treatment.prescription.PrescriptionDetailService;

@Component
public class AddPrescriptionDetailForInpatientApi {

    private final ResidentDoctorService residentDoctorService;

    private final PrescriptionDetailService prescriptionDetailService;

    public AddPrescriptionDetailForInpatientApi(ResidentDoctorService residentDoctorService, PrescriptionDetailService prescriptionDetailService) {
        this.residentDoctorService = residentDoctorService;
        this.prescriptionDetailService = prescriptionDetailService;
    }

    public ResponseEntity<String> addPrescriptionDetail(PrescriptionDetail prescriptionDetail, Long residentDoctorId, Long patientId) {
        residentDoctorService.checkExistenceOfEmployee(residentDoctorId);
        prescriptionDetailService.createPrescriptionDetail(patientId, prescriptionDetail);
        return ResponseEntity.ok("Add prescription detail successfully");
    }
}
