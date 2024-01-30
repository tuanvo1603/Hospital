package project.hospital.service.treatment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;
import project.hospital.model.treatment.medication.Medication;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.repository.treatment.HospitalFeeRepository;

@Service
public class HospitalFeeService {

    private final HospitalFeeRepository hospitalFeeRepository;

    private final IMoneyCountableService<PrescriptionDetail> prescriptionDetailService;

    private final IMoneyCountableService<ServiceDetail> hospitalServiceDetailService;

    public HospitalFeeService(HospitalFeeRepository hospitalFeeRepository,
                              IMoneyCountableService<PrescriptionDetail> prescriptionDetailService,
                              IMoneyCountableService<ServiceDetail> hospitalServiceDetailService) {
        this.hospitalFeeRepository = hospitalFeeRepository;
        this.prescriptionDetailService = prescriptionDetailService;
        this.hospitalServiceDetailService = hospitalServiceDetailService;
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
        return hospitalFeeRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    @Transactional
    public void updateHospitalFee(Long patientId, PrescriptionDetail prescriptionDetail) {
        HospitalFee hospitalFee = this.getHospitalFeeById(patientId);
        hospitalFee.setTotalMoney(hospitalFee.getTotalMoney() + prescriptionDetailService.countHospitalFee(prescriptionDetail));
        hospitalFeeRepository.save(hospitalFee);
    }

    @Transactional
    public void updateHospitalFee(Long patientId, ServiceDetail serviceDetail) {
        HospitalFee hospitalFee = this.getHospitalFeeById(patientId);
        hospitalFee.setTotalMoney(hospitalFee.getTotalMoney() + hospitalServiceDetailService.countHospitalFee(serviceDetail));
        hospitalFeeRepository.save(hospitalFee);
    }
}
