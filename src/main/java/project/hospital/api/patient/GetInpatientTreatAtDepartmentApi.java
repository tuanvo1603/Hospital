package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.request.patient.GetInpatientsTreatAtDepartmentRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.service.SessionService;
import project.hospital.service.patient.InpatientService;

import java.util.List;

@Component
public class GetInpatientTreatAtDepartmentApi extends Api<GetInpatientsTreatAtDepartmentRequest, GetPatientsResponse> {

    private final InpatientService inpatientService;

    private final PatientMapper patientMapper;

    public GetInpatientTreatAtDepartmentApi(SessionService sessionService, InpatientService inpatientService, PatientMapper patientMapper) {
        super(sessionService);
        this.inpatientService = inpatientService;
        this.patientMapper = patientMapper;
    }

    @Override
    public GetPatientsResponse execute(GetInpatientsTreatAtDepartmentRequest requestData) {
        try{
            List<PatientDTO> patientDTOList = patientMapper.mapToPatientDTOList(inpatientService.getAllPatientByDepartment(requestData.getDepartment()));

            return new GetPatientsResponse(patientDTOList);
        }catch (Exception e) {
            return new GetPatientsResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
