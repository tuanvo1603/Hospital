package project.hospital.api.patient;

import jdk.jshell.Snippet;
import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PatientDTO;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.mapper.PatientMapper;
import project.hospital.model.patient.Inpatient;
import project.hospital.request.patient.GetPatientInfoByIdRequest;
import project.hospital.response.patient.GetPatientInfoByIdResponse;
import project.hospital.service.SessionService;
import project.hospital.service.patient.InpatientService;

@Component
public class GetPatientInfoByIdApi extends Api<GetPatientInfoByIdRequest, GetPatientInfoByIdResponse> {

    private final InpatientService inpatientService;

    private final PatientMapper patientMapper;

    public GetPatientInfoByIdApi(SessionService sessionService,
                                 InpatientService inpatientService,
                                 PatientMapper patientMapper) {
        super(sessionService);
        this.inpatientService = inpatientService;
        this.patientMapper = patientMapper;
    }


    @Override
    public GetPatientInfoByIdResponse execute(GetPatientInfoByIdRequest requestData) {
        try {
            Inpatient inpatient = inpatientService.getPatientById(requestData.getPatientId());
            PatientDTO patientDTO = patientMapper.mapToPatientDTO(inpatient);

            return new GetPatientInfoByIdResponse(patientDTO);
        }catch (PatientNotFoundException e) {
            return new GetPatientInfoByIdResponse(StatusCode.REQUEST.getCode(), "Patient may be not managed in system.");
        }catch (Exception e) {
            return new GetPatientInfoByIdResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }

}
