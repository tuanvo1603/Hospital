package project.hospital.repository.managingpatient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.hospital.model.managingpatient.ManagingInpatient;

import java.util.List;

@Repository
public interface ManagingInpatientRepository extends JpaRepository<ManagingInpatient, Long> {
    List<ManagingInpatient> findByDoctorId(Long doctorId);

    List<ManagingInpatient> findByNurseId(Long nurseId);

    boolean existsByDoctorIdAndPatientId(Long doctorId, Long patientId);
}
