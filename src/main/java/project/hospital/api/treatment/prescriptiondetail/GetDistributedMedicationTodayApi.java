package project.hospital.api.treatment.prescriptiondetail;

import org.springframework.stereotype.Component;
import project.hospital.dto.PrescriptionDetailDTO;
import project.hospital.mapper.PrescriptionDetailMapper;
import project.hospital.service.employee.NurseService;
import project.hospital.service.treatment.prescription.PrescriptionDetailService;

import java.util.List;

@Component
public class GetDistributedMedicationTodayApi {

    private final NurseService nurseService;

    private final PrescriptionDetailService prescriptionDetailService;

    private final PrescriptionDetailMapper prescriptionDetailMapper;

    public GetDistributedMedicationTodayApi(NurseService nurseService,
                                            PrescriptionDetailService prescriptionDetailService,
                                            PrescriptionDetailMapper prescriptionDetailMapper) {
        this.nurseService = nurseService;
        this.prescriptionDetailService = prescriptionDetailService;
        this.prescriptionDetailMapper = prescriptionDetailMapper;
    }

    public List<PrescriptionDetailDTO> getDistributedMedicationToday(Long nurseId, Long patientId) {
        nurseService.checkExistenceOfEmployee(nurseId);
        return prescriptionDetailMapper.mapToPrescriptionDetailDTOList(prescriptionDetailService.getAllDistributedPrescription(patientId));
    }
}
