package project.hospital.model.ternary;

import jakarta.persistence.*;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.treatment.Treatment;

@Entity
@Table(name = "rti")
public class RTI extends DTP {

    @OneToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    protected Inpatient inpatient;

    @ManyToOne
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    protected ResidentDoctor residentDoctor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    protected Treatment treatment;

    public ResidentDoctor getResidentDoctor() {
        return residentDoctor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setResidentDoctor(ResidentDoctor residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

}
