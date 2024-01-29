package project.hospital.controller.employee.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.GetInpatientsManagedByResidentDoctorApi;

import project.hospital.api.treatment.InsertTreatmentApi;
import project.hospital.api.treatment.medication.GetAllMedicationsApi;
import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForInpatientApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.treatment.Treatment;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.request.patient.GetInpatientsManagedByResidentDoctorRequest;
import project.hospital.request.treatment.InsertTreatmentRequest;
import project.hospital.request.treatment.prescription.InsertPrescriptionRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.response.treatment.InsertTreatmentResponse;
import project.hospital.response.treatment.prescription.InsertPrescriptionResponse;

import java.util.List;

@Controller
@RequestMapping("/resident-doctor")
@PreAuthorize("hasRole('RESIDENT_DOCTOR')")
public class ResidentDoctorController {

    private final GetInpatientsManagedByResidentDoctorApi getInpatientsManagedByResidentDoctorApi;

    private final AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi;

    private final GetAllMedicationsApi getAllMedicationsApi;

    private final InsertTreatmentApi insertTreatmentApi;

    public ResidentDoctorController(GetInpatientsManagedByResidentDoctorApi getInpatientsManagedByResidentDoctorApi,
                                    AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi,
                                    GetAllMedicationsApi getAllMedicationsApi,
                                    InsertTreatmentApi insertTreatmentApi) {
        this.getInpatientsManagedByResidentDoctorApi = getInpatientsManagedByResidentDoctorApi;
        this.addPrescriptionDetailForInpatientApi = addPrescriptionDetailForInpatientApi;
        this.insertTreatmentApi = insertTreatmentApi;
        this.getAllMedicationsApi = getAllMedicationsApi;
    }

    @PutMapping("/{doctorId}/add-prescription-detail/{patientId}")
    public InsertPrescriptionResponse addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail,
                                                            @PathVariable Long doctorId,
                                                            @PathVariable Long patientId) {
        InsertPrescriptionRequest insertPrescriptionRequest = new InsertPrescriptionRequest(doctorId, patientId, prescriptionDetail);
        return addPrescriptionDetailForInpatientApi.execute(insertPrescriptionRequest);
    }

    @GetMapping("/{doctorId}/get-managed-patient-list")
    public GetPatientsResponse getManagedPatientList(@PathVariable Long doctorId) {
        GetInpatientsManagedByResidentDoctorRequest getInpatientsManagedByResidentDoctorRequest = new GetInpatientsManagedByResidentDoctorRequest(doctorId);
        return getInpatientsManagedByResidentDoctorApi.execute(getInpatientsManagedByResidentDoctorRequest);
    }

}
