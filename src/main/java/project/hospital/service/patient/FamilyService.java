package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.patient.Family;
import project.hospital.model.patient.Inpatient;
import project.hospital.repository.patient.FamilyRepository;

@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

    private final InpatientService inpatientService;

    @Autowired
    public FamilyService(FamilyRepository familyRepository, InpatientService inpatientService1) {
        this.familyRepository = familyRepository;
        this.inpatientService = inpatientService1;
    }

    public Family createFamily(Long patientId, Family family) {
        Inpatient inpatient = inpatientService.getPatientById(patientId);
        family.setInpatient(inpatient);
        return familyRepository.save(family);
    }

    public Family getFamilyById(Long patientId) {
        return familyRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    public void updateFamily(Long patientId, Family family) {
        if(familyRepository.existsById(patientId))
            familyRepository.save(family);
        else
            throw new PatientNotFoundException();
    }

    public void deleteFamily(Long patientId) {
        familyRepository.deleteById(patientId);
    }
}
