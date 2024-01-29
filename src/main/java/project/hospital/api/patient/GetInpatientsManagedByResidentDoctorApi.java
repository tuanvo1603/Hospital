package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PatientDTO;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.mapper.PatientMapper;
import project.hospital.request.patient.GetInpatientsManagedByResidentDoctorRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.managingpatient.ManagingInpatientService;

import java.util.List;

@Component
public class GetInpatientsManagedByResidentDoctorApi extends Api<GetInpatientsManagedByResidentDoctorRequest, GetPatientsResponse> {

    private final ResidentDoctorService residentDoctorService;

    private final PatientMapper patientMapper;

    private final ManagingInpatientService managingInpatientService;

    public GetInpatientsManagedByResidentDoctorApi(ResidentDoctorService residentDoctorService,
                                                   PatientMapper patientMapper,
                                                   ManagingInpatientService managingInpatientService,
                                                   SessionService sessionService) {
        super(sessionService);
        this.residentDoctorService = residentDoctorService;
        this.patientMapper = patientMapper;
        this.managingInpatientService = managingInpatientService;
    }

    @Override
    public GetPatientsResponse execute(GetInpatientsManagedByResidentDoctorRequest requestData) {
        try {
            residentDoctorService.checkExistenceOfEmployee(requestData.getEmployeeId());
            List<PatientDTO> patientDTOList = patientMapper.mapToPatientDTOList(managingInpatientService.getAllManagingPatientOfDoctor(requestData.getEmployeeId()));

            return new GetPatientsResponse(patientDTOList);
        }catch (EmployeeNotFoundException e) {
            return new GetPatientsResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new GetPatientsResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
