package project.hospital.api.patient.inpatient;

import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.service.employee.NurseService;
import project.hospital.service.managingpatient.ManagingInpatientService;

import java.util.List;

@Component
public class GetManagedPatientListForNurseApi {

    private final NurseService nurseService;

    private final ManagingInpatientService managingInpatientService;

    private final PatientMapper patientMapper;

    public GetManagedPatientListForNurseApi(NurseService nurseService,
                                            ManagingInpatientService managingInpatientService,
                                            PatientMapper patientMapper) {
        this.nurseService = nurseService;
        this.managingInpatientService = managingInpatientService;
        this.patientMapper = patientMapper;
    }

    public List<PatientDTO> getManagedPatientList(Long nurseId) {
        nurseService.checkExistenceOfEmployee(nurseId);
        return patientMapper.mapToPatientDTOList(managingInpatientService.getAllManagingPatientOfNurse(nurseId));
    }

}
