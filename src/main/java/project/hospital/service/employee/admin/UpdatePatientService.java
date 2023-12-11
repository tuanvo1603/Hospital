package project.hospital.service.employee.admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.dto.PatientDTO;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.treatment.Treatment;
import project.hospital.repository.patient.OutpatientRepository;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.patient.PatientService;
import project.hospital.service.ternary.RTIService;
import project.hospital.service.ternary.STOService;
import project.hospital.service.treatment.TreatmentService;

@Service
public class UpdatePatientService {

    private final OutpatientService outpatientService;
    private final TreatmentService treatmentService;
    private final STOService stoService;
    private final PatientService patientService;
    private final RTIService rtiService;
    @Autowired
    public UpdatePatientService(OutpatientService outpatientService,
                                TreatmentService treatmentService,
                                STOService stoService,
                                PatientService patientService,
                                RTIService rtiService) {
        this.outpatientService = outpatientService;
        this.treatmentService = treatmentService;
        this.stoService = stoService;
        this.patientService = patientService;
        this.rtiService = rtiService;
    }

    @Transactional
    public void insertPatient(Outpatient outpatient) {
        Outpatient insertedPatient = outpatientService.initOutpatient(outpatient);
        Treatment insertedTreatment = treatmentService.initTreatment();
        stoService.initSTO(insertedPatient, insertedTreatment);
        treatmentService.initHospitalFee(insertedTreatment);
    }

    @Transactional
    public void dischargePatient(PatientDTO patientDTO) {
        Long id = patientDTO.getPatientId();
        stoService.deleteSTOInDB(id);
        rtiService.deleteRTIInDB(id);
        patientService.deletePatient(id);
    }

}
