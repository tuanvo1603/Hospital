package project.hospital.model.patient;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Admitted_Patient")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence_generator")
    @SequenceGenerator(name = "patient_sequence_generator", sequenceName = "patient_sequence", allocationSize = 1)
    @Column(name = "patient_id", nullable = false, unique = true)
    protected Long patientId;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "admit_time")
    protected LocalDateTime admitTime;

    @Column(name = "symptom")
    protected String symptom;

    @Column(name = "request")
    protected String request;

    @Column(name = "height")
    protected int height;

    @Column(name = "weight")
    protected int weight;

    @Column(name = "emp_id")
    protected String employeeId;

    @Column(name = "dob")
    protected LocalDate dob;

    @Column(name = "address")
    protected String address;

    @Column(name = "nation")
    protected String nation;

    @Column(name = "ethnic")
    protected String ethnic;

    @Column(name = "occupation")
    protected String occupation;

    @Column(name = "citizen_id")
    protected String citizenId;

    @Column(name = "insurance_id")
    protected String insuranceId;

    @Column(name = "emergency_cell")
    protected String emergencyCell;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    protected Gender gender;

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

    public Long getPatientId() {
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

}