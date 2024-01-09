package project.hospital.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.hospital.api.patient.SearchByFullNameApi;
import project.hospital.api.treatment.servicedetail.AddServiceDetailApi;
import project.hospital.dto.PatientDTO;
import project.hospital.model.treatment.service.ServiceDetail;


import java.util.List;

@RestController
@RequestMapping("/technician")
@PreAuthorize("hasRole('TECHNICIAN')")
public class TechnicianController {

    private final AddServiceDetailApi addServiceDetailApi;

    private final SearchByFullNameApi searchByFullNameApi;

    @Autowired
    public TechnicianController(AddServiceDetailApi addServiceDetailApi,
                                SearchByFullNameApi searchByFullNameApi) {
        this.addServiceDetailApi = addServiceDetailApi;
        this.searchByFullNameApi = searchByFullNameApi;
    }

    @PostMapping("/add-service-detail/{technicianId}/{patientId}")
    public ResponseEntity<String> addServiceDetail(@RequestBody ServiceDetail serviceDetail,
                                                   @PathVariable Long technicianId,
                                                   @PathVariable Long patientId) {
        return addServiceDetailApi.addServiceDetail(serviceDetail, technicianId, patientId);
    }

    @GetMapping("/search-by-name/{firstName}/{lastName}")
    public List<PatientDTO> searchPatientByName(@PathVariable Long administratorId,
                                                @PathVariable String firstName,
                                                @PathVariable String lastName) {
        return searchByFullNameApi.searchByFullName(administratorId, firstName, lastName);
    }
}
