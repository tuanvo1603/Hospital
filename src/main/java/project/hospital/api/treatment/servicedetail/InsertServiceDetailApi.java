package project.hospital.api.treatment.servicedetail;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.request.treatment.servicedetail.InsertServiceDetailRequest;
import project.hospital.response.treatment.servicedetail.InsertServiceDetailResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.TechnicianService;
import project.hospital.service.treatment.HospitalFeeService;
import project.hospital.service.treatment.service.ServiceDetailService;

@Component
public class InsertServiceDetailApi extends Api<InsertServiceDetailRequest, InsertServiceDetailResponse> {

    private final TechnicianService technicianService;

    private final ServiceDetailService serviceDetailService;

    private final HospitalFeeService hospitalFeeService;

    public InsertServiceDetailApi(TechnicianService technicianService,
                                  ServiceDetailService serviceDetailService,
                                  SessionService sessionService,
                                  HospitalFeeService hospitalFeeService) {
        super(sessionService);
        this.technicianService = technicianService;
        this.serviceDetailService = serviceDetailService;
        this.hospitalFeeService = hospitalFeeService;
    }

    @Override
    public InsertServiceDetailResponse execute(InsertServiceDetailRequest requestData) {
        try{
            technicianService.checkExistenceOfEmployee(requestData.getTechnicianId());
            serviceDetailService.createHospitalServiceEntity(requestData.getPatientId(), requestData.getServiceDetail());
            hospitalFeeService.updateHospitalFee(requestData.getPatientId(), requestData.getServiceDetail());

            return new InsertServiceDetailResponse();
        }catch (EmployeeNotFoundException e) {
            return new InsertServiceDetailResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new InsertServiceDetailResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
