package project.hospital.api.patient.inpatient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.mapper.PatientMapper;
import project.hospital.model.managingpatient.ManagingInpatient;
import project.hospital.model.patient.Inpatient;
import project.hospital.service.employee.doctor.SpecialistDoctorService;
import project.hospital.service.managingpatient.ManagingInpatientService;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.patient.OutpatientService;

@Component
public class AdmitInpatientApi {

    private final SpecialistDoctorService specialistDoctorService;

    private final InpatientService inpatientService;

    private final PatientMapper patientMapper;

    private final OutpatientService outpatientService;

    private final ManagingInpatientService managingInpatientService;

    public AdmitInpatientApi(SpecialistDoctorService specialistDoctorService,
                             InpatientService inpatientService,
                             PatientMapper patientMapper,
                             OutpatientService outpatientService,
                             ManagingInpatientService managingInpatientService) {
        this.specialistDoctorService = specialistDoctorService;
        this.inpatientService = inpatientService;
        this.patientMapper = patientMapper;
        this.outpatientService = outpatientService;
        this.managingInpatientService = managingInpatientService;
    }

    public ResponseEntity<String> admitInpatient(Long doctorId, Long outpatientId) {
        specialistDoctorService.checkExistenceOfEmployee(doctorId);
        Inpatient inpatient = inpatientService.admitPatient(patientMapper.mapOutpatientToInpatient(outpatientId), outpatientId);
//        treatmentService.createTreatment(treatmentMapper.mapTreatmentOutpatientToInpatient(outpatientId, admittedInpatient.getEmployeeId()));
        managingInpatientService.initManagingPatient(inpatient);
        outpatientService.dischargePatient(outpatientId);
        return ResponseEntity.ok("Admit inpatient successfully");
    }
}
