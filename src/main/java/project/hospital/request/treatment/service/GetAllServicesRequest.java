package project.hospital.request.treatment.service;

import project.hospital.request.RequestData;

public class GetAllServicesRequest extends RequestData {

    private int page;

    private int size;

    public GetAllServicesRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
