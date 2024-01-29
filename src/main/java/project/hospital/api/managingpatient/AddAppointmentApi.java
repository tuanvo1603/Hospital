package project.hospital.api.managingpatient;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.exception.PatientNotFoundException;
import project.hospital.request.managingpatient.AddAppointmentForPatientRequest;
import project.hospital.response.managingpatient.AssignDoctorForPatientResponse;
import project.hospital.service.SessionService;
import project.hospital.service.managingpatient.AppointmentService;

@Component
public class AddAppointmentApi extends Api<AddAppointmentForPatientRequest, AssignDoctorForPatientResponse> {

    private final AppointmentService appointmentService;

    public AddAppointmentApi(SessionService sessionService, AppointmentService appointmentService) {
        super(sessionService);
        this.appointmentService = appointmentService;
    }

    @Override
    public AssignDoctorForPatientResponse execute(AddAppointmentForPatientRequest requestData) {
        try{
            appointmentService.assignDoctorForPatient(requestData.getDoctorId(), requestData.getPatientId(), requestData.getDate());
            return new AssignDoctorForPatientResponse("Add appointment successfully.");
        }catch (EmployeeNotFoundException e) {
            return new AssignDoctorForPatientResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (PatientNotFoundException e) {
            return new AssignDoctorForPatientResponse(StatusCode.REQUEST.getCode(), "Patient may not be managed in system.");
        }catch (Exception e) {
            return new AssignDoctorForPatientResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
