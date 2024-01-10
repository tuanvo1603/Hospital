package project.hospital.api.patient.inpatient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.mapper.PatientMapper;
import project.hospital.model.employee.doctor.SpecialistDoctor;
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

    @Transactional
    public ResponseEntity<String> admitInpatient(Long doctorId, Long outpatientId) {
        SpecialistDoctor specialistDoctor = specialistDoctorService.getEmployeeById(doctorId);
        Inpatient inpatient = inpatientService.admitPatient(patientMapper.mapOutpatientToInpatient(outpatientId), outpatientId);
        inpatient.setDepartment(specialistDoctor.getDepartment());
        managingInpatientService.initManagingPatient(inpatient.getPatientId());
        outpatientService.dischargePatient(outpatientId);
        return ResponseEntity.ok("Admit inpatient successfully");
    }
}
