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
    protected Long patientId;

    @Column(name = "emp_id")
    protected Long employeeId;

    @Column(name = "treatment_id")
    protected Long treatmentId;

    @OneToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Inpatient inpatient;

    @ManyToOne
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    private ResidentDoctor residentDoctor;

    @OneToOne(cascade = CascadeType.ALL)
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

    public Long getPatientId() {
        return patientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getTreatmentId() {
        return treatmentId;
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

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }
}
