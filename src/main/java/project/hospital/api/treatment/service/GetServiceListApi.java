package project.hospital.api.treatment.service;

import org.springframework.stereotype.Component;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.service.treatment.service.HospitalService;

import java.util.List;

@Component
public class GetServiceListApi {

    private final HospitalService hospitalService;

    public GetServiceListApi(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    public List<HospitalServiceEntity> getServiceList() {
        return hospitalService.getHospitalServiceList();
    }
}
