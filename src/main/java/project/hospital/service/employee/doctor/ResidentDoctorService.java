package project.hospital.service.employee.doctor;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.IncorrectIdException;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.repository.employee.ResidentDoctorRepository;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.service.patient.InpatientService;

@Service
public class ResidentDoctorService {

    private final ResidentDoctorRepository residentDoctorRepository;

    private final InpatientService inpatientService;

    @Autowired
    public ResidentDoctorService(ResidentDoctorRepository residentDoctorRepository, InpatientService inpatientService) {
        this.residentDoctorRepository = residentDoctorRepository;
        this.inpatientService = inpatientService;
    }

    @Transactional
    public void updateInpatient(Inpatient inpatient, Long employeeId) throws PatientCanNotBeFoundException, IncorrectIdException {
        if(checkPatientInDBByDoctor(inpatient, employeeId))
            inpatientService.saveInpatient(inpatient);
        else
            throw new PatientCanNotBeFoundException();
    }

    private ResidentDoctor getManagingDoctorById(Long employeeId) throws IncorrectIdException {
        return residentDoctorRepository.findById(employeeId).orElseThrow(IncorrectIdException::new);
    }

    private boolean checkPatientInDBByDoctor(Inpatient inpatient, Long employeeId) throws IncorrectIdException {
        return this.getManagingDoctorById(employeeId)
                    .getRtis()
                    .stream()
                    .anyMatch(rti -> rti
                                    .getPatientId()
                                    .equals(inpatient.getPatientId())
                    );
    }

}
