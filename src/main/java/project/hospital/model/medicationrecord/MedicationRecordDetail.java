package project.hospital.model.medicationrecord;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "medication_record_detail")
public class MedicationRecordDetail {

    @Id
    @Column(name = "citizenId")
    private String citizenId;

    @Column(name = "admit_time")
    private Date admitTime;

    @Column(name = "symptom")
    private String symptom;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "citizenId")
    @MapsId
    @JsonBackReference
    private MedicationRecord medicationRecord;

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public Date getAdmitTime() {
        return admitTime;
    }

    public void setAdmitTime(Date admitTime) {
        this.admitTime = admitTime;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MedicationRecord getMedicationRecord() {
        return medicationRecord;
    }

    public void setMedicationRecord(MedicationRecord medicationRecord) {
        this.medicationRecord = medicationRecord;
    }
}
