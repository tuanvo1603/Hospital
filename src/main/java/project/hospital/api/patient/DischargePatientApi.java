package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.request.patient.DischargePatientRequest;
import project.hospital.response.patient.DischargePatientResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.patient.CommonPatientService;

@Component
public class DischargePatientApi extends Api<DischargePatientRequest, DischargePatientResponse> {

    private final AdministratorService administratorService;

    private final CommonPatientService commonPatientService;

    public DischargePatientApi(AdministratorService administratorService,
                               CommonPatientService commonPatientService,
                               SessionService sessionService) {
        super(sessionService);
        this.administratorService = administratorService;
        this.commonPatientService = commonPatientService;
    }

    @Override
    public DischargePatientResponse execute(DischargePatientRequest requestData) {
        try{
            administratorService.checkExistenceOfEmployee(requestData.getAdministratorId());
            commonPatientService.dischargePatient(requestData.getPatientId());
            return new DischargePatientResponse();
        }catch (EmployeeNotFoundException e) {
            return new DischargePatientResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (PatientNotFoundException e) {
            return new DischargePatientResponse(StatusCode.REQUEST.getCode(), "Patient may not be managed in system.");
        }catch (Exception e) {
            return new DischargePatientResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
