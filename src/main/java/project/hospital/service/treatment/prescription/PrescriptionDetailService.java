package project.hospital.service.treatment.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.MedicationQuantityNotEnoughException;
import project.hospital.model.treatment.Treatment;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.repository.treatment.PrescriptionDetailRepository;
import project.hospital.service.DateService;
import project.hospital.service.treatment.HospitalFeeService;
import project.hospital.service.treatment.TreatmentService;

import java.sql.Date;
import java.util.List;

@Service
public class PrescriptionDetailService {

    private final PrescriptionDetailRepository prescriptionDetailRepository;

    private final DateService dateService;

    private final MedicationService medicationService;

    private final TreatmentService treatmentService;

    private final HospitalFeeService hospitalFeeService;

    @Autowired
    public PrescriptionDetailService(PrescriptionDetailRepository prescriptionDetailRepository, DateService dateService, MedicationService medicationService, TreatmentService treatmentService, HospitalFeeService hospitalFeeService) {
        this.prescriptionDetailRepository = prescriptionDetailRepository;
        this.dateService = dateService;
        this.medicationService = medicationService;
        this.treatmentService = treatmentService;
        this.hospitalFeeService = hospitalFeeService;
    }

    private int countUsedMedicationQuantity(PrescriptionDetail  prescriptionDetail) {
        int daysOfUsing = dateService.countDaysInPeriod(prescriptionDetail.getStartTime(), prescriptionDetail.getEndTime());
        return daysOfUsing * prescriptionDetail.getQuantityPerDay();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createPrescriptionDetail(Long patientId, PrescriptionDetail prescriptionDetail) {
        Treatment treatment = treatmentService.getTreatmentById(patientId);
        Medication medication = medicationService.getMedicationById(prescriptionDetail.getMedicationId());
        int usedMedicationQuantity = this.countUsedMedicationQuantity(prescriptionDetail);
        if(medicationService.isEnoughMedicationRemainingQuantity(medication, usedMedicationQuantity)) {
            medicationService.updateRemainingQuantity(medication, usedMedicationQuantity);
            hospitalFeeService.updateTotalMoneyAfterAddingPrescription(patientId, medication, usedMedicationQuantity);
            prescriptionDetail.setPatientId(patientId);
            prescriptionDetailRepository.save(prescriptionDetail);
        }
        else throw new MedicationQuantityNotEnoughException();
    }

    public void deletePrescription(Long prescriptionDetailId) {
        prescriptionDetailRepository.deleteById(prescriptionDetailId);
    }

    public List<PrescriptionDetail> getAllDistributedPrescription(Long patientId) {
        Date today = dateService.getToday();
        List<PrescriptionDetail> prescriptionDetailList = prescriptionDetailRepository.findAllByPatientId(patientId);
        return prescriptionDetailList
                .stream()
                .filter(prescriptionDetail -> dateService.isDateBetweenPeriod(today, prescriptionDetail.getStartTime(), prescriptionDetail.getEndTime()))
                .toList();
    }

}
