package project.hospital.api.treatment.hospitalfee;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.service.employee.AdministratorService;
import project.hospital.service.treatment.HospitalFeeService;

@Component
public class UpdateAdvancePaymentApi {

    private final AdministratorService administratorService;

    private final HospitalFeeService hospitalFeeService;

    public UpdateAdvancePaymentApi(AdministratorService administratorService, HospitalFeeService hospitalFeeService) {
        this.administratorService = administratorService;
        this.hospitalFeeService = hospitalFeeService;
    }

    public ResponseEntity<String> updateAdvancedPayment(Long administratorId, Long patientId, Integer advancedPayment) {
        administratorService.checkExistenceOfEmployee(administratorId);
        hospitalFeeService.updateAdvancePayment(patientId, advancedPayment);
        return ResponseEntity.ok("Update advanced payment successfully");
    }
}
