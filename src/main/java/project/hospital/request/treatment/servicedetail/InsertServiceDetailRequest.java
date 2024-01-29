package project.hospital.request.treatment.servicedetail;

import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.request.RequestData;

public class InsertServiceDetailRequest extends RequestData {

    private Long technicianId;

    private Long patientId;

    private ServiceDetail serviceDetail;

    public InsertServiceDetailRequest(Long technicianId, Long patientId, ServiceDetail serviceDetail) {
        this.technicianId = technicianId;
        this.patientId = patientId;
        this.serviceDetail = serviceDetail;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public ServiceDetail getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(ServiceDetail serviceDetail) {
        this.serviceDetail = serviceDetail;
    }
}
