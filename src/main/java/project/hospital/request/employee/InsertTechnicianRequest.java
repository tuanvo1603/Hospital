package project.hospital.request.employee;

import project.hospital.model.employee.Technician;
import project.hospital.request.RequestData;

public class InsertTechnicianRequest extends RequestData {

    private Technician technician;

    public InsertTechnicianRequest(Technician technician) {
        this.technician = technician;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }
}
