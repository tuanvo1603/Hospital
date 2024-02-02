package project.hospital.service.patient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.mapper.PatientMapper;
import project.hospital.mapper.TreatmentMapper;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
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

    private final HospitalFeeService hospitalFeeService;

    private final PatientMapper patientMapper;

    private final TreatmentMapper treatmentMapper;


    public InpatientService(PatientRepository patientRepository,
                            InpatientRepository inpatientRepository,
                            TreatmentRepository treatmentRepository,
                            HospitalFeeService hospitalFeeService,
                            PatientMapper patientMapper,
                            TreatmentMapper treatmentMapper) {
        super(patientRepository);
        this.inpatientRepository = inpatientRepository;
        this.treatmentRepository = treatmentRepository;
        this.hospitalFeeService = hospitalFeeService;
        this.patientMapper = patientMapper;
        this.treatmentMapper = treatmentMapper;
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
    public Inpatient admitInpatient(Outpatient outpatient, Treatment treatment) {
        Inpatient inpatient = patientMapper.mapOutpatientToInpatient(outpatient);
        Treatment newTreatment = treatmentMapper.cloneTreatment(treatment);
        Inpatient admittedPatient = inpatientRepository.saveAndFlush(inpatient);
        newTreatment.setPatient(admittedPatient);
        treatmentRepository.save(treatment);
        hospitalFeeService.createHospitalFee(treatment);
        return admittedPatient;
    }

    public List<Patient> getAllPatientByDepartment(String department) {
        return inpatientRepository.findAllByDepartment(department);
    }
}
