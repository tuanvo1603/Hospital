package project.hospital.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.treatment.servicedetail.AddServiceDetailApi;
import project.hospital.model.treatment.service.ServiceDetail;

@Controller
@RequestMapping("/technician")
public class TechnicianController {

    private final AddServiceDetailApi addServiceDetailApi;

    @Autowired
    public TechnicianController(AddServiceDetailApi addServiceDetailApi) {
        this.addServiceDetailApi = addServiceDetailApi;
    }

    @PostMapping("/add-service-detail/{technicianId}/{patientId}")
    public ResponseEntity<String> addServiceDetail(@RequestBody ServiceDetail serviceDetail,
                                                   @PathVariable Long technicianId,
                                                   @PathVariable Long patientId) {
        return addServiceDetailApi.addServiceDetail(serviceDetail, technicianId, patientId);
    }

    @GetMapping
    public String getMedication(){
        return "add-prescription";
    }
}
