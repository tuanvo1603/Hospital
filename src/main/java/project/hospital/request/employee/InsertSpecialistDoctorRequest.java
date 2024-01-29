package project.hospital.request.employee;

import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.request.RequestData;

public class InsertSpecialistDoctorRequest extends RequestData {

    private SpecialistDoctor specialistDoctor;

    public InsertSpecialistDoctorRequest(SpecialistDoctor specialistDoctor) {
        this.specialistDoctor = specialistDoctor;
    }

    public SpecialistDoctor getSpecialistDoctor() {
        return specialistDoctor;
    }

    public void setSpecialistDoctor(SpecialistDoctor specialistDoctor) {
        this.specialistDoctor = specialistDoctor;
    }
}
