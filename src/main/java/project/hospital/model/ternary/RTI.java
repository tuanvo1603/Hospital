package project.hospital.model.ternary;

import jakarta.persistence.*;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.Treatment;

import javax.print.Doc;

@Entity
@Table(name = "rti")
public class RTI {

    @Id
    @Column(name = "patient_id")
    protected String patientId;

    @Column(name = "emp_id")
    protected String employeeId;

    @Column(name = "treatment_id")
    protected String treatmentId;

    @OneToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Inpatient inpatient;

    @ManyToOne
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    private ResidentDoctor residentDoctor;

    @OneToOne
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    private Treatment treatment;

    public Inpatient getInpatient() {
        return inpatient;
    }

    public ResidentDoctor getResidentDoctor() {
        return residentDoctor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setInpatient(Inpatient inpatient) {
        this.inpatient = inpatient;
    }

    public void setResidentDoctor(ResidentDoctor residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
