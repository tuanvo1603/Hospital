package project.hospital.api.treatment.servicedetail;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.request.treatment.servicedetail.InsertServiceDetailRequest;
import project.hospital.response.treatment.servicedetail.InsertServiceDetailResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.TechnicianService;
import project.hospital.service.treatment.service.HospitalServiceDetailService;

@Component
public class InsertServiceDetailApi extends Api<InsertServiceDetailRequest, InsertServiceDetailResponse> {

    private final TechnicianService technicianService;

    private final HospitalServiceDetailService hospitalServiceDetailService;

    public InsertServiceDetailApi(TechnicianService technicianService, HospitalServiceDetailService hospitalServiceDetailService, SessionService sessionService) {
        super(sessionService);
        this.technicianService = technicianService;
        this.hospitalServiceDetailService = hospitalServiceDetailService;
    }

    public ResponseEntity<String> addServiceDetail(ServiceDetail serviceDetail, Long technicianId, Long patientId) {
        technicianService.checkExistenceOfEmployee(technicianId);
        hospitalServiceDetailService.createHospitalServiceEntity(patientId, serviceDetail);
        return ResponseEntity.ok("Add service detail successfully");
    }

    @Override
    public InsertServiceDetailResponse execute(InsertServiceDetailRequest requestData) {
        try{
            technicianService.checkExistenceOfEmployee(requestData.getTechnicianId());
            hospitalServiceDetailService.createHospitalServiceEntity(requestData.getPatientId(), requestData.getServiceDetail());

            return new InsertServiceDetailResponse();
        }catch (EmployeeNotFoundException e) {
            return new InsertServiceDetailResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (Exception e) {
            return new InsertServiceDetailResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
