package project.hospital.service.employee.doctor.residentdoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.IncorrectIdException;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.repository.employee.ResidentDoctorRepository;
import project.hospital.repository.patient.InpatientRepository;

@Service
public class ResidentDoctorService {

    private final ResidentDoctorRepository residentDoctorRepository;

    private final InpatientRepository inpatientRepository;

    @Autowired
    public ResidentDoctorService(ResidentDoctorRepository residentDoctorRepository, InpatientRepository inpatientRepository) {
        this.residentDoctorRepository = residentDoctorRepository;
        this.inpatientRepository = inpatientRepository;
    }

    public void updateInpatient(Inpatient inpatient, Long employeeId) throws PatientCanNotBeFoundException, IncorrectIdException {
        if(checkPatientInDBByDoctor(inpatient, employeeId))
            inpatientRepository.save(inpatient);
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
                        .getInpatient()
                        .getPatientId()
                        .equals(inpatient.getPatientId())
                );
    }

}
