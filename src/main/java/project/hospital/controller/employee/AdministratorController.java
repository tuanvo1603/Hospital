package project.hospital.controller.employee;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.GetAllPatientsApi;
import project.hospital.api.patient.AdmitOutpatientApi;
import project.hospital.api.patient.DischargePatientApi;
import project.hospital.api.treatment.UpdateAdvancedPaymentApi;
import project.hospital.model.patient.Outpatient;
import project.hospital.request.patient.AdmitOutpatientRequest;
import project.hospital.request.patient.DischargePatientRequest;
import project.hospital.request.patient.GetAllPatientsRequest;
import project.hospital.request.treatment.UpdateAdvancedPaymentRequest;
import project.hospital.response.patient.AdmitOutpatientResponse;
import project.hospital.response.patient.DischargePatientResponse;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.response.treatment.UpdateAdvancedPaymentResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/admin")
@PreAuthorize("hasRole('ADMINISTRATOR')")
public class AdministratorController {

    private final AdmitOutpatientApi admitOutpatientApi;

    private final DischargePatientApi dischargePatientApi;

    private final GetAllPatientsApi getAllPatientsApi;

    private final UpdateAdvancedPaymentApi updateAdvancedPaymentApi;

    public AdministratorController(AdmitOutpatientApi admitOutpatientApi,
                                   DischargePatientApi dischargePatientApi,
                                   GetAllPatientsApi getAllPatientsApi,
                                   UpdateAdvancedPaymentApi updateAdvancedPaymentApi) {
        this.admitOutpatientApi = admitOutpatientApi;
        this.dischargePatientApi = dischargePatientApi;
        this.getAllPatientsApi = getAllPatientsApi;
        this.updateAdvancedPaymentApi = updateAdvancedPaymentApi;
    }

    @GetMapping("/get-all-patients/{administratorId}")
    public GetPatientsResponse getAllPatients(@PathVariable Long administratorId) {
        GetAllPatientsRequest getAllPatientsRequest = new GetAllPatientsRequest(administratorId);
        return getAllPatientsApi.execute(getAllPatientsRequest);
    }

    @PostMapping("/admit-outpatient/{administratorId}")
    public AdmitOutpatientResponse admitOutpatient(@PathVariable Long administratorId,
                                                   @RequestBody Outpatient outpatient) {
        AdmitOutpatientRequest admitOutpatientRequest = new AdmitOutpatientRequest(administratorId, outpatient);
        return admitOutpatientApi.execute(admitOutpatientRequest);
    }

    @DeleteMapping("/discharge-patient/{administratorId}/{patientId}")
    public DischargePatientResponse dischargePatient(@PathVariable Long administratorId,
                                                     @PathVariable Long patientId) {
        DischargePatientRequest dischargePatientRequest = new DischargePatientRequest(administratorId, patientId);
        return dischargePatientApi.execute(dischargePatientRequest);
    }

    @PostMapping("/update-advanced-payment/{administratorId}/{patientId}/{advancedPayment}")
    public UpdateAdvancedPaymentResponse updateAdvancedPayment(@PathVariable Long administratorId,
                                                               @PathVariable Long patientId,
                                                               @PathVariable Integer advancedPayment) {
        UpdateAdvancedPaymentRequest updateAdvancedPaymentRequest = new UpdateAdvancedPaymentRequest(administratorId, patientId, advancedPayment);
        return updateAdvancedPaymentApi.execute(updateAdvancedPaymentRequest);
    }
}
