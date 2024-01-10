package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.patient.Patient;
import project.hospital.repository.patient.PatientRepository;

import java.util.List;

@Service
public class CommonPatientService {

    protected final PatientRepository patientRepository;

    @Autowired
    public CommonPatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void dischargePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    public Patient getPatientByCitizenId(String citizenId) {
        return patientRepository.findPatientByCitizenId(citizenId);
    }

    public List<Patient> findAllPatientsByFullName(String firstName, String lastName) {
        return patientRepository.findPatientByFirstNameAndLastName(firstName, lastName);
    }

}
