package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.patient.InpatientService;

import java.util.List;

@Component
public class SearchByFullNameApi {

    private final CommonEmployeeService commonEmployeeService;

    private final PatientMapper patientMapper;

    private final InpatientService inpatientService;

    public SearchByFullNameApi(CommonEmployeeService commonEmployeeService,
                               PatientMapper patientMapper,
                               InpatientService inpatientService) {
        this.commonEmployeeService = commonEmployeeService;
        this.patientMapper = patientMapper;
        this.inpatientService = inpatientService;
    }

    public List<PatientDTO> searchByFullName(Long administratorId, String firstName, String lastName) {
        commonEmployeeService.checkExistenceOfEmployee(administratorId);
        return patientMapper.mapToPatientDTOList(inpatientService.findAllPatientsByFullName(firstName, lastName));
    }
}
