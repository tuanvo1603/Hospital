package project.hospital.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.api.patient.GetInpatientsManagedByNurseApi;
import project.hospital.api.treatment.prescriptiondetail.GetDistributedMedicationTodayApi;
import project.hospital.request.patient.GetInpatientsManagedByNurseRequest;
import project.hospital.request.treatment.prescription.GetDistributedMedicationTodayRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.response.treatment.prescription.GetDistributedMedicationTodayResponse;

import java.util.List;

@RestController
@RequestMapping("/nurse")
@PreAuthorize("hasRole('NURSE')")
public class NurseController {

    private final GetInpatientsManagedByNurseApi getInpatientManagedByNurseApi;

    private final GetDistributedMedicationTodayApi getDistributedMedicationTodayApi;

    @Autowired
    public NurseController(GetInpatientsManagedByNurseApi getInpatientsManagedByNurseApi,
                           GetDistributedMedicationTodayApi getDistributedMedicationTodayApi) {
        this.getInpatientManagedByNurseApi = getInpatientsManagedByNurseApi;
        this.getDistributedMedicationTodayApi = getDistributedMedicationTodayApi;
    }

    @GetMapping("/list-managed-patient-list/{nurseId}")
    public GetPatientsResponse getManagedPatientList(@PathVariable Long nurseId) {
        GetInpatientsManagedByNurseRequest getInpatientsManagedByNurseRequest = new GetInpatientsManagedByNurseRequest(nurseId);
        return getInpatientManagedByNurseApi.execute(getInpatientsManagedByNurseRequest);
    }

    @GetMapping("/show-distributed-medication-today/{nurseId}/{patientId}")
    public GetDistributedMedicationTodayResponse showDistributedMedicationToday(@PathVariable Long nurseId,
                                                                                @PathVariable Long patientId) {
        GetDistributedMedicationTodayRequest getDistributedMedicationTodayRequest = new GetDistributedMedicationTodayRequest(nurseId, patientId);
        return getDistributedMedicationTodayApi.execute(getDistributedMedicationTodayRequest);
    }
}
