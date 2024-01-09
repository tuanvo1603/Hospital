package project.hospital.api.patient.inpatient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.managingpatient.ManagingInpatientService;

import java.util.List;

@Component
public class GetManagedPatientListForResidentDoctorApi {

    private final ResidentDoctorService residentDoctorService;

    private final PatientMapper patientMapper;

    private final ManagingInpatientService managingInpatientService;

    public GetManagedPatientListForResidentDoctorApi(ResidentDoctorService residentDoctorService,
                                                     PatientMapper patientMapper,
                                                     ManagingInpatientService managingInpatientService) {
        this.residentDoctorService = residentDoctorService;
        this.patientMapper = patientMapper;
        this.managingInpatientService = managingInpatientService;
    }

    public List<PatientDTO> getManagedPatientList(Long residentDoctorId) {
        residentDoctorService.checkExistenceOfEmployee(residentDoctorId);
        return patientMapper.mapToPatientDTOList(managingInpatientService.getAllManagingPatientOfDoctor(residentDoctorId));
    }
}
