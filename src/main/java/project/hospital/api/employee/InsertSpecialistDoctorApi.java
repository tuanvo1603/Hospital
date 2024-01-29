package project.hospital.api.employee;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.request.employee.InsertSpecialistDoctorRequest;
import project.hospital.response.employee.InsertEmployeeResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.doctor.SpecialistDoctorService;

@Component
public class InsertSpecialistDoctorApi extends Api<InsertSpecialistDoctorRequest, InsertEmployeeResponse> {

    private final SpecialistDoctorService specialistDoctorService;

    public InsertSpecialistDoctorApi(SessionService sessionService, SpecialistDoctorService specialistDoctorService) {
        super(sessionService);
        this.specialistDoctorService = specialistDoctorService;
    }

    @Override
    public InsertEmployeeResponse execute(InsertSpecialistDoctorRequest requestData) {
        try{
            specialistDoctorService.createEmployee(requestData.getSpecialistDoctor());

            return new InsertEmployeeResponse();
        }catch (Exception e) {
            return new InsertEmployeeResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
