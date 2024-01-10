package project.hospital.repository.managingpatient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.managingpatient.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId);

    boolean existsByDoctorIdAndPatientId(Long doctorId, Long patientId);
}
