package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.patient.CommonPatientService;

import java.util.List;

@Component
public class GetAllPatientApi {

    private final CommonPatientService commonPatientService;

    private final PatientMapper patientMapper;

    private final AdministratorService administratorService;

    public GetAllPatientApi(CommonPatientService commonPatientService,
                            PatientMapper patientMapper,
                            AdministratorService administratorService) {
        this.commonPatientService = commonPatientService;
        this.patientMapper = patientMapper;
        this.administratorService = administratorService;
    }

    public List<PatientDTO> getAllPatients(Long administratorId) {
        administratorService.checkExistenceOfEmployee(administratorId);
        return patientMapper.mapToPatientDTOList(commonPatientService.getAllPatients());
    }
}
