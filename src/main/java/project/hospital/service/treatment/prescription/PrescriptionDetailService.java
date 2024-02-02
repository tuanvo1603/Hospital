package project.hospital.service.treatment.prescription;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.dto.PrescriptionDetailDTO;
import project.hospital.exception.MedicationQuantityNotEnoughException;
import project.hospital.mapper.PrescriptionDetailMapper;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.repository.treatment.PrescriptionDetailRepository;
import project.hospital.service.DateService;
import project.hospital.service.treatment.IMoneyCountableService;

import java.sql.Date;
import java.util.List;

@Service
public class PrescriptionDetailService implements IMoneyCountableService<PrescriptionDetail> {

    private final PrescriptionDetailRepository prescriptionDetailRepository;

    private final DateService dateService;

    private final MedicationService medicationService;

    private final PrescriptionDetailMapper prescriptionDetailMapper;

    public PrescriptionDetailService(PrescriptionDetailRepository prescriptionDetailRepository,
                                     DateService dateService,
                                     MedicationService medicationService,
                                     PrescriptionDetailMapper prescriptionDetailMapper) {
        this.prescriptionDetailRepository = prescriptionDetailRepository;
        this.dateService = dateService;
        this.medicationService = medicationService;
        this.prescriptionDetailMapper = prescriptionDetailMapper;
    }

    private int countUsedMedicationQuantity(PrescriptionDetail prescriptionDetail) {
        int daysOfUsing = dateService.countDaysInPeriod(prescriptionDetail.getStartTime(), prescriptionDetail.getEndTime());
        return daysOfUsing * prescriptionDetail.getQuantityPerDay();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createPrescriptionDetail(Long patientId, PrescriptionDetail prescriptionDetail) {
        Medication medication = medicationService.getMedicationById(prescriptionDetail.getMedicationId());
        int usedMedicationQuantity = this.countUsedMedicationQuantity(prescriptionDetail);
        if (medicationService.isEnoughMedicationRemainingQuantity(medication, usedMedicationQuantity)) {
            medicationService.updateRemainingQuantity(medication, usedMedicationQuantity);
            prescriptionDetail.setPatientId(patientId);
            prescriptionDetailRepository.save(prescriptionDetail);
        } else throw new MedicationQuantityNotEnoughException();
    }

    public void deletePrescription(Long prescriptionDetailId) {
        prescriptionDetailRepository.deleteById(prescriptionDetailId);
    }

    public List<PrescriptionDetailDTO> getAllPrescriptionTodayByPatientId(Long patientId) {
        Date today = dateService.getToday();
        List<PrescriptionDetail> prescriptionDetailList = prescriptionDetailRepository.findAllByPatientId(patientId);
        return prescriptionDetailMapper.mapToPrescriptionDetailDTOList(
                prescriptionDetailList
                        .stream()
                        .filter(prescriptionDetail -> dateService.isDateBetweenPeriod(today, prescriptionDetail.getStartTime(), prescriptionDetail.getEndTime()))
                        .toList());
    }

    @Override
    public int countHospitalFee(PrescriptionDetail prescriptionDetail) {
        int usedMedicationQuantity = this.countUsedMedicationQuantity(prescriptionDetail);
        Medication medication = medicationService.getMedicationById(prescriptionDetail.getMedicationId());
        return usedMedicationQuantity * medication.getUnitPrice();
    }
}
