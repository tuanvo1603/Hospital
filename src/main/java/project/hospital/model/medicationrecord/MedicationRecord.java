package project.hospital.model.medicationrecord;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "medication_record")
public class MedicationRecord {

    @Id
    @Column(name = "citizenId")
    private String citizenId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String address;

    @Column(name = "nation")
    private String nation;

    @Column(name = "ethnic")
    private String ethnic;

    @Column(name = "occupation")
    private String occupation;

    @OneToMany(
            cascade = CascadeType.PERSIST,
            mappedBy = "medicationRecord",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<MedicationRecordDetail> medicationRecordDetailList;


    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public List<MedicationRecordDetail> getMedicationRecordDetailList() {
        return medicationRecordDetailList;
    }

    public void setMedicationRecordDetailList(List<MedicationRecordDetail> medicationRecordDetailList) {
        this.medicationRecordDetailList = medicationRecordDetailList;
    }
}
