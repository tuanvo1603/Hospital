package project.hospital.service.managingpatient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.employee.Nurse;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.managingpatient.ManagingInpatient;
import project.hospital.repository.managingpatient.ManagingInpatientRepository;
import project.hospital.repository.managingpatient.ManagingPatientRepository;
import project.hospital.service.employee.NurseService;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.patient.InpatientService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagingInpatientService extends CommonManagingPatientService implements IManagingPatientService<ManagingInpatient> {

    private final ManagingInpatientRepository managingInpatientRepository;

    private final InpatientService inpatientService;

    private final ResidentDoctorService residentDoctorService;

    private final NurseService nurseService;

    public ManagingInpatientService(ManagingPatientRepository managingPatientRepository,
                                    ManagingInpatientRepository managingInpatientRepository,
                                    InpatientService inpatientService,
                                    ResidentDoctorService residentDoctorService,
                                    NurseService nurseService) {
        super(managingPatientRepository);
        this.managingInpatientRepository = managingInpatientRepository;
        this.inpatientService = inpatientService;
        this.residentDoctorService = residentDoctorService;
        this.nurseService = nurseService;
    }

    @Override
    @Transactional
    public ManagingInpatient initManagingPatient(Long patientId) {
        ManagingInpatient managingInpatient = new ManagingInpatient();
        managingInpatient.setPatientId(patientId);
        return managingInpatientRepository.save(managingInpatient);
    }

    @Transactional
    public ManagingInpatient initManagingPatient(Inpatient inpatient) {
        ManagingInpatient managingInpatient = new ManagingInpatient();
        managingInpatient.setInpatient(inpatient);
        return managingInpatientRepository.save(managingInpatient);
    }

    @Override
    public ManagingInpatient getManagingPatientById(Long patientId) {
        return managingInpatientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    @Override
    public List<Patient> getAllManagingPatientOfDoctor(Long doctorId) {
        List<Patient> patientList = new ArrayList<>();
        managingInpatientRepository.findByDoctorId(doctorId).forEach(managingInpatient -> patientList.add(managingInpatient.getInpatient()));
        return patientList;
    }

    public List<Patient> getAllManagingPatientOfNurse(Long nurseId) {
        List<Patient> patientList = new ArrayList<>();
        managingInpatientRepository.findByNurseId(nurseId).forEach(managingInpatient -> patientList.add(managingInpatient.getInpatient()));
        return patientList;
    }

    public boolean isManagedPatientByDoctor(Long doctorId, Long patientId) {
        return managingInpatientRepository.existsByDoctorIdAndPatientId(doctorId, patientId);
    }

    @Override
    @Transactional
    public void updateManagingPatient(Long patientId, ManagingInpatient managingInpatient) {
        if(managingInpatientRepository.existsById(patientId))
            managingInpatientRepository.save(managingInpatient);
        else throw new PatientNotFoundException();
    }

    @Override
    @Transactional
    public void assignDoctorForPatient(Long doctorId, Long patientId) {
        ResidentDoctor residentDoctor = residentDoctorService.getEmployeeById(doctorId);
        ManagingInpatient managingInpatient = this.getManagingPatientById(patientId);
        managingInpatient.setDoctorId(residentDoctor.getEmployeeId());
        managingInpatientRepository.save(managingInpatient);
    }

    @Transactional
    public void assignNurseForPatient(Long nurseId, Long patientId) {
        Nurse nurse = nurseService.getEmployeeById(nurseId);
        ManagingInpatient managingInpatient = this.getManagingPatientById(patientId);
        managingInpatient.setNurseId(nurse.getEmployeeId());
        managingInpatientRepository.save(managingInpatient);
    }
}
