package project.hospital.service.employee.doctor;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.repository.patient.PatientRepository;
@Service
public class DoctorService {

    private  final PatientRepository patientRepository;

    @Autowired
    public DoctorService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void changePatientDepartment(
            String patientId,
            String department
    ) {
        patientRepository.changePatientDepartment(department, patientId);
    }
}
