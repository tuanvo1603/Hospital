package project.hospital.api.treatment.servicedetail;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.service.employee.TechnicianService;
import project.hospital.service.treatment.service.HospitalServiceDetailService;

@Component
public class AddServiceDetailApi {

    private final TechnicianService technicianService;

    private final HospitalServiceDetailService hospitalServiceDetailService;

    public AddServiceDetailApi(TechnicianService technicianService, HospitalServiceDetailService hospitalServiceDetailService) {
        this.technicianService = technicianService;
        this.hospitalServiceDetailService = hospitalServiceDetailService;
    }

    public ResponseEntity<String> addServiceDetail(ServiceDetail serviceDetail, Long technicianId, Long patientId) {
        technicianService.checkExistenceOfEmployee(technicianId);
        hospitalServiceDetailService.createHospitalServiceEntity(patientId, serviceDetail);
        return ResponseEntity.ok("Add service detail successfully");
    }
}
