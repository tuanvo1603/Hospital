package project.hospital.service.employee.doctor;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.IncorrectIdException;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.repository.employee.ResidentDoctorRepository;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.patient.PatientService;

import java.util.List;
import java.util.Objects;

@Service
public class ResidentDoctorService {

    private final ResidentDoctorRepository residentDoctorRepository;

    private final PatientService patientService;

    @Autowired
    public ResidentDoctorService(ResidentDoctorRepository residentDoctorRepository, InpatientService inpatientService) {
        this.residentDoctorRepository = residentDoctorRepository;
        this.patientService = inpatientService;
    }

    private ResidentDoctor getManagingDoctorById(Long employeeId) throws IncorrectIdException {
        return residentDoctorRepository
                .findById(employeeId)
                .orElseThrow(IncorrectIdException::new);
    }

    private boolean isPatientManagedByDoctor(Long employeeId, Long patientId) throws IncorrectIdException {
        return this.getManagingDoctorById(employeeId)
                    .getRtis()
                    .stream()
                    .anyMatch(rti -> Objects.equals(rti
                            .getPatientId(), patientId)
                    );
    }

    @Transactional
    public void addPrescriptionDetail(PrescriptionDetail prescriptionDetail,
                                      Long employeeId,
                                      Long patientId) throws PatientCanNotBeFoundException, IncorrectIdException {
        if(isPatientManagedByDoctor(employeeId, patientId)){
            patientService.addPrescriptionDetail(patientId, prescriptionDetail);
        }
        else
            throw new PatientCanNotBeFoundException();
    }

    public Patient searchInpatientByCitizenId(String citizenId) {
        return patientService.searchPatientByCitizenId(citizenId);
    }
}
