package project.hospital.service.employee.doctor;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.ternary.STO;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.ternary.STORepository;
import project.hospital.service.patient.OutpatientService;
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
    public void admissionPatient(Inpatient inpatient) throws PatientCanNotBeFoundException {
        Outpatient outpatient = outpatientService.copyPatientInfo(inpatient);
        STO oldSto = stoService.getPatientSTO(outpatient);
        rtiService.initRTIFromSTO(oldSto);
        stoService.deleteSTOInDB(oldSto.getPatientId());
        outpatientService.deleteOutpatient(outpatient);
    }
}
