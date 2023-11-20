package project.hospital.repository.patient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.hospital.dto.PatientDTO;
import project.hospital.model.Patient;

import java.util.List;
@Repository
@Qualifier("PatientRepositoryDTO")
public interface PatientRepositoryDTO extends JpaRepository<Patient, String> {

    @Query("SELECT new project.hospital.dto.PatientDTO(p.patientId, p.firstName, p.lastName, p.admitTime, p.reasonSeeTheDoctor, p.request, p.height, p.weight) FROM Patient p")
    List<PatientDTO> findAllPatients();

}
