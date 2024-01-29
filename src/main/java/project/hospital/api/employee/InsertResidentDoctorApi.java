package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.employee.InsertResidentDoctorRequest;
import project.hospital.response.employee.InsertEmployeeResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.doctor.ResidentDoctorService;

@Component
public class InsertResidentDoctorApi extends Api<InsertResidentDoctorRequest, InsertEmployeeResponse> {

    private final ResidentDoctorService residentDoctorService;

    public InsertResidentDoctorApi(SessionService sessionService, ResidentDoctorService residentDoctorService) {
        super(sessionService);
        this.residentDoctorService = residentDoctorService;
    }

    @Override
    public InsertEmployeeResponse execute(InsertResidentDoctorRequest requestData) {
        try{
            residentDoctorService.createEmployee(requestData.getResidentDoctor());

            return new InsertEmployeeResponse();
        }catch (Exception e) {
            return new InsertEmployeeResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
