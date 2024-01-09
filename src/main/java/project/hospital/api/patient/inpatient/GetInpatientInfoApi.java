package project.hospital.api.patient.inpatient;

import org.springframework.stereotype.Component;
import project.hospital.model.patient.Inpatient;
import project.hospital.service.patient.InpatientService;

@Component
public class GetInpatientInfoApi {

    private final InpatientService inpatientService;

    public GetInpatientInfoApi(InpatientService inpatientService) {
        this.inpatientService = inpatientService;
    }

    public Inpatient getInpatientInfo(Long patientId) {
        return inpatientService.getPatientById(patientId);
    }
}
