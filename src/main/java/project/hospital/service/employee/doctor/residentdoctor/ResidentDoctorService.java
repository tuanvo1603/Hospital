package project.hospital.service.employee.doctor.residentdoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.employee.doctor.Doctor;
import project.hospital.model.employee.doctor.ResidentDoctor;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.ternary.RTI;
import project.hospital.model.treatment.medication.PrescriptionDetail;
import project.hospital.model.treatment.service.ServiceDetail;
import project.hospital.repository.employee.EmployeeRepository;
import project.hospital.repository.patient.PatientRepository;

@Service
public class ResidentDoctorService {

    private final EmployeeRepository employeeRepository;

    private final PatientRepository patientRepository;

    @Autowired
    public ResidentDoctorService(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }

    public void updateInpatient(Inpatient inpatient) {
        patientRepository.save(inpatient);
    }

    private RTI findPatientUpdatedTreatment(Inpatient inpatient, ResidentDoctor residentDoctor) {
        return residentDoctor.getRtis()
                .stream()
                .filter(rti -> rti.getInpatient().getPatientId().equals(inpatient.getPatientId()))
                .findFirst().get();
    }

    public void updatePrescriptionDetail(PrescriptionDetail prescriptionDetail,
                                         Inpatient inpatient,
                                         ResidentDoctor residentDoctor) {
        this.findPatientUpdatedTreatment(inpatient, residentDoctor)
                .getTreatment()
                .setPrescriptionDetail(prescriptionDetail);
        employeeRepository.save(residentDoctor);
    }

}
