package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PatientDTO;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.mapper.PatientMapper;
import project.hospital.request.patient.GetInpatientsManagedByNurseRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.NurseService;
import project.hospital.service.managingpatient.ManagingInpatientService;

import java.util.List;

@Component
public class GetInpatientsManagedByNurseApi extends Api<GetInpatientsManagedByNurseRequest, GetPatientsResponse> {

    private final NurseService nurseService;

    private final ManagingInpatientService managingInpatientService;

    private final PatientMapper patientMapper;

    public GetInpatientsManagedByNurseApi(NurseService nurseService,
                                          ManagingInpatientService managingInpatientService,
                                          PatientMapper patientMapper,
                                          SessionService sessionService) {
        super(sessionService);
        this.nurseService = nurseService;
        this.managingInpatientService = managingInpatientService;
        this.patientMapper = patientMapper;
    }

    @Override
    public GetPatientsResponse execute(GetInpatientsManagedByNurseRequest requestData) {
        try{
            nurseService.checkExistenceOfEmployee(requestData.getNurseId());
            List<PatientDTO> patientDTOList = patientMapper.mapToPatientDTOList(managingInpatientService.getAllManagingPatientOfNurse(requestData.getNurseId()));

            return new GetPatientsResponse(patientDTOList);
        }catch (EmployeeNotFoundException e) {
            return new GetPatientsResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new GetPatientsResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
