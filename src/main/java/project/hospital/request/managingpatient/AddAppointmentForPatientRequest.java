package project.hospital.request.managingpatient;

import project.hospital.request.RequestData;

import java.sql.Date;

public class AddAppointmentForPatientRequest extends RequestData {

    private Long doctorId;

    private Long patientId;

    private Date date;

    public AddAppointmentForPatientRequest(Long doctorId, Long patientId, Date date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
