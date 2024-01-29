package project.hospital.request.employee;

import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.request.RequestData;

public class InsertResidentDoctorRequest extends RequestData {

    private ResidentDoctor residentDoctor;

    public InsertResidentDoctorRequest(ResidentDoctor residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public ResidentDoctor getResidentDoctor() {
        return residentDoctor;
    }

    public void setResidentDoctor(ResidentDoctor residentDoctor) {
        this.residentDoctor = residentDoctor;
    }
}
