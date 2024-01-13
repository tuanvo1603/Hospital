package project.hospital.controller.employee.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.inpatient.GetManagedPatientListForResidentDoctorApi;

import project.hospital.api.treatment.UpdateTreatmentForInpatientApi;
import project.hospital.api.treatment.medication.GetMedicationListApi;
import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForInpatientApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.treatment.Treatment;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.util.List;

@Controller
@RequestMapping("/resident-doctor")
@PreAuthorize("hasRole('RESIDENT_DOCTOR')")
public class ResidentDoctorController {

    private final GetManagedPatientListForResidentDoctorApi getManagedPatientListForResidentDoctorApi;

    private final AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi;

    private final GetMedicationListApi getMedicationListApi;

    private final UpdateTreatmentForInpatientApi updateTreatmentForInpatientApi;

    public ResidentDoctorController(GetManagedPatientListForResidentDoctorApi getManagedPatientListForResidentDoctorApi,
                                    AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi,
                                    GetMedicationListApi getMedicationListApi,
                                    UpdateTreatmentForInpatientApi updateTreatmentForInpatientApi) {
        this.getManagedPatientListForResidentDoctorApi = getManagedPatientListForResidentDoctorApi;
        this.addPrescriptionDetailForInpatientApi = addPrescriptionDetailForInpatientApi;
        this.updateTreatmentForInpatientApi = updateTreatmentForInpatientApi;
        this.getMedicationListApi = getMedicationListApi;
    }

    @PutMapping("/{doctorId}/add-prescription-detail/{patientId}")
    public ResponseEntity<String> addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail,
                                                        @PathVariable Long doctorId,
                                                        @PathVariable Long patientId) {
        return addPrescriptionDetailForInpatientApi.addPrescriptionDetail(prescriptionDetail, doctorId, patientId);
    }

    @GetMapping("/{doctorId}/add-prescription-detail/{patientId}")
    public String getPrescriptionDetail() {
        return "resident-doctor-add-prescription";
    }

    @GetMapping("/{doctorId}/get-managed-patient-list")
    public String getManagedPatientList(@PathVariable Long doctorId, Model model) {
        List<PatientDTO> patients =  getManagedPatientListForResidentDoctorApi.getManagedPatientList(doctorId);
        model.addAttribute("patients", patients);
        return "resident-doctor-patient-list";
    }

    @GetMapping
    public String getMenu(){
        return "resident-doctor-menu";
    }

    @GetMapping("/get-medication-list")
    public String getMedicationList(Model model) {
        model.addAttribute("medicationList", getMedicationListApi.getMedicationList());
        return "resident-doctor-medication-list";
    }

    @PostMapping("/{doctorId}/insert-treatment/{patientId}")
    public void insertTreatment(@RequestBody Treatment treatment){

    }

    @GetMapping("/{doctorId}/insert-treatment/{patientId}")
    public String getInsertTreatmentForm(){
        return "resident-doctor-insert-treatment";
    }

    @PutMapping("/{doctorId}/update-treatment/{patientId}")
    public ResponseEntity<String> updateTreatment(@RequestBody Treatment treatment,
                                                  @PathVariable Long doctorId,
                                                  @PathVariable Long patientId) {
        return updateTreatmentForInpatientApi.updateTreatmentForInpatient(treatment, doctorId, patientId);
    }

}
