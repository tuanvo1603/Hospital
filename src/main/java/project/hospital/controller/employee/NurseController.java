package project.hospital.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hospital.api.treatment.prescriptiondetail.GetDistributedMedicationTodayApi;
import project.hospital.api.patient.inpatient.GetManagedPatientListForNurseApi;
import project.hospital.dto.PatientDTO;
import project.hospital.dto.PrescriptionDetailDTO;

import java.util.List;

@RestController
@RequestMapping("/nurse")
@PreAuthorize("hasAnyRole('NURSE')")
public class NurseController {

    private final GetManagedPatientListForNurseApi getManagedPatientListForNurseApi;

    private final GetDistributedMedicationTodayApi getDistributedMedicationTodayApi;

    @Autowired
    public NurseController(GetManagedPatientListForNurseApi getManagedPatientListForNurseApi,
                           GetDistributedMedicationTodayApi getDistributedMedicationTodayApi) {
        this.getManagedPatientListForNurseApi = getManagedPatientListForNurseApi;
        this.getDistributedMedicationTodayApi = getDistributedMedicationTodayApi;
    }

    @GetMapping("/list-managed-patient-list/{nurseId}")
    public List<PatientDTO> getManagedPatietList(@PathVariable Long nurseId) {
        return getManagedPatientListForNurseApi.getManagedPatientList(nurseId);
    }

    @GetMapping("/show-distributed-medication-today/{nurseId}/{patientId}")
    public List<PrescriptionDetailDTO> showDistributedMedicationToday(@PathVariable Long nurseId,
                                                                      @PathVariable Long patientId) {
        return getDistributedMedicationTodayApi.getDistributedMedicationToday(nurseId, patientId);
    }
}
