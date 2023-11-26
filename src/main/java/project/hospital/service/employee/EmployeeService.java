package project.hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientList;
import project.hospital.repository.patient.PatientListRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final PatientListRepository patientListRepository;

    @Autowired
    public EmployeeService(PatientListRepository patientListRepository) {
        this.patientListRepository = patientListRepository;
    }

    public List<PatientList> findManagedPatients(String employeeId) {
        return patientListRepository.findManagedPatients(employeeId);
    }
}
