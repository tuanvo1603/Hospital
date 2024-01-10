package project.hospital.controller.employee.doctor;

import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.inpatient.GetManagedPatientByCitizenIdApi;
import project.hospital.api.patient.inpatient.GetManagedPatientListForResidentDoctorApi;
import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForInpatientApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.util.List;

@Controller
@RequestMapping("/resident-doctor")
@PreAuthorize("hasRole('RESIDENT_DOCTOR')")
public class ResidentDoctorController {

    private final GetManagedPatientByCitizenIdApi getManagedPatientByCitizenIdApi;

    private final GetManagedPatientListForResidentDoctorApi getManagedPatientListForResidentDoctorApi;

    private final AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi;

    public ResidentDoctorController(GetManagedPatientByCitizenIdApi getManagedPatientByCitizenIdApi,
                                    GetManagedPatientListForResidentDoctorApi getManagedPatientListForResidentDoctorApi,
                                    AddPrescriptionDetailForInpatientApi addPrescriptionDetailForInpatientApi) {
        this.getManagedPatientByCitizenIdApi = getManagedPatientByCitizenIdApi;
        this.getManagedPatientListForResidentDoctorApi = getManagedPatientListForResidentDoctorApi;
        this.addPrescriptionDetailForInpatientApi = addPrescriptionDetailForInpatientApi;
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

    @GetMapping("/get-patient/{citizenId}")
    public PatientDTO getManagedPatientByCitizenId(@PathVariable Long doctorId,
                                                   @PathVariable String citizenId) {
        return getManagedPatientByCitizenIdApi.getManagedPatientByCitizenId(doctorId, citizenId);
    }

    @GetMapping
    public String getMenu(){
        return "resident-doctor-menu";
    }


}
