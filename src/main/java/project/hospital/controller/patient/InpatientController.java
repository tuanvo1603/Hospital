package project.hospital.controller.patient;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.GetPatientInfoByIdApi;
import project.hospital.api.treatment.GetHospitalFeeApi;
import project.hospital.api.treatment.GetTreatmentApi;
import project.hospital.request.patient.GetPatientInfoByIdRequest;
import project.hospital.request.treatment.GetHospitalFeeRequest;
import project.hospital.request.treatment.GetTreatmentRequest;
import project.hospital.response.patient.GetPatientInfoByIdResponse;
import project.hospital.response.treatment.GetHospitalFeeResponse;
import project.hospital.response.treatment.GetTreatmentResponse;

@RestController
@RequestMapping("/inpatient/{patientId}")
@PreAuthorize("hasRole('PATIENT')")
public class InpatientController {

    private final GetPatientInfoByIdApi getPatientInfoByIdApi;

    private final GetTreatmentApi getTreatmentApi;

    private final GetHospitalFeeApi getHospitalFeeApi;

    public InpatientController(GetPatientInfoByIdApi getPatientInfoByIdApi,
                               GetTreatmentApi getTreatmentApi,
                               GetHospitalFeeApi getHospitalFeeApi) {
        this.getPatientInfoByIdApi = getPatientInfoByIdApi;
        this.getTreatmentApi = getTreatmentApi;
        this.getHospitalFeeApi = getHospitalFeeApi;
    }

    @GetMapping("/show-my-information")
    public GetPatientInfoByIdResponse showPatientInformation(@PathVariable Long patientId) {
        GetPatientInfoByIdRequest getPatientInfoByIdRequest = new GetPatientInfoByIdRequest(patientId);
        return getPatientInfoByIdApi.execute(getPatientInfoByIdRequest);
    }

    @GetMapping("/show-hospital-fee")
    public GetHospitalFeeResponse showHospitalFee(@PathVariable Long patientId) {
        GetHospitalFeeRequest getHospitalFeeRequest = new GetHospitalFeeRequest(patientId);
        return getHospitalFeeApi.execute(getHospitalFeeRequest);
    }

    @GetMapping("/show-treatment")
    public GetTreatmentResponse showTreatment(@PathVariable Long patientId) {
        GetTreatmentRequest getTreatmentRequest = new GetTreatmentRequest(patientId);
        return getTreatmentApi.execute(getTreatmentRequest);
    }
}
