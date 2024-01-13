package project.hospital.api.managingpatient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.hospital.service.managingpatient.AppointmentService;

import java.sql.Date;

@Component
public class AddAppointmentApi {

    private final AppointmentService appointmentService;

    public AddAppointmentApi(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ResponseEntity<String> addAppointment(Long specialistDoctorId, Long outpatientId, Date date) {
        appointmentService.assignDoctorForPatient(specialistDoctorId, outpatientId,date);
        return ResponseEntity.ok("Add appointment detail successfully");
    }
}
