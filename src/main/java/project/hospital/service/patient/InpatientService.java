package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.exception.IncorrectIdException;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.patient.PatientDTORepository;

import java.util.List;

@Service
public class InpatientService {

    private final int FIRSTNAME = 0;
    private final InpatientRepository inpatientRepository;

    @Autowired
    public InpatientService(InpatientRepository inpatientRepository) {
        this.inpatientRepository = inpatientRepository;
    }

    public List<Patient> searchPatientByFullName(List<String> patientInfo) {
        int LASTNAME = 1;
        return inpatientRepository.searchPatientByFullName(patientInfo.get(FIRSTNAME), patientInfo.get(LASTNAME));
    }

    public List<Patient> searchPatientByDepartment(List<String> patientInfo) {
        int DEPARTMENT = 1;
        return inpatientRepository.searchPatientByDepartment(patientInfo.get(FIRSTNAME), patientInfo.get(DEPARTMENT));
    }

    public void copyOutpatientInfo(Long patientId) {
        inpatientRepository.copyOutpatientInfo(patientId);
    }

    public Inpatient showInpatientInfo(Long patientId) throws PatientCanNotBeFoundException {
        Inpatient inpatient = inpatientRepository
                                .findById(patientId)
                                .orElseThrow(PatientCanNotBeFoundException::new);
        inpatient.getRti().setInpatient(null);
        inpatient.getRti().getTreatment().setPrescriptionDetail(null);
        inpatient.getRti().getTreatment().setServiceDetails(null);
        return inpatient;
    }

    public void saveInpatient(Inpatient inpatient) {
        inpatientRepository.save(inpatient);
    }
}
