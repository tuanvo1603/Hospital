package project.hospital.api.patient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.dto.PatientDTO;
import project.hospital.mapper.PatientMapper;
import project.hospital.model.patient.Patient;
import project.hospital.request.patient.GetPatientsHaveAppointmentRequest;
import project.hospital.response.patient.GetPatientsResponse;
import project.hospital.service.SessionService;
import project.hospital.service.managingpatient.AppointmentService;

import java.util.List;

@Component
public class GetPatientsHaveAppointmentApi extends Api<GetPatientsHaveAppointmentRequest, GetPatientsResponse> {

    private final AppointmentService appointmentService;

    private final PatientMapper patientMapper;

    public GetPatientsHaveAppointmentApi(SessionService sessionService, AppointmentService appointmentService, PatientMapper patientMapper) {
        super(sessionService);
        this.appointmentService = appointmentService;
        this.patientMapper = patientMapper;
    }


    @Override
    public GetPatientsResponse execute(GetPatientsHaveAppointmentRequest requestData) {
        try{
            List<Patient> patientList = appointmentService.getAllManagingPatientOfDoctor(requestData.getEmployeeId());
            List<PatientDTO> patientDTOList = patientMapper.mapToPatientDTOList(patientList);

            return new GetPatientsResponse(patientDTOList);
        }catch (Exception e) {
            return new GetPatientsResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
