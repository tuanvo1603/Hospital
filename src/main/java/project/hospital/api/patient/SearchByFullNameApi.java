package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.patient.InpatientService;

import java.util.List;

@Component
public class SearchByFullNameApi {

    private final AdministratorService administratorService;

    private final PatientMapper patientMapper;

    private final InpatientService inpatientService;

    public SearchByFullNameApi(AdministratorService administratorService,
                               PatientMapper patientMapper,
                               InpatientService inpatientService) {
        this.administratorService = administratorService;
        this.patientMapper = patientMapper;
        this.inpatientService = inpatientService;
    }

    public List<PatientDTO> searchByFullName(Long administratorId, String firstName, String lastName) {
        administratorService.checkExistenceOfEmployee(administratorId);
        return patientMapper.mapToPatientDTOList(inpatientService.findAllPatientsByFullName(firstName, lastName));
    }
}
