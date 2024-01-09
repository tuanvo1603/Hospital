package project.hospital.model.patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "family")
public class Family {

    @Id
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
    @MapsId
    @JsonIgnore
    private Inpatient inpatient;

    public String getRelationship() {
        return relationship;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Inpatient getInpatient() {
        return inpatient;
    }

    public void setInpatient(Inpatient inpatient) {
        this.inpatient = inpatient;
    }
}
