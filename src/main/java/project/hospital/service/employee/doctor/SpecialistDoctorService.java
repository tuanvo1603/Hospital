package project.hospital.service.employee.doctor;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.patient.Inpatient;
import project.hospital.repository.patient.PatientRepository;

@Service
public class SpecialistDoctorService {

    private final PatientRepository patientRepository;

    @Autowired
    public SpecialistDoctorService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public void deleteOutpatient(Inpatient inpatient) {
        String patientId = inpatient.getPatientId();
        patientRepository.deleteOutpatient(patientId);
    }

    @Transactional
    public void dispatchPatient(Inpatient inpatient) {
        this.deleteOutpatient(inpatient);
        patientRepository.insertInpatient(inpatient.getPatientId(),
                inpatient.getDepartment(),
                inpatient.getBedCell(),
                inpatient.getRoom());
    }
}
