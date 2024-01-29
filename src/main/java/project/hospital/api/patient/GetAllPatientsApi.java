package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PatientDTO;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.mapper.PatientMapper;
import project.hospital.request.patient.GetAllPatientsRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.patient.CommonPatientService;

import java.util.List;

@Component
public class GetAllPatientsApi extends Api<GetAllPatientsRequest, GetPatientsResponse> {

    private final CommonPatientService commonPatientService;

    private final PatientMapper patientMapper;

    private final AdministratorService administratorService;

    public GetAllPatientsApi(CommonPatientService commonPatientService,
                             PatientMapper patientMapper,
                             AdministratorService administratorService,
                             SessionService sessionService) {
        super(sessionService);
        this.commonPatientService = commonPatientService;
        this.patientMapper = patientMapper;
        this.administratorService = administratorService;
    }

    @Override
    public GetPatientsResponse execute(GetAllPatientsRequest requestData) {
        try{
            administratorService.checkExistenceOfEmployee(requestData.getEmployeeId());
            List<PatientDTO> patientDTOList = patientMapper.mapToPatientDTOList(commonPatientService.getAllPatients());

            return new GetPatientsResponse(patientDTOList);
        }catch (EmployeeNotFoundException e) {
            return new GetPatientsResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new GetPatientsResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
