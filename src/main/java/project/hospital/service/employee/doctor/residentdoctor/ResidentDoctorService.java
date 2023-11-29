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

@Service
public class ResidentDoctorService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public ResidentDoctorService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void changePatientDepartment(String patientId, String department, Doctor doctor) {

    }

//    private RTI findPatientUpdatedTreatment(Inpatient inpatient, ResidentDoctor residentDoctor) {
//        return residentDoctor.getRtiSet().stream()
//                .filter(rti -> rti.getInpatient().getPatientId().equals(inpatient.getPatientId()))
//                .findFirst().get();
//    }
//
//    public void updatePrescriptionDetail(PrescriptionDetail prescriptionDetail,
//                                         Inpatient inpatient,
//                                         ResidentDoctor residentDoctor) {
//        this.findPatientUpdatedTreatment(inpatient, residentDoctor)
//                .getTreatment()
//                .setPrescriptionDetail(prescriptionDetail);
//        employeeRepository.save(residentDoctor);
//    }

}
