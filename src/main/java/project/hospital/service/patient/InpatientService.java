package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.mapper.TreatmentMapper;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.patient.PatientRepository;
import project.hospital.repository.treatment.TreatmentRepository;
import project.hospital.service.treatment.HospitalFeeService;

import java.util.List;

@Service
public class InpatientService extends CommonPatientService implements IPatientService<Inpatient> {

    private final InpatientRepository inpatientRepository;

    private final TreatmentRepository treatmentRepository;

    private final TreatmentMapper treatmentMapper;

    private final HospitalFeeService hospitalFeeService;

    private final OutpatientService outpatientService;

    @Autowired
    public InpatientService(PatientRepository patientRepository,
                            InpatientRepository inpatientRepository,
                            TreatmentRepository treatmentRepository,
                            TreatmentMapper treatmentMapper,
                            HospitalFeeService hospitalFeeService,
                            OutpatientService outpatientService) {
        super(patientRepository);
        this.inpatientRepository = inpatientRepository;
        this.treatmentRepository = treatmentRepository;
        this.treatmentMapper = treatmentMapper;
        this.hospitalFeeService = hospitalFeeService;
        this.outpatientService = outpatientService;
    }

    @Override
    public Inpatient getPatientById(Long patientId) {
        return inpatientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    @Override
    public void checkExistenceOfPatient(Long patientId) {
        if(!inpatientRepository.existsById(patientId))
            throw new PatientNotFoundException();
    }

    @Override
    public Inpatient admitPatient(Inpatient inpatient) {
        return inpatientRepository.save(inpatient);
    }

    @Transactional
    public Inpatient admitPatient(Inpatient inpatient, Treatment treatment) {
        Inpatient admittedPatient = inpatientRepository.saveAndFlush(inpatient);
        treatment.setPatient(admittedPatient);
        treatmentRepository.save(treatment);
        hospitalFeeService.createHospitalFee(treatment);
        return admittedPatient;
    }

    public List<Patient> getAllPatientByDepartment(String department) {
        return inpatientRepository.findAllByDepartment(department);
    }
}
