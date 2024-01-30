package project.hospital.service.treatment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.model.treatment.Treatment;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.repository.treatment.ServiceDetailRepository;
import project.hospital.service.treatment.HospitalFeeService;
import project.hospital.service.treatment.IMoneyCountableService;
import project.hospital.service.treatment.TreatmentService;

@Service
public class ServiceDetailService implements IMoneyCountableService<ServiceDetail> {

    private final ServiceDetailRepository serviceDetailRepository;

    private final HospitalService hospitalService;

    private final TreatmentService treatmentService;

    private final HospitalFeeService hospitalFeeService;

    public ServiceDetailService(ServiceDetailRepository serviceDetailRepository, HospitalService hospitalService, TreatmentService treatmentService, HospitalFeeService hospitalFeeService) {
        this.serviceDetailRepository = serviceDetailRepository;
        this.hospitalService = hospitalService;
        this.treatmentService = treatmentService;
        this.hospitalFeeService = hospitalFeeService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createHospitalServiceEntity(Long patientId, ServiceDetail serviceDetail) {
        serviceDetail.setPatientId(patientId);
        serviceDetailRepository.save(serviceDetail);
    }

    public void deleteServiceDetail(Long serviceDetailId) {
        serviceDetailRepository.deleteById(serviceDetailId);
    }

    @Override
    public int countHospitalFee(ServiceDetail serviceDetail) {
        HospitalServiceEntity hospitalServiceEntity = hospitalService.getHospitalServiceById(serviceDetail.getServiceId());
        return hospitalServiceEntity.getUnitPrice();
    }
}
