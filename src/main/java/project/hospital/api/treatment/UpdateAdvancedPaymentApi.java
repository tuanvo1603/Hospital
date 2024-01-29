package project.hospital.api.treatment;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.request.treatment.UpdateAdvancedPaymentRequest;
import project.hospital.response.treatment.UpdateAdvancedPaymentResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.treatment.HospitalFeeService;

@Component
public class UpdateAdvancedPaymentApi extends Api<UpdateAdvancedPaymentRequest, UpdateAdvancedPaymentResponse> {

    private final HospitalFeeService hospitalFeeService;

    private final AdministratorService administratorService;

    public UpdateAdvancedPaymentApi(SessionService sessionService,
                                    HospitalFeeService hospitalFeeService,
                                    AdministratorService administratorService) {
        super(sessionService);
        this.hospitalFeeService = hospitalFeeService;
        this.administratorService = administratorService;
    }

    @Override
    public UpdateAdvancedPaymentResponse execute(UpdateAdvancedPaymentRequest requestData) {
        try{
            administratorService.checkExistenceOfEmployee(requestData.getEmployeeId());
            hospitalFeeService.updateAdvancePayment(requestData.getPatientId(), requestData.getAdvancedPayment());
            return new UpdateAdvancedPaymentResponse();
        }catch (EmployeeNotFoundException e) {
            return new UpdateAdvancedPaymentResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new UpdateAdvancedPaymentResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
