package project.hospital.controller.employee.doctor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.medicationrecord.GetMedicationRecordByCitizenIdApi;
import project.hospital.api.medicationrecord.InsertMedicationRecordApi;
import project.hospital.api.treatment.GetTreatmentApi;
import project.hospital.api.treatment.InsertTreatmentApi;
import project.hospital.model.treatment.Treatment;
import project.hospital.request.medicationrecord.GetMedicationRecordByCitizenIdRequest;
import project.hospital.request.medicationrecord.InsertMedicationRecordRequest;
import project.hospital.request.treatment.GetTreatmentRequest;
import project.hospital.request.treatment.InsertTreatmentRequest;
import project.hospital.response.medicationrecord.GetMedicationRecordByCitizenIdResponse;
import project.hospital.response.medicationrecord.InsertMedicationRecordResponse;
import project.hospital.response.treatment.GetTreatmentResponse;
import project.hospital.response.treatment.InsertTreatmentResponse;

@Controller
@PreAuthorize("hasRole('DOCTOR')")
@RequestMapping("/v1/doctor")
public class DoctorController {

    private final GetMedicationRecordByCitizenIdApi getMedicationRecordByCitizenIdApi;

    private final GetTreatmentApi getTreatmentApi;

    private final InsertTreatmentApi insertTreatmentApi;

    private final InsertMedicationRecordApi insertMedicationRecordApi;

    public DoctorController(GetMedicationRecordByCitizenIdApi getMedicationRecordByCitizenIdApi,
                            GetTreatmentApi getTreatmentApi,
                            InsertTreatmentApi insertTreatmentApi,
                            InsertMedicationRecordApi insertMedicationRecordApi) {
        this.getMedicationRecordByCitizenIdApi = getMedicationRecordByCitizenIdApi;
        this.getTreatmentApi = getTreatmentApi;
        this.insertTreatmentApi = insertTreatmentApi;
        this.insertMedicationRecordApi = insertMedicationRecordApi;
    }

    @GetMapping("/get-medication-record/{doctorId}/{citizenId}")
    public GetMedicationRecordByCitizenIdResponse getMedicationRecord(@PathVariable Long doctorId, @PathVariable String citizenId) {
        GetMedicationRecordByCitizenIdRequest getMedicationRecordByCitizenIdRequest = new GetMedicationRecordByCitizenIdRequest(doctorId, citizenId);
        return getMedicationRecordByCitizenIdApi.execute(getMedicationRecordByCitizenIdRequest);
    }

    @PostMapping("/add-medication-record/{doctorId}/{citizenId}/{description}")
    public InsertMedicationRecordResponse addMedicationRecord(@PathVariable Long doctorId,
                                                              @PathVariable String citizenId,
                                                              @PathVariable String description) {
        InsertMedicationRecordRequest insertMedicationRecordRequest = new InsertMedicationRecordRequest(doctorId, citizenId, description);
        return insertMedicationRecordApi.execute(insertMedicationRecordRequest);
    }

    @GetMapping("/get-patient-treatment/{patientId}")
    public GetTreatmentResponse getPatientTreatment(@PathVariable Long patientId){
        GetTreatmentRequest getTreatmentRequest = new GetTreatmentRequest(patientId);
        return getTreatmentApi.execute(getTreatmentRequest);
    }

    @PutMapping("/{doctorId}/insert-treatment/{patientId}")
    public InsertTreatmentResponse updateTreatment(@RequestBody Treatment treatment,
                                                   @PathVariable Long doctorId,
                                                   @PathVariable Long patientId) {
        InsertTreatmentRequest insertTreatmentRequest = new InsertTreatmentRequest(doctorId, patientId, treatment);
        return insertTreatmentApi.execute(insertTreatmentRequest);
    }
}
