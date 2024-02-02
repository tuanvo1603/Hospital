package project.hospital.controller.employee.doctor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.managingpatient.AddAppointmentApi;
import project.hospital.api.patient.AdmitInpatientApi;
import project.hospital.api.patient.GetPatientsHaveAppointmentApi;
import project.hospital.api.treatment.prescriptiondetail.AddPrescriptionDetailForOutpatientApi;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.request.managingpatient.AddAppointmentForPatientRequest;
import project.hospital.request.patient.AdmitInpatientRequest;
import project.hospital.request.patient.GetPatientsHaveAppointmentRequest;
import project.hospital.request.treatment.prescription.InsertPrescriptionRequest;
import project.hospital.response.managingpatient.AssignDoctorForPatientResponse;
import project.hospital.response.patient.AdmitInpatientResponse;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.response.treatment.prescription.InsertPrescriptionResponse;

import java.sql.Date;


@RestController
@RequestMapping("/v1/specialist-doctor")
@PreAuthorize("hasRole('SPECIALIST_DOCTOR')")
public class SpecialistDoctorController {

    private final AdmitInpatientApi admitInpatientApi;

    private final AddAppointmentApi addAppointmentApi;

    private final AddPrescriptionDetailForOutpatientApi addPrescriptionDetailForOutpatientApi;

    private final GetPatientsHaveAppointmentApi getPatientsHaveAppointmentApi;

    public SpecialistDoctorController(AdmitInpatientApi admitInpatientApi,
                                      AddAppointmentApi addAppointmentApi,
                                      AddPrescriptionDetailForOutpatientApi addPrescriptionDetailForOutpatientApi,
                                      GetPatientsHaveAppointmentApi getPatientsHaveAppointmentApi) {
        this.admitInpatientApi = admitInpatientApi;
        this.addAppointmentApi = addAppointmentApi;
        this.addPrescriptionDetailForOutpatientApi = addPrescriptionDetailForOutpatientApi;

        this.getPatientsHaveAppointmentApi = getPatientsHaveAppointmentApi;
    }

    @PostMapping("/admit-inpatient/{doctorId}/{outpatientId}")
    public AdmitInpatientResponse admitInpatient(@PathVariable Long doctorId,
                                                 @PathVariable Long outpatientId) {
        AdmitInpatientRequest admitInpatientRequest = new AdmitInpatientRequest(doctorId, outpatientId);
        return admitInpatientApi.execute(admitInpatientRequest);
    }

    @PostMapping("/add-prescription-detail/{doctorId}/{outpatientId}")
    public InsertPrescriptionResponse addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail,
                                                            @PathVariable Long doctorId,
                                                            @PathVariable Long outpatientId) {
        InsertPrescriptionRequest insertPrescriptionRequest = new InsertPrescriptionRequest(doctorId, outpatientId, prescriptionDetail);
        return addPrescriptionDetailForOutpatientApi.execute(insertPrescriptionRequest);
    }

    @PostMapping("/add-appointment/{doctorId}/{outpatientId}/{date}")
    public AssignDoctorForPatientResponse addAppointment(@PathVariable Long doctorId,
                                                         @PathVariable Long outpatientId,
                                                         @PathVariable Date date) {
        AddAppointmentForPatientRequest addAppointmentForPatientRequest = new AddAppointmentForPatientRequest(doctorId, outpatientId, date);
        return addAppointmentApi.execute(addAppointmentForPatientRequest);
    }

    @GetMapping("/get-patient-has-appointment/{doctorId}")
    public GetPatientsResponse getListPatientHasAppointment(@PathVariable Long doctorId) {
        GetPatientsHaveAppointmentRequest getPatientsHaveAppointmentRequest = new GetPatientsHaveAppointmentRequest(doctorId);
        return getPatientsHaveAppointmentApi.execute(getPatientsHaveAppointmentRequest);
    }
}
