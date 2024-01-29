package project.hospital.request.employee;

import project.hospital.model.employee.Nurse;
import project.hospital.request.RequestData;

public class InsertNurseRequest extends RequestData {

    private Nurse nurse;

    public InsertNurseRequest(Nurse nurse) {
        this.nurse = nurse;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
}
