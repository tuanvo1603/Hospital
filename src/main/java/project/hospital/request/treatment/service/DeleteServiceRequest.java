package project.hospital.request.treatment.service;

import project.hospital.request.RequestData;

public class DeleteServiceRequest extends RequestData {

    private Long serviceId;

    public DeleteServiceRequest(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
