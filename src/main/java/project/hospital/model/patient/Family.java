package project.hospital.model.patient;

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

    @OneToOne
    @JoinColumn(name = "patient_id")
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

}
