package project.hospital.controller.employee.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.managingpatient.AddAppointmentApi;
import project.hospital.api.patient.SearchByFullNameApi;
import project.hospital.api.patient.inpatient.AdmitInpatientApi;
import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForOutpatientApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.treatment.medication.PrescriptionDetail;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/specialist-doctor/{doctorId}/{outpatientId}")
@PreAuthorize("hasRole('SPECIALIST_DOCTOR')")
public class SpecialistDoctorController {

    private final AdmitInpatientApi admitInpatientApi;

    private final AddAppointmentApi addAppointmentApi;

    private final AddPrescriptionDetailForOutpatientApi addPrescriptionDetailForOutpatientApi;

    private final SearchByFullNameApi searchByFullNameApi;

    public SpecialistDoctorController(AdmitInpatientApi admitInpatientApi,
                                      AddAppointmentApi addAppointmentApi,
                                      AddPrescriptionDetailForOutpatientApi addPrescriptionDetailForOutpatientApi,
                                      SearchByFullNameApi searchByFullNameApi) {
        this.admitInpatientApi = admitInpatientApi;
        this.addAppointmentApi = addAppointmentApi;
        this.addPrescriptionDetailForOutpatientApi = addPrescriptionDetailForOutpatientApi;
        this.searchByFullNameApi = searchByFullNameApi;
    }

    @GetMapping("/search-by-name/{firstName}/{lastName}")
    public List<PatientDTO> searchPatientByName(@PathVariable Long administratorId,
                                                @PathVariable String firstName,
                                                @PathVariable String lastName) {
        return searchByFullNameApi.searchByFullName(administratorId, firstName, lastName);
    }

    @PostMapping("/admit-inpatient")
    public ResponseEntity<String> admitInpatient(@PathVariable Long doctorId,
                                                 @PathVariable Long outpatientId) {
        return admitInpatientApi.admitInpatient(doctorId, outpatientId);
    }

    @PostMapping("/add-prescription-detail")
    public ResponseEntity<String> addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail,
                                                        @PathVariable Long doctorId,
                                                        @PathVariable Long outpatientId) {
        return addPrescriptionDetailForOutpatientApi.addPrescriptionDetail(prescriptionDetail, doctorId, outpatientId);
    }

    @PostMapping("/add-appointment/{date}")
    public ResponseEntity<String> addAppointment(@PathVariable Long doctorId,
                                                 @PathVariable Long outpatientId,
                                                 @PathVariable Date date) {
        return addAppointmentApi.addAppointment(doctorId, outpatientId, date);
    }
}
