package project.hospital.service.employee.doctor.specialistdoctor;

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

//    public void deleteOutpatient(String patientId) {
//        patientRepository.deleteOutpatient(patientId);
//    }

    public void admissionPatient(Inpatient inpatient) {
//        this.deleteOutpatient(inpatient.getPatientId());
        patientRepository.insertInpatient(
                inpatient.getPatientId(),
                inpatient.getDepartment(),
                inpatient.getBedCell(),
                inpatient.getRoom()
        );
    }
}
