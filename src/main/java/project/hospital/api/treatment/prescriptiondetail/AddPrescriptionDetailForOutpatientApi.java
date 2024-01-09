package project.hospital.api.treatment.prescriptiondetail;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.service.employee.doctor.SpecialistDoctorService;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.treatment.prescription.PrescriptionDetailService;

@Component
public class AddPrescriptionDetailForOutpatientApi {

    private final SpecialistDoctorService specialistDoctorService;

    private final OutpatientService outpatientService;

    private final PrescriptionDetailService prescriptionDetailService;

    public AddPrescriptionDetailForOutpatientApi(SpecialistDoctorService specialistDoctorService,
                                                 OutpatientService outpatientService,
                                                 PrescriptionDetailService prescriptionDetailService) {
        this.specialistDoctorService = specialistDoctorService;
        this.outpatientService = outpatientService;
        this.prescriptionDetailService = prescriptionDetailService;
    }

    public ResponseEntity<String> addPrescriptionDetail(PrescriptionDetail prescriptionDetail, Long specialistDoctorId, Long outpatientId) {
        specialistDoctorService.checkExistenceOfEmployee(specialistDoctorId);
        outpatientService.checkExistenceOfPatient(outpatientId);
        prescriptionDetailService.createPrescriptionDetail(outpatientId, prescriptionDetail);
        return ResponseEntity.ok("Add prescription detail successfully");
    }
}
