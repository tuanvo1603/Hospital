package project.hospital.model.treatment;

import jakarta.persistence.*;
import project.hospital.model.ternary.RTI;
import project.hospital.model.ternary.STO;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @Column(name = "treatment_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatment_sequence_generator")
    @SequenceGenerator(name = "treatment_sequence_generator", sequenceName = "treatment_sequence", allocationSize = 1)
    private Long treatmentId;

    @Column(name = "treatment_procedure")
    private String treatmentProcedure;

    @Column(name = "description")
    private String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private List<PrescriptionDetail> prescriptionDetails;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private List<ServiceDetail> serviceDetails;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "treatment_id")
    private HospitalFee hospitalFee;

    public Long getTreatmentId() {
        return treatmentId;
    }

    public String getTreatmentProcedure() {
        return treatmentProcedure;
    }

    public String getDescription() {
        return description;
    }

    public List<PrescriptionDetail> getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public List<ServiceDetail> getServiceDetails() {
        return serviceDetails;
    }

    public HospitalFee getHospitalFee() {
        return hospitalFee;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public void setTreatmentProcedure(String treatmentProcedure) {
        this.treatmentProcedure = treatmentProcedure;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrescriptionDetails(List<PrescriptionDetail> prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }

    public void addPrescriptionDetail(PrescriptionDetail prescriptionDetail) {
        this.prescriptionDetails.add(prescriptionDetail);
    }

    public void setServiceDetails(List<ServiceDetail> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public void setHospitalFee(HospitalFee hospitalFee) {
        this.hospitalFee = hospitalFee;
    }

}
