package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.repository.patient.PatientRepository;

import java.util.List;

@Service
public abstract class PatientService{

    protected final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDTO> getPatientList() {
        return patientRepository.getPatientList();
    }

    public List<PatientDTO> searchPatientByFullName(String firstName, String lastName) {
        return patientRepository.searchPatientByFullName(firstName, lastName);
    }

    public List<PatientDTO> searchPatientByDepartment(String firstName, String department) {
        return patientRepository.searchPatientByDepartment(firstName, department);
    }

    public Patient getPatientByCitizenId(String citizenId) {
        return patientRepository.getPatientByCitizenId(citizenId);
    }

    public abstract void addPrescriptionDetail(Long patientId, PrescriptionDetail prescriptionDetail) throws PatientCanNotBeFoundException;

    public abstract void addServiceDetail(Long patientId, ServiceDetail serviceDetail) throws PatientCanNotBeFoundException;

    public abstract Patient showPatientInfo(Long patientId) throws PatientCanNotBeFoundException;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatientById(Long patientId) {
        patientRepository.deleteById(patientId);
    }

}
