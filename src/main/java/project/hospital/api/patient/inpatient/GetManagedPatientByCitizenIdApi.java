package project.hospital.api.patient.inpatient;

import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.patient.InpatientService;

@Component
public class GetManagedPatientByCitizenIdApi {

    private final ResidentDoctorService residentDoctorService;

    private final PatientMapper patientMapper;

    private final InpatientService inpatientService;

    public GetManagedPatientByCitizenIdApi(ResidentDoctorService residentDoctorService,
                                           PatientMapper patientMapper,
                                           InpatientService inpatientService) {
        this.residentDoctorService = residentDoctorService;
        this.patientMapper = patientMapper;
        this.inpatientService = inpatientService;
    }

    public PatientDTO getManagedPatientByCitizenId(Long residentDoctorId, String citizenId) {
        residentDoctorService.checkExistenceOfEmployee(residentDoctorId);
        return patientMapper.mapToPatientDTO(inpatientService.getPatientByCitizenId(citizenId));
    }
}
