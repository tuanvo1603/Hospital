package project.hospital.api.patient.outpatient;

import org.springframework.stereotype.Component;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.service.employee.doctor.SpecialistDoctorService;
import project.hospital.service.managingpatient.AppointmentService;
import project.hospital.service.patient.OutpatientService;

import java.util.List;

@Component
public class GetListPatientHasAppointment {

    private final AppointmentService appointmentService;

    private final SpecialistDoctorService specialistDoctorService;

    private final PatientMapper patientMapper;

    public GetListPatientHasAppointment(AppointmentService appointmentService,
                                        SpecialistDoctorService specialistDoctorService,
                                        PatientMapper patientMapper) {
        this.appointmentService = appointmentService;
        this.specialistDoctorService = specialistDoctorService;
        this.patientMapper = patientMapper;
    }

    public List<PatientDTO> getListPatientHasAppointment(Long doctorId) {
        specialistDoctorService.checkExistenceOfEmployee(doctorId);
        return patientMapper.mapToPatientDTOList(appointmentService.getAllManagingPatientOfDoctor(doctorId));
    }

}
