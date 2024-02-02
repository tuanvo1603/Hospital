package project.hospital.controller.employee;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.treatment.servicedetail.InsertServiceDetailApi;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.request.treatment.servicedetail.InsertServiceDetailRequest;
import project.hospital.response.treatment.servicedetail.InsertServiceDetailResponse;


@RestController
@RequestMapping("/v1/technician")
@PreAuthorize("hasRole('TECHNICIAN')")
public class TechnicianController {

    private final InsertServiceDetailApi insertServiceDetailApi;

    public TechnicianController(InsertServiceDetailApi insertServiceDetailApi) {
        this.insertServiceDetailApi = insertServiceDetailApi;
    }

    @PostMapping("/add-service-detail/{technicianId}/{patientId}")
    public InsertServiceDetailResponse addServiceDetail(@RequestBody ServiceDetail serviceDetail,
                                                        @PathVariable Long technicianId,
                                                        @PathVariable Long patientId) {
        InsertServiceDetailRequest insertServiceDetailRequest = new InsertServiceDetailRequest(technicianId, patientId, serviceDetail);
        return insertServiceDetailApi.execute(insertServiceDetailRequest);
    }
}
