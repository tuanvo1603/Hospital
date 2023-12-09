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

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private PrescriptionDetail prescriptionDetail;

    @OneToMany(
            mappedBy = "treatment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<ServiceDetail> serviceDetails;

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private RTI rti;

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private STO sto;

    @OneToOne(
            mappedBy = "treatment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
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

    public PrescriptionDetail getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public List<ServiceDetail> getServiceDetails() {
        return serviceDetails;
    }

    public STO getSto() {
        return sto;
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

    public void setPrescriptionDetail(PrescriptionDetail prescriptionDetail) {
        this.prescriptionDetail = prescriptionDetail;
    }

    public void setServiceDetails(List<ServiceDetail> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public void setRti(RTI rti) {
        this.rti = rti;
    }

    public void setSto(STO sto) {
        this.sto = sto;
    }

    public void setHospitalFee(HospitalFee hospitalFee) {
        this.hospitalFee = hospitalFee;
    }
}
