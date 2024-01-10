package project.hospital.controller.employee.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.medicationrecord.AddMedicationRecordApi;
import project.hospital.api.medicationrecord.GetMedicationRecordApi;
import project.hospital.api.treatment.GetTreatmentInfoApi;
import project.hospital.model.medicationrecord.MedicationRecord;
import project.hospital.model.treatment.Treatment;

@Controller
@PreAuthorize("hasRole('DOCTOR')")
@RequestMapping("/doctor")
public class DoctorController {

    private final GetMedicationRecordApi getMedicationRecordApi;

    private final AddMedicationRecordApi addMedicationRecordApi;

    private final GetTreatmentInfoApi getTreatmentInfoApi;

    public DoctorController(GetMedicationRecordApi getMedicationRecordApi,
                            AddMedicationRecordApi addMedicationRecordApi,
                            GetTreatmentInfoApi getTreatmentInfoApi) {
        this.getMedicationRecordApi = getMedicationRecordApi;
        this.addMedicationRecordApi = addMedicationRecordApi;
        this.getTreatmentInfoApi = getTreatmentInfoApi;
    }

    @GetMapping("/get-medication-record/{citizenId}")
    public MedicationRecord getMedicationRecord(@PathVariable String citizenId) {
        return getMedicationRecordApi.getMedicationRecord(citizenId);
    }

    @PostMapping("/add-medication-record/{description}/{doctorId}/{patientId}")
    public ResponseEntity<String> addMedicationRecord(@PathVariable String description,
                                                      @PathVariable Long doctorId,
                                                      @PathVariable Long patientId) {
        addMedicationRecordApi.addMedicationRecordDetail(description, doctorId, patientId);
        return ResponseEntity.ok("Add medication record successfully.");
    }

    @GetMapping("/get-patient-treatment/{patientId}")
    public Treatment getPatientTreatment(@PathVariable Long patientId) {
        return getTreatmentInfoApi.getTreatmentInfo(patientId);
    }
}
