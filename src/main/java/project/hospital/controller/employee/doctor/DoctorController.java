package project.hospital.controller.employee.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.medicationrecord.AddMedicationRecordApi;
import project.hospital.api.medicationrecord.GetMedicationRecordApi;
import project.hospital.model.medicationrecord.MedicationRecord;

@Controller
@PreAuthorize("hasRole('DOCTOR')")
@RequestMapping("/doctor")
public class DoctorController {
    private final GetMedicationRecordApi getMedicationRecordApi;

    private final AddMedicationRecordApi addMedicationRecordApi;

    public DoctorController(GetMedicationRecordApi getMedicationRecordApi,
                            AddMedicationRecordApi addMedicationRecordApi) {
        this.getMedicationRecordApi = getMedicationRecordApi;
        this.addMedicationRecordApi = addMedicationRecordApi;
    }

    @GetMapping("/get-medication-record/{citizenId}")
    public MedicationRecord getMedicationRecord(@PathVariable String citizenId) {
        return getMedicationRecordApi.getMedicationRecord(citizenId);
    }

    @GetMapping("/add-medication-record/{doctorId}/{patientId}{description}")
    public ResponseEntity<String> addMedicationRecord(@PathVariable String description,
                                                      @PathVariable Long doctorId,
                                                      @PathVariable Long patientId) {
        addMedicationRecordApi.addMedicationRecordDetail(description, doctorId, patientId);
        return ResponseEntity.ok("Add medication record successfully.");
    }

    @GetMapping("/add-medication-record/{doctorId}/{patientId}")
    public String getAddMedicalRecord(){
        return "resident-doctor-add-medical-record";
    }
}
