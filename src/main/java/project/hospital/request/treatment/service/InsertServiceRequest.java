package project.hospital.request.treatment.service;

import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.request.RequestData;

public class InsertServiceRequest extends RequestData {

    private HospitalServiceEntity hospitalServiceEntity;

    public InsertServiceRequest(HospitalServiceEntity hospitalServiceEntity) {
        this.hospitalServiceEntity = hospitalServiceEntity;
    }

    public HospitalServiceEntity getHospitalServiceEntity() {
        return hospitalServiceEntity;
    }

    public void setHospitalServiceEntity(HospitalServiceEntity hospitalServiceEntity) {
        this.hospitalServiceEntity = hospitalServiceEntity;
    }
}
