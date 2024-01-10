package project.hospital.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.inpatient.GetInpatientInfoApi;
import project.hospital.api.treatment.GetTreatmentInfoApi;
import project.hospital.api.treatment.hospitalfee.GetHospitalFeeInfoApi;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;

@RestController
@RequestMapping("/inpatient/{patientId}")
@PreAuthorize("hasRole('PATIENT')")
public class InpatientController {

    private final GetInpatientInfoApi getInpatientInfoApi;

    private final GetHospitalFeeInfoApi getHospitalFeeInfoApi;

    private final GetTreatmentInfoApi getTreatmentInfoApi;

    @Autowired
    public InpatientController(GetInpatientInfoApi getInpatientInfoApi,
                               GetHospitalFeeInfoApi getHospitalFeeInfoApi,
                               GetTreatmentInfoApi getTreatmentInfoApi) {
        this.getInpatientInfoApi = getInpatientInfoApi;
        this.getHospitalFeeInfoApi = getHospitalFeeInfoApi;
        this.getTreatmentInfoApi = getTreatmentInfoApi;
    }

    @GetMapping("/show-my-information")
    public Patient showPatientInformation(@PathVariable Long patientId) {
        return getInpatientInfoApi.getInpatientInfo(patientId);
    }

    @GetMapping("/show-hospital-fee")
    public HospitalFee showHospitalFee(@PathVariable Long patientId) {
        return getHospitalFeeInfoApi.getHospitalFeeInfo(patientId);
    }

    @GetMapping("/show-treatment")
    public Treatment showTreatment(@PathVariable Long patientId) {
        return getTreatmentInfoApi.getTreatmentInfo(patientId);
    }
}
