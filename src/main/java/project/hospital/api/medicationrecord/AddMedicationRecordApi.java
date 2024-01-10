package project.hospital.api.medicationrecord;

import org.springframework.stereotype.Component;
import project.hospital.model.medicationrecord.MedicationRecordDetail;
import project.hospital.model.patient.Patient;
import project.hospital.service.employee.CommonEmployeeService;
import project.hospital.service.medicationrecord.MedicationRecordDetailService;
import project.hospital.service.patient.CommonPatientService;

@Component
public class AddMedicationRecordApi {

    private final MedicationRecordDetailService medicationRecordDetailService;

    private final CommonEmployeeService commonEmployeeService;

    private final CommonPatientService commonPatientService;

    public AddMedicationRecordApi(MedicationRecordDetailService medicationRecordDetailService,
                                  CommonEmployeeService commonEmployeeService,
                                  CommonPatientService commonPatientService) {
        this.medicationRecordDetailService = medicationRecordDetailService;
        this.commonEmployeeService = commonEmployeeService;
        this.commonPatientService = commonPatientService;
    }

    public MedicationRecordDetail addMedicationRecordDetail(String description, Long employeeId, Long patientId) {
        commonEmployeeService.checkExistenceOfEmployee(employeeId);
        Patient patient = commonPatientService.getPatientById(patientId);
        return medicationRecordDetailService.createMedicationRecordDetail(description, patient.getCitizenId());
    }
}
