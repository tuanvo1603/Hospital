package project.hospital.service.treatment.service;

import org.springframework.data.domain.Pageable;
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

    public HospitalServiceEntity importHospitalFeeService(HospitalServiceEntity hospitalServiceEntity) {
        return hospitalServiceRepository.save(hospitalServiceEntity);
    }

    public List<HospitalServiceEntity> getHospitalServiceList(int page, int size) {
        return hospitalServiceRepository.findAll(Pageable.ofSize(size).withPage(page)).getContent();
    }

    public void deleteHospitalService(Long serviceId) {
        if(!hospitalServiceRepository.existsById(serviceId))
            throw new ServiceNotFoundException();
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
