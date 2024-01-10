package project.hospital.model.patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import project.hospital.model.treatment.Treatment;

import java.sql.Date;

@Entity
@Table(name = "patient")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @Column(name = "patient_id")
    protected Long patientId;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "admit_time")
    protected Date admitTime;

    @Column(name = "symptom")
    protected String symptom;

    @Column(name = "request")
    protected String request;

    @Column(name = "height")
    protected Integer height;

    @Column(name = "weight")
    protected Integer weight;

    @Column(name = "emp_id")
    protected Long employeeId;

    @Column(name = "dob")
    protected Date dob;

    @Column(name = "address")
    protected String address;

    @Column(name = "nation")
    protected String nation;

    @Column(name = "ethnic")
    protected String ethnic;

    @Column(name = "occupation")
    protected String occupation;

    @Column(name = "citizen_id", unique = true)
    protected String citizenId;

    @Column(name = "insurance_id")
    protected String insuranceId;

    @Column(name = "emergency_cell")
    protected String emergencyCell;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    protected Gender gender;

    @Column(name = "bed_cell")
    protected Integer bedCell;

    @Column(name = "room")
    protected String room;

    @OneToOne(
            mappedBy = "patient",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Treatment treatment;

    public enum Gender {
        Female,
        Male
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setAdmitTime(Date admitTime) {
        this.admitTime = admitTime;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setEmergencyCell(String emergencyCell) {
        this.emergencyCell = emergencyCell;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getAdmitTime() {
        return admitTime;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getRequest() {
        return request;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getNation() {
        return nation;
    }

    public String getEthnic() {
        return ethnic;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public String getEmergencyCell() {
        return emergencyCell;
    }

    public Gender getGender() {
        return gender;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Integer getBedCell() {
        return bedCell;
    }

    public void setBedCell(Integer bedCell) {
        this.bedCell = bedCell;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}