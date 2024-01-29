package project.hospital.api.managingpatient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.request.managingpatient.AssignNurseForInpatientRequest;
import project.hospital.response.managingpatient.AssignNurseForInpatientResponse;
import project.hospital.service.SessionService;
import project.hospital.service.managingpatient.ManagingInpatientService;

@Component
public class AssignNurseForInpatientApi extends Api<AssignNurseForInpatientRequest, AssignNurseForInpatientResponse> {

    private final ManagingInpatientService managingInpatientService;

    public AssignNurseForInpatientApi(SessionService sessionService,
                                      ManagingInpatientService managingInpatientService) {
        super(sessionService);
        this.managingInpatientService = managingInpatientService;
    }

    @Override
    public AssignNurseForInpatientResponse execute(AssignNurseForInpatientRequest requestData) {
        try{
            managingInpatientService.assignNurseForPatient(requestData.getNurseId(), requestData.getPatientId());
            return new AssignNurseForInpatientResponse();
        }catch (EmployeeNotFoundException e) {
            return new AssignNurseForInpatientResponse(StatusCode.REQUEST.getCode(), "Error in nurseId.");
        }catch (PatientNotFoundException e) {
            return new AssignNurseForInpatientResponse(StatusCode.REQUEST.getCode(), "Patient may not be managed in system.");
        }catch (Exception e) {
            return new AssignNurseForInpatientResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
