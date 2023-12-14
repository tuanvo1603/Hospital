package project.hospital.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.repository.patient.OutpatientRepository;
import project.hospital.repository.patient.PatientRepository;

@Service
public class OutpatientService extends PatientService{
    private final OutpatientRepository outpatientRepository;

    @Autowired
    public OutpatientService(PatientRepository patientRepository, OutpatientRepository outpatientRepository) {
        super(patientRepository);
        this.outpatientRepository = outpatientRepository;
    }

    public void copyPatientInfo(Long patientId){
        patientRepository.copyOutpatientInfo(patientId);
    }

    @Override
    public void addPrescriptionDetail(Long patientId, PrescriptionDetail prescriptionDetail) throws PatientCanNotBeFoundException {
        Outpatient outpatient = this.findPatientById(patientId);
        outpatient.getSto()
                .getTreatment()
                .getPrescriptionDetails()
                .add(prescriptionDetail);
        patientRepository.save(outpatient);
    }

    @Override
    public void addServiceDetail(Long patientId, ServiceDetail serviceDetail) throws PatientCanNotBeFoundException {
        Outpatient outpatient = this.findPatientById(patientId);
        outpatient.getSto()
                .getTreatment()
                .getServiceDetails()
                .add(serviceDetail);
        patientRepository.save(outpatient);
    }

    public Outpatient findPatientById(Long patientId) throws PatientCanNotBeFoundException {
        return outpatientRepository
                .findById(patientId)
                .orElseThrow(PatientCanNotBeFoundException::new);
    }

    @Override
    public Patient showPatientInfo(Long patientId) throws PatientCanNotBeFoundException {
        return this.findPatientById(patientId);
    }

}
