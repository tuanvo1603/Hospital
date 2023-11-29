package project.hospital.model.ternary;

import jakarta.persistence.*;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.Treatment;

@Entity
@Table(name = "DPT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DPT {

    @Id
    @Column(name = "patient_id")
    protected String patientId;

    @Column(name = "emp_id")
    protected String employeeId;

    @Column(name = "treatment_id")
    protected String treatmentId;

    @OneToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    protected Patient patient;

    @ManyToOne
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    protected Doctor doctor;

    @OneToOne
    @JoinColumn(name = "treatment_id", insertable = false, updatable = false)
    protected Treatment treatment;

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
