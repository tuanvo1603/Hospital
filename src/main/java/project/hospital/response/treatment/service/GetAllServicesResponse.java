package project.hospital.response.treatment.service;

import org.springframework.web.bind.annotation.ResponseBody;
import project.hospital.model.treatment.service.HospitalServiceEntity;
import project.hospital.response.ResponseData;

import java.util.List;

@ResponseBody
public class GetAllServicesResponse extends ResponseData {

    private List<HospitalServiceEntity> hospitalServiceEntityList;

    public GetAllServicesResponse(int code, String message) {
        super(code, message);
    }

    public GetAllServicesResponse(List<HospitalServiceEntity> hospitalServiceEntityList) {
        this.hospitalServiceEntityList = hospitalServiceEntityList;
    }

    public List<HospitalServiceEntity> getHospitalServiceEntityList() {
        return hospitalServiceEntityList;
    }

    public void setHospitalServiceEntityList(List<HospitalServiceEntity> hospitalServiceEntityList) {
        this.hospitalServiceEntityList = hospitalServiceEntityList;
    }
}
