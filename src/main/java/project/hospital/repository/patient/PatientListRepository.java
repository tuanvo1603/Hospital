package project.hospital.repository.patient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.hospital.dto.PatientList;
import project.hospital.model.patient.Patient;

import java.util.List;

@Repository
@Qualifier("PatientRepositoryDTO")
public interface PatientListRepository extends JpaRepository<Patient, String> {

    @Query("SELECT new project.hospital.dto.PatientList(p.patientId, p.firstName, p.lastName, p.employeeId, p.admitTime, p.reasonSeeTheDoctor, p.request, p.height, p.weight) " +
            "FROM Patient p")
    List<PatientList> findPatients();

    @Query("SELECT new project.hospital.dto.PatientList(p.patientId, p.firstName, p.lastName, p.employeeId, p.admitTime, p.reasonSeeTheDoctor, p.request, p.height, p.weight) " +
            "FROM Patient p WHERE p.employeeId = :employeeId")
    List<PatientList> findManagedPatients(String employeeId);
}
