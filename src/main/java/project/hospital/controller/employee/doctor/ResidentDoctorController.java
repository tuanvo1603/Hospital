package project.hospital.controller.employee.doctor;

import ch.qos.logback.core.model.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.inpatient.GetManagedPatientByCitizenIdApi;
import project.hospital.api.patient.inpatient.GetManagedPatientListForResidentDoctorApi;
import project.hospital.api.treatment.UpdateTreatmentForInpatientApi;
import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForInpatientApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.treatment.Treatment;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.util.List;

@RestController
@RequestMapping("/resident-doctor/{doctorId}")
@PreAuthorize("hasRole('RESIDENT_DOCTOR')")
public class ResidentDoctorController {

    private final GetManagedPatientListForResidentDoctorApi getManagedPatientListForResidentDoctorApi;

    private final AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi;

    private final UpdateTreatmentForInpatientApi updateTreatmentForInpatientApi;

    public ResidentDoctorController(GetManagedPatientListForResidentDoctorApi getManagedPatientListForResidentDoctorApi,
                                    AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi,
                                    UpdateTreatmentForInpatientApi updateTreatmentForInpatientApi) {
        this.getManagedPatientListForResidentDoctorApi = getManagedPatientListForResidentDoctorApi;
        this.addPrescriptionDetailForInpatientApi = addPrescriptionDetailForInpatientApi;
        this.updateTreatmentForInpatientApi = updateTreatmentForInpatientApi;
    }

    @PutMapping("/add-prescription-detail/{patientId}")
    public ResponseEntity<String> addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail,
                                                        @PathVariable Long doctorId,
                                                        @PathVariable Long patientId) {
        return addPrescriptionDetailForInpatientApi.addPrescriptionDetail(prescriptionDetail, doctorId, patientId);
    }

    @GetMapping("/get-managed-patient-list")
    public List<PatientDTO> getManagedPatientList(@PathVariable Long doctorId, Model model) {
        return getManagedPatientListForResidentDoctorApi.getManagedPatientList(doctorId);
    }

    @PutMapping("/update-treatment/{doctorId}/{patientId}")
    public ResponseEntity<String> updateTreatment(@RequestBody Treatment treatment,
                                                  @PathVariable Long doctorId,
                                                  @PathVariable Long patientId) {
        return updateTreatmentForInpatientApi.updateTreatmentForInpatient(treatment, doctorId, patientId);
    }

}
