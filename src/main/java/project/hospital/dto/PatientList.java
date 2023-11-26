package project.hospital.dto;

import java.time.LocalDateTime;

public class PatientList {
    private String patientId;
    private String firstName;
    private String lastName;
    private LocalDateTime admitTime;
    private String employeeId;
    private String reasonSeeTheDoctor;
    private String request;
    private int height;
    private int weight;

    public PatientList(String patientId, String firstName, String lastName, String employeeId, LocalDateTime admitTime, String reasonSeeTheDoctor, String request, int height, int weight) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admitTime = admitTime;
        this.employeeId = employeeId;
        this.reasonSeeTheDoctor = reasonSeeTheDoctor;
        this.request = request;
        this.height = height;
        this.weight = weight;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setAdmitTime(LocalDateTime admitTime) {
        this.admitTime = admitTime;
    }

    public void setReasonSeeTheDoctor(String reasonSeeTheDoctor) {
        this.reasonSeeTheDoctor = reasonSeeTheDoctor;
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

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatientId() {
        return patientId;
    }

    public LocalDateTime getAdmitTime() {
        return admitTime;
    }

    public String getReasonSeeTheDoctor() {
        return reasonSeeTheDoctor;
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
}
