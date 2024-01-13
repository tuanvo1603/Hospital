package project.hospital.controller.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.GetAllPatientApi;
import project.hospital.api.patient.outpatient.AdmitOutpatientApi;
import project.hospital.api.patient.DischargePatientApi;
import project.hospital.api.patient.SearchByFullNameApi;
import project.hospital.api.treatment.hospitalfee.UpdateAdvancePaymentApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;

import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMINISTRATOR')")
public class AdministratorController {

    private final SearchByFullNameApi searchByFullNameApi;

    private final AdmitOutpatientApi admitOutpatientApi;

    private final UpdateAdvancePaymentApi updateAdvancePaymentApi;

    private final DischargePatientApi dischargePatientApi;

    private final GetAllPatientApi getAllPatientApi;

    public AdministratorController(SearchByFullNameApi searchByFullNameApi,
                                   AdmitOutpatientApi admitOutpatientApi,
                                   UpdateAdvancePaymentApi updateAdvancePaymentApi,
                                   DischargePatientApi dischargePatientApi,
                                   GetAllPatientApi getAllPatientApi) {
        this.searchByFullNameApi = searchByFullNameApi;
        this.admitOutpatientApi = admitOutpatientApi;
        this.updateAdvancePaymentApi = updateAdvancePaymentApi;
        this.dischargePatientApi = dischargePatientApi;
        this.getAllPatientApi = getAllPatientApi;
    }

    @GetMapping("/{administratorId}/search-by-name/{firstName}/{lastName}")
    public List<PatientDTO> searchPatientByName(@PathVariable Long administratorId,
                                                @PathVariable String firstName,
                                                @PathVariable String lastName) {
        return searchByFullNameApi.searchByFullName(administratorId, firstName, lastName);
    }

    @GetMapping("/get-all-patients/{administratorId}")
    public List<PatientDTO> getAllPatients(@PathVariable Long administratorId) {
        return getAllPatientApi.getAllPatients(administratorId);
    }

    @PostMapping("/{administratorId}/admit-outpatient")
    public ResponseEntity<String> admitOutpatient(@PathVariable Long administratorId,
                                                  @RequestBody Outpatient outpatient) {
        return admitOutpatientApi.admitOutpatient(administratorId, outpatient);
    }

    @DeleteMapping("/{administratorId}/discharge-patient/{patientId}")
    public ResponseEntity<String> dischargePatient(@PathVariable Long administratorId,
                                                   @PathVariable Long patientId) {
        return dischargePatientApi.dischargePatient(administratorId, patientId);
    }

    @PostMapping("/{administratorId}/update-advanced-payment/{patientId}/{advancedPayment}")
    public ResponseEntity<String> updateAdvancedPayment(@PathVariable Long administratorId,
                                                        @PathVariable Long patientId,
                                                        @PathVariable Integer advancedPayment) {
        return updateAdvancePaymentApi.updateAdvancedPayment(administratorId, patientId, advancedPayment);
    }
}
