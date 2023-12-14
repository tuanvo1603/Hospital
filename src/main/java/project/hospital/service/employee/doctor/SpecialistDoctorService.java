package project.hospital.service.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Patient;
import project.hospital.model.ternary.STO;
import project.hospital.service.patient.OutpatientService;
import project.hospital.service.patient.PatientService;
import project.hospital.service.ternary.RTIService;
import project.hospital.service.ternary.STOService;

@Service
public class SpecialistDoctorService {

    private final OutpatientService outpatientService;

    private final STOService stoService;

    private final RTIService rtiService;

    @Autowired
    public SpecialistDoctorService(
            OutpatientService outpatientService,
            STOService stoService,
            RTIService rtiService) {
        this.outpatientService = outpatientService;
        this.stoService = stoService;
        this.rtiService = rtiService;
    }

    @Transactional
    public void admitInpatient(Long patientId) throws PatientCanNotBeFoundException {
        STO oldSto = stoService.getPatientFromSTO(patientId);
        outpatientService.copyPatientInfo(patientId);
        rtiService.initRTIFromSTO(oldSto);
        stoService.deleteSTOById(patientId);
        outpatientService.deletePatientById(patientId);
    }

}
