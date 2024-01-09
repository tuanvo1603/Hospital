package project.hospital.controller.employee.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.inpatient.GetManagedPatientByCitizenIdApi;
import project.hospital.api.patient.inpatient.GetManagedPatientListForResidentDoctorApi;
import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForInpatientApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.util.List;

@RestController
@RequestMapping("/resident-doctor/{doctorId}")
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

    @PutMapping("/add-prescription-detail/{patientId}")
    public ResponseEntity<String> addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail,
                                                        @PathVariable Long doctorId,
                                                        @PathVariable Long patientId) {
        return addPrescriptionDetailForInpatientApi.addPrescriptionDetail(prescriptionDetail, doctorId, patientId);
    }

    @GetMapping("/get-managed-patient-list")
    public List<PatientDTO> getManagedPatientList(@PathVariable Long doctorId) {
        return getManagedPatientListForResidentDoctorApi.getManagedPatientList(doctorId);
    }

    @GetMapping("/get-patient/{citizenId}")
    public PatientDTO getManagedPatientByCitizenId(@PathVariable Long doctorId,
                                                   @PathVariable String citizenId) {
        return getManagedPatientByCitizenIdApi.getManagedPatientByCitizenId(doctorId, citizenId);
    }
}
