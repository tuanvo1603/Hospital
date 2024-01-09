package project.hospital.api.patient.outpatient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.treatment.HospitalFeeService;
import project.hospital.service.treatment.TreatmentService;

@Component
public class AdmitOutpatientApi {

    private final AdministratorService administratorService;

    private final OutpatientService outpatientService;

    private final TreatmentService treatmentService;

    private final HospitalFeeService hospitalFeeService;

    public AdmitOutpatientApi(AdministratorService administratorService,
                              OutpatientService outpatientService,
                              TreatmentService treatmentService,
                              HospitalFeeService hospitalFeeService) {
        this.administratorService = administratorService;
        this.outpatientService = outpatientService;
        this.treatmentService = treatmentService;
        this.hospitalFeeService = hospitalFeeService;
    }

    public ResponseEntity<String> admitOutpatient(Long administratorId, Outpatient outpatient) {
        administratorService.checkExistenceOfEmployee(administratorId);
        Outpatient admitOutpatient = outpatientService.admitPatient(outpatient);
        Treatment treatment = treatmentService.createTreatment(admitOutpatient);
        hospitalFeeService.createHospitalFee(treatment);
        return ResponseEntity.ok("Insert successfully");
    }
}
