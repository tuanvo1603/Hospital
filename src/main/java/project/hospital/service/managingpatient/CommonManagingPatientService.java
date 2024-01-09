package project.hospital.service.managingpatient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.IncorrectManagedEmployeeException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.patient.Patient;
import project.hospital.repository.managingpatient.ManagingPatientRepository;

import java.util.List;

@Service
public abstract class CommonManagingPatientService {

    private final ManagingPatientRepository managingPatientRepository;

    @Autowired
    public CommonManagingPatientService(ManagingPatientRepository managingPatientRepository) {
        this.managingPatientRepository = managingPatientRepository;
    }

    public void deleteManagingPatient(Long patientId) {
        managingPatientRepository.deleteById(patientId);
    }

    public abstract void assignDoctorForPatient(Long patientId, Long doctorId);

    public boolean isPatientManagedByDoctor(Long patientId, Long doctorId) {
        if(!managingPatientRepository.existsById(patientId))
            throw new PatientNotFoundException();
        if(!managingPatientRepository.existsByPatientIdAndDoctorId(patientId, doctorId))
            throw new IncorrectManagedEmployeeException();
        return true;
    }

    public abstract List<Patient> getAllManagingPatientOfDoctor(Long doctorId);

}
