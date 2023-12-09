package project.hospital.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Patient;

import java.util.List;

@Repository
public interface PatientDTORepository extends JpaRepository<Patient, Long> {

    @Query("SELECT new project.hospital.dto.PatientDTO(p.patientId, p.firstName, p.lastName, p.employeeId, p.admitTime, p.symptom, p.request, p.height, p.weight) " +
            "FROM Patient p"
    )
    List<PatientDTO> findPatients();


//    @Query("SELECT new project.hospital.dto.PatientList(p.patientId, p.firstName, p.lastName, p.employeeId, p.admitTime, p.symptom, p.request, p.height, p.weight) " +
//            "FROM Patient p WHERE p.employeeId = :employeeId")
//    List<PatientDTO> findManagedPatients(String employeeId);
    //To-do
}
