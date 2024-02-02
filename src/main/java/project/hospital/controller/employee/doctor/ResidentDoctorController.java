package project.hospital.controller.employee.doctor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.GetInpatientsManagedByResidentDoctorApi;

import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForInpatientApi;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.request.patient.GetInpatientsManagedByResidentDoctorRequest;
import project.hospital.request.treatment.prescription.InsertPrescriptionRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.response.treatment.prescription.InsertPrescriptionResponse;

@RestController
@RequestMapping("/v1/resident-doctor")
@PreAuthorize("hasRole('RESIDENT_DOCTOR')")
public class ResidentDoctorController {

    private final GetInpatientsManagedByResidentDoctorApi getInpatientsManagedByResidentDoctorApi;

    private final AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi;

    public ResidentDoctorController(GetInpatientsManagedByResidentDoctorApi getInpatientsManagedByResidentDoctorApi,
                                    AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi) {
        this.getInpatientsManagedByResidentDoctorApi = getInpatientsManagedByResidentDoctorApi;
        this.addPrescriptionDetailForInpatientApi = addPrescriptionDetailForInpatientApi;
    }

    @PutMapping("/add-prescription-detail/{doctorId}/{patientId}")
    public InsertPrescriptionResponse addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail,
                                                            @PathVariable Long doctorId,
                                                            @PathVariable Long patientId) {
        InsertPrescriptionRequest insertPrescriptionRequest = new InsertPrescriptionRequest(doctorId, patientId, prescriptionDetail);
        return addPrescriptionDetailForInpatientApi.execute(insertPrescriptionRequest);
    }

    @GetMapping("/get-managed-patient-list/{doctorId}")
    public GetPatientsResponse getManagedPatientList(@PathVariable Long doctorId) {
        GetInpatientsManagedByResidentDoctorRequest getInpatientsManagedByResidentDoctorRequest = new GetInpatientsManagedByResidentDoctorRequest(doctorId);
        return getInpatientsManagedByResidentDoctorApi.execute(getInpatientsManagedByResidentDoctorRequest);
    }

}
