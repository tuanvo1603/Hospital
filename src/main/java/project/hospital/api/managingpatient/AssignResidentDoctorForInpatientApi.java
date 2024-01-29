package project.hospital.api.managingpatient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.request.managingpatient.AssignResidentDoctorForInpatientRequest;
import project.hospital.response.managingpatient.AssignDoctorForPatientResponse;
import project.hospital.service.SessionService;
import project.hospital.service.managingpatient.ManagingInpatientService;

@Component
public class AssignResidentDoctorForInpatientApi extends Api<AssignResidentDoctorForInpatientRequest, AssignDoctorForPatientResponse> {

    private final ManagingInpatientService managingInpatientService;

    public AssignResidentDoctorForInpatientApi(SessionService sessionService, ManagingInpatientService managingInpatientService) {
        super(sessionService);
        this.managingInpatientService = managingInpatientService;
    }

    @Override
    public AssignDoctorForPatientResponse execute(AssignResidentDoctorForInpatientRequest requestData) {
        try{
            managingInpatientService.assignDoctorForPatient(requestData.getDoctorId(), requestData.getPatientId());
            return new AssignDoctorForPatientResponse("Assign doctor for inpatient successfully.");
        }catch (EmployeeNotFoundException e) {
            return new AssignDoctorForPatientResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (PatientNotFoundException e) {
            return new AssignDoctorForPatientResponse(StatusCode.REQUEST.getCode(), "Patient may not be managed in system.");
        }catch (Exception e) {
            return new AssignDoctorForPatientResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
