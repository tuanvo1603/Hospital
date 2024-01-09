package project.hospital.repository.managingpatient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.managingpatient.ManagingPatient;

@Repository
public interface ManagingPatientRepository extends JpaRepository<ManagingPatient, Long> {

    boolean existsByPatientIdAndDoctorId(Long patientId, Long doctorId);
}
