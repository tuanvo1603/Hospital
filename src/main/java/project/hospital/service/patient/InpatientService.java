package project.hospital.service.patient;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.repository.patient.InpatientRepository;
import project.hospital.repository.patient.PatientRepository;

import java.util.List;

@Service
public class InpatientService extends PatientService{
    private final InpatientRepository inpatientRepository;

    @Autowired
    public InpatientService(PatientRepository patientRepository, InpatientRepository inpatientRepository) {
        super(patientRepository);
        this.inpatientRepository = inpatientRepository;
    }


    @Override
    @Transactional
    public void addPrescriptionDetail(Long patientId, PrescriptionDetail prescriptionDetail) throws PatientCanNotBeFoundException {
        Inpatient inpatient = this.findPatientById(patientId);
        inpatient.getRti()
                .getTreatment()
                .getPrescriptionDetails()
                .add(prescriptionDetail);
        inpatientRepository.save(inpatient);
    }

    @Override
    @Transactional
    public void addServiceDetail(Long patientId, ServiceDetail serviceDetail) throws PatientCanNotBeFoundException {
        Inpatient inpatient = this.findPatientById(patientId);
        inpatient.getRti()
                .getTreatment()
                .getServiceDetails()
                .add(serviceDetail);
        inpatientRepository.save(inpatient);
    }

    public Inpatient findPatientById(Long patientId) throws PatientCanNotBeFoundException {
        return inpatientRepository
                .findById(patientId)
                .orElseThrow(PatientCanNotBeFoundException::new);
    }

    @Override
    public Patient showPatientInfo(Long patientId) throws PatientCanNotBeFoundException {
        Inpatient inpatient = inpatientRepository
                                .findById(patientId)
                                .orElseThrow(PatientCanNotBeFoundException::new);
        inpatient.getRti().getTreatment().setPrescriptionDetails(null);
        inpatient.getRti().getTreatment().setServiceDetails(null);
        return inpatient;
    }

}
