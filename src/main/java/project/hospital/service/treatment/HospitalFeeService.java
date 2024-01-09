package project.hospital.service.treatment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.TreatmentNotFoundException;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.repository.treatment.HospitalFeeRepository;

@Service
public class HospitalFeeService {

    private final HospitalFeeRepository hospitalFeeRepository;

    @Autowired
    public HospitalFeeService(HospitalFeeRepository hospitalFeeRepository) {
        this.hospitalFeeRepository = hospitalFeeRepository;
    }

    @Transactional
    public HospitalFee createHospitalFee(Long patientId) {
        HospitalFee hospitalFee = new HospitalFee();
        hospitalFee.setPatientId(patientId);
        hospitalFee.setTotalMoney(0);
        hospitalFee.setAdvancePayment(0);
        return hospitalFeeRepository.save(hospitalFee);
    }

    @Transactional
    public HospitalFee createHospitalFee(Treatment treatment) {
        HospitalFee hospitalFee = new HospitalFee();
        hospitalFee.setTotalMoney(0);
        hospitalFee.setAdvancePayment(0);
        hospitalFee.setTreatment(treatment);
        return hospitalFeeRepository.save(hospitalFee);
    }

    @Transactional
    public void updateAdvancePayment(Long patientId, int advancePayment) {
        HospitalFee hospitalFee = this.getHospitalFeeById(patientId);
        hospitalFee.setAdvancePayment(advancePayment);
        hospitalFeeRepository.save(hospitalFee);
    }

    public HospitalFee getHospitalFeeById(Long patientId) {
        return hospitalFeeRepository.findById(patientId).orElseThrow(TreatmentNotFoundException::new);
    }

    private int countPriceOfPrescription(Medication medication, int usedMedicationQuantity) {
        return usedMedicationQuantity * medication.getUnitPrice();
    }

    @Transactional
    public void updateTotalMoneyAfterAddingPrescription(Long patientId, Medication medication, int usedMedicationQuantity) {
        HospitalFee hospitalFee = this.getHospitalFeeById(patientId);
        int priceOfPrescription = this.countPriceOfPrescription(medication, usedMedicationQuantity);
        hospitalFee.setTotalMoney(hospitalFee.getTotalMoney() + priceOfPrescription);
        hospitalFeeRepository.save(hospitalFee);
    }

    @Transactional
    public void updateTotalMoneyAfterAddingService(Long patient, HospitalServiceEntity hospitalServiceEntity) {
        HospitalFee hospitalFee = this.getHospitalFeeById(patient);
        hospitalFee.setTotalMoney(hospitalFee.getTotalMoney() + hospitalServiceEntity.getUnitPrice());
        hospitalFeeRepository.save(hospitalFee);
    }
}
