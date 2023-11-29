package project.hospital.model.patient;

import jakarta.persistence.*;
import project.hospital.model.ternary.DPT;
import project.hospital.model.ternary.RTI;
import project.hospital.model.treatment.HospitalFee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Admitted_Patient")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Patient {
    @Id
    @Column(name = "patient_id")
    private String patientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "admit_time")
    private LocalDateTime admitTime;
    @Column(name = "symptom")
    private String symptom;
    @Column(name = "request")
    private String request;
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private int weight;
    @Column(name = "emp_id")
    private String employeeId;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "address")
    private String address;
    @Column(name = "nation")
    private String nation;
    @Column(name = "ethnic")
    private String ethnic;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "citizen_id")
    private String citizenId;
    @Column(name = "insurance_id")
    private String insuranceId;
    @Column(name = "emergency_cell")
    private String emergencyCell;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    protected HospitalFee hospitalFee;

    @OneToOne(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    protected DPT dpt;

    public enum Gender {
        Female,
        Male
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setAdmitTime(LocalDateTime admitTime) {
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

    public void setDob(LocalDate dob) {
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

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setHospitalFee(HospitalFee hospitalFee) {
        this.hospitalFee = hospitalFee;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getAdmitTime() {
        return admitTime;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getRequest() {
        return request;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public LocalDate getDob() {
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

    public String getEmployeeId() {
        return employeeId;
    }

    public HospitalFee getHospitalFee() {
        return hospitalFee;
    }

}