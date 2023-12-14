package project.hospital.service.employee.admin;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.patient.PatientService;
import project.hospital.service.ternary.RTIService;
import project.hospital.service.ternary.STOService;
import project.hospital.service.treatment.HospitalFeeService;
import project.hospital.service.treatment.TreatmentService;

@Service
public class UpdatePatientService {

    private final PatientService outpatientService;

    private final TreatmentService treatmentService;

    private final STOService stoService;

    private final RTIService rtiService;

    private final HospitalFeeService hospitalFeeService;

    @Autowired
    public UpdatePatientService(OutpatientService outpatientService,
                                TreatmentService treatmentService,
                                STOService stoService,
                                RTIService rtiService,
                                HospitalFeeService hospitalFeeService) {
        this.outpatientService = outpatientService;
        this.treatmentService = treatmentService;
        this.stoService = stoService;
        this.rtiService = rtiService;
        this.hospitalFeeService = hospitalFeeService;
    }

    @Transactional
    public void insertPatient(Outpatient outpatient) {
        Patient insertedPatient = outpatientService.savePatient(outpatient);
        Treatment insertedTreatment = treatmentService.initTreatment();
        stoService.initSTO(insertedPatient, insertedTreatment);
        hospitalFeeService.initHospitalFee(insertedTreatment);
    }

    @Transactional
    public void dischargePatient(Long patientId) {
        stoService.deleteSTOById(patientId);
        rtiService.deleteRTIById(patientId);
        outpatientService.deletePatientById(patientId);
    }

}
