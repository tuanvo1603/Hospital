package project.hospital.request.treatment.service;

import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.request.RequestData;

public class UpdateServiceRequest extends RequestData {

    private Long serviceId;

    private HospitalServiceEntity hospitalServiceEntity;

    public UpdateServiceRequest(Long serviceId, HospitalServiceEntity hospitalServiceEntity) {
        this.serviceId = serviceId;
        this.hospitalServiceEntity = hospitalServiceEntity;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public HospitalServiceEntity getHospitalServiceEntity() {
        return hospitalServiceEntity;
    }

    public void setHospitalServiceEntity(HospitalServiceEntity hospitalServiceEntity) {
        this.hospitalServiceEntity = hospitalServiceEntity;
    }
}
