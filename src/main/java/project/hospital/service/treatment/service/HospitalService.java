package project.hospital.service.treatment.service;

import org.springframework.stereotype.Service;
import project.hospital.exception.ServiceNotFoundException;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.repository.treatment.HospitalServiceRepository;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalServiceRepository hospitalServiceRepository;

    public HospitalService(HospitalServiceRepository hospitalServiceRepository) {
        this.hospitalServiceRepository = hospitalServiceRepository;
    }

    public List<HospitalServiceEntity> importHospitalFeeService(List<HospitalServiceEntity> hospitalServiceEntityList) {
        return hospitalServiceRepository.saveAll(hospitalServiceEntityList);
    }

    public void deleteHospitalService(Long serviceId) {
        hospitalServiceRepository.deleteById(serviceId);
    }

    public HospitalServiceEntity getHospitalServiceById(Long serviceId) {
        return hospitalServiceRepository.findById(serviceId).orElseThrow(ServiceNotFoundException::new);
    }

    public void updateHospitalService(Long serviceId, HospitalServiceEntity hospitalServiceEntity) {
        if(hospitalServiceRepository.existsById(serviceId))
            hospitalServiceRepository.save(hospitalServiceEntity);
        else throw new ServiceNotFoundException();
    }
}
