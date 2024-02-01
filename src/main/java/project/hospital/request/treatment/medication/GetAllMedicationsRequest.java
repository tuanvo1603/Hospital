package project.hospital.request.treatment.medication;

import project.hospital.request.RequestData;

public class GetAllMedicationsRequest extends RequestData {

    private int page;

    private int size;

    public GetAllMedicationsRequest(int page, int size) {
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
