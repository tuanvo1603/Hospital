package project.hospital.service.managingpatient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.model.employee.doctor.SpecialistDoctor;
import project.hospital.model.patient.Outpatient;
import project.hospital.model.patient.Patient;
import project.hospital.model.managingpatient.Appointment;
import project.hospital.repository.managingpatient.AppointmentRepository;
import project.hospital.repository.managingpatient.ManagingPatientRepository;
import project.hospital.service.employee.doctor.SpecialistDoctorService;
import project.hospital.service.patient.OutpatientService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService extends CommonManagingPatientService implements IManagingPatientService<Appointment> {

    private final AppointmentRepository appointmentRepository;

    private final OutpatientService outpatientService;

    private final SpecialistDoctorService specialistDoctorService;

    public AppointmentService(ManagingPatientRepository managingPatientRepository,
                              AppointmentRepository appointmentRepository,
                              OutpatientService outpatientService,
                              SpecialistDoctorService specialistDoctorService) {
        super(managingPatientRepository);
        this.appointmentRepository = appointmentRepository;
        this.outpatientService = outpatientService;
        this.specialistDoctorService = specialistDoctorService;
    }

    @Override
    @Transactional
    public Appointment initManagingPatient(Long patientId) {
        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getManagingPatientById(Long patientId) {
        return appointmentRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
    }

    @Override
    @Transactional
    public void assignDoctorForPatient(Long doctorId, Long patientId) {
        SpecialistDoctor specialistDoctor = specialistDoctorService.getEmployeeById(doctorId);
        Appointment appointment = this.getManagingPatientById(patientId);
        appointment.setDoctorId(specialistDoctor.getEmployeeId());
        appointmentRepository.save(appointment);
    }

    @Transactional
    public void assignDoctorForPatient(Long doctorId, Long patientId, Date date) {
        SpecialistDoctor specialistDoctor = specialistDoctorService.getEmployeeById(doctorId);
        Appointment appointment = this.getManagingPatientById(patientId);
        appointment.setDoctorId(specialistDoctor.getEmployeeId());
        appointment.setMeetingDate(date);
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Patient> getAllManagingPatientOfDoctor(Long doctorId) {
        List<Patient> patientList = new ArrayList<>();
        appointmentRepository.findByDoctorId(doctorId).forEach(appointment -> patientList.add(appointment.getOutpatient()));
        return patientList;
    }

    @Override
    @Transactional
    public void updateManagingPatient(Long patientId, Appointment appointment) {
        if(appointmentRepository.existsById(patientId))
            appointmentRepository.save(appointment);
        else throw new PatientNotFoundException();
    }
}
