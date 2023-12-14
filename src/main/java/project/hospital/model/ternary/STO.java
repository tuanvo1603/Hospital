package project.hospital.model.ternary;

import jakarta.persistence.*;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.treatment.Treatment;

@Entity
@Table(name = "sto")
public class STO extends Ternary{

    @OneToOne
    @JoinColumn(name = "patient_id",
            insertable = false,
            updatable = false)
    private Outpatient outpatient;

    @ManyToOne
    @JoinColumn(name = "emp_id",
            insertable = false,
            updatable = false)
    private SpecialistDoctor specialistDoctor;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "treatment_id",
            insertable = false,
            updatable = false)
    private Treatment treatment;

    public Outpatient getOutpatient() {
        return outpatient;
    }

    public SpecialistDoctor getSpecialistDoctor() {
        return specialistDoctor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setOutpatient(Outpatient outpatient) {
        this.outpatient = outpatient;
    }

    public void setSpecialistDoctor(SpecialistDoctor specialistDoctor) {
        this.specialistDoctor = specialistDoctor;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

}
