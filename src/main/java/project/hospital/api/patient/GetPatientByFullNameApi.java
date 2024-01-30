package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PatientDTO;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.mapper.PatientMapper;
import project.hospital.request.patient.GetPatientByFullNameRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.patient.InpatientService;

import java.util.List;

@Component
public class GetPatientByFullNameApi extends Api<GetPatientByFullNameRequest, GetPatientsResponse> {

    private final CommonEmployeeService commonEmployeeService;

    private final PatientMapper patientMapper;

    private final InpatientService inpatientService;

    public GetPatientByFullNameApi(CommonEmployeeService commonEmployeeService,
                                   PatientMapper patientMapper,
                                   InpatientService inpatientService,
                                   SessionService sessionService) {
        super(sessionService);
        this.commonEmployeeService = commonEmployeeService;
        this.patientMapper = patientMapper;
        this.inpatientService = inpatientService;
    }

    @Override
    public GetPatientsResponse execute(GetPatientByFullNameRequest requestData) {
        try{
            commonEmployeeService.checkExistenceOfEmployee(requestData.getEmployeeId());
            List<PatientDTO> patientDTOList = patientMapper.mapToPatientDTOList(inpatientService.findAllPatientsByFullName(requestData.getFirstName(), requestData.getLastName()));
            if(patientDTOList.isEmpty()) {
                throw new PatientNotFoundException();
            }
            return new GetPatientsResponse(patientDTOList);
        }catch (EmployeeNotFoundException e) {
            return new GetPatientsResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (PatientNotFoundException e) {
            return new GetPatientsResponse(StatusCode.REQUEST.getCode(), "Patient may be not managed in system.");
        }catch (Exception e) {
            return new GetPatientsResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
