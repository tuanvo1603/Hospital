package project.hospital.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.repository.patient.PatientListRepository;

@Service
public class ManagingPatientService {

    private final PatientListRepository patientListRepository;

    @Autowired
    public ManagingPatientService(PatientListRepository patientListRepository) {
        this.patientListRepository = patientListRepository;
    }

//    public List<PatientList> findManagedPatients(String employeeId) {
//        return patientListRepository.findManagedPatients(employeeId);
//    }
}
