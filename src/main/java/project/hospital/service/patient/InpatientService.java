package project.hospital.service.patient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.mapper.PatientMapper;
import project.hospital.mapper.TreatmentMapper;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.patient.PatientRepository;
import project.hospital.repository.treatment.HospitalFeeRepository;
import project.hospital.repository.treatment.HospitalServiceRepository;
import project.hospital.repository.treatment.TreatmentRepository;
import project.hospital.service.treatment.HospitalFeeService;

import java.util.List;

@Service
public class InpatientService extends CommonPatientService implements IPatientService<Inpatient> {

    private final InpatientRepository inpatientRepository;

    private final TreatmentRepository treatmentRepository;

    private final OutpatientService outpatientService;

    private final PatientMapper patientMapper;

    private final TreatmentMapper treatmentMapper;

    private final HospitalFeeRepository hospitalFeeRepository;

    public InpatientService(PatientRepository patientRepository,
                            InpatientRepository inpatientRepository,
                            TreatmentRepository treatmentRepository,
                            OutpatientService outpatientService,
                            PatientMapper patientMapper,
                            TreatmentMapper treatmentMapper,
                            HospitalFeeRepository hospitalFeeRepository) {
        super(patientRepository);
        this.inpatientRepository = inpatientRepository;
        this.treatmentRepository = treatmentRepository;
        this.outpatientService = outpatientService;
        this.patientMapper = patientMapper;
        this.treatmentMapper = treatmentMapper;
        this.hospitalFeeRepository = hospitalFeeRepository;
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
    public Inpatient admitInpatient(Long outpatientId, String department) {
        Outpatient outpatient = outpatientService.getPatientById(outpatientId);
        Treatment oldtreatment = treatmentRepository.findById(outpatientId).get();
        HospitalFee oldhospitalFee = hospitalFeeRepository.findById(outpatientId).get();
        Treatment newTreatment = treatmentMapper.cloneTreatment(oldtreatment);
        Inpatient inpatient = patientMapper.mapOutpatientToInpatient(outpatient);
        HospitalFee newHospitalFee = treatmentMapper.cloneHospitalFee(oldhospitalFee);

        inpatient.setDepartment(department);
        outpatientService.dischargePatient(outpatientId);
        Inpatient admittedPatient = inpatientRepository.saveAndFlush(inpatient);

        newTreatment.setPatient(admittedPatient);
        Treatment treatment = treatmentRepository.saveAndFlush(newTreatment);


        newHospitalFee.setTreatment(treatment);
        hospitalFeeRepository.save(newHospitalFee);

        return admittedPatient;
    }

    public List<Patient> getAllPatientByDepartment(String department) {
        return inpatientRepository.findAllByDepartment(department);
    }
}
