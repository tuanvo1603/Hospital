package project.hospital.dto;

public class PatientDTO {
    private Long patientId;

    private String firstName;

    private String lastName;

    private String room;

    private Integer bedCell;

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getBedCell() {
        return bedCell;
    }

    public void setBedCell(Integer bedCell) {
        this.bedCell = bedCell;
    }
}
