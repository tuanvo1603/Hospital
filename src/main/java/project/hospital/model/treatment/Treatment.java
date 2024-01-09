package project.hospital.model.treatment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;

import java.util.List;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "diagnostic")
    private String diagnostic;

    @Column(name = "treatment_procedure")
    private String treatmentProcedure;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
    @MapsId
    @JsonIgnore
    private Patient patient;

    @OneToMany(
            mappedBy = "treatment",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PrescriptionDetail> prescriptionDetailList;

    @OneToMany(
            mappedBy = "treatment",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ServiceDetail> serviceDetailList;

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private HospitalFee hospitalFee;

    public String getTreatmentProcedure() {
        return treatmentProcedure;
    }

    public String getDescription() {
        return description;
    }

    public void setTreatmentProcedure(String treatmentProcedure) {
        this.treatmentProcedure = treatmentProcedure;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public List<PrescriptionDetail> getPrescriptionDetailList() {
        return prescriptionDetailList;
    }

    public void setPrescriptionDetailList(List<PrescriptionDetail> prescriptionDetailList) {
        this.prescriptionDetailList = prescriptionDetailList;
    }

    public List<ServiceDetail> getServiceDetailList() {
        return serviceDetailList;
    }

    public void setServiceDetailList(List<ServiceDetail> serviceDetailList) {
        this.serviceDetailList = serviceDetailList;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HospitalFee getHospitalFee() {
        return hospitalFee;
    }

    public void setHospitalFee(HospitalFee hospitalFee) {
        this.hospitalFee = hospitalFee;
    }
}
