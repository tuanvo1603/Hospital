package project.hospital.api.treatment;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.EmployeeNotFoundException;
import project.hospital.exception.IncorrectManagedEmployeeException;
import project.hospital.exception.TreatmentNotFoundException;
import project.hospital.request.treatment.InsertTreatmentRequest;
import project.hospital.response.treatment.InsertTreatmentResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.managingpatient.ManagingInpatientService;
import project.hospital.service.treatment.TreatmentService;

@Component
public class InsertTreatmentApi extends Api<InsertTreatmentRequest, InsertTreatmentResponse> {

    private final ManagingInpatientService managingInpatientService;

    private final ResidentDoctorService residentDoctorService;

    private final TreatmentService treatmentService;

    public InsertTreatmentApi(ManagingInpatientService managingInpatientService,
                              ResidentDoctorService residentDoctorService,
                              TreatmentService treatmentService,
                              SessionService sessionService) {
        super(sessionService);
        this.managingInpatientService = managingInpatientService;
        this.residentDoctorService = residentDoctorService;
        this.treatmentService = treatmentService;
    }

    @Override
    public InsertTreatmentResponse execute(InsertTreatmentRequest requestData) {
        try{
            residentDoctorService.checkExistenceOfEmployee(requestData.getDoctorId());
            if(!managingInpatientService.isManagedPatientByDoctor(requestData.getDoctorId(), requestData.getPatientId())) {
                throw new IncorrectManagedEmployeeException();
            }
            treatmentService.updateTreatment(requestData.getDoctorId(), requestData.getTreatment());

            return new InsertTreatmentResponse();
        }catch (EmployeeNotFoundException e) {
            return new InsertTreatmentResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (IncorrectManagedEmployeeException e) {
            return new InsertTreatmentResponse(StatusCode.REQUEST.getCode(), "Patient is not managed by this doctor.");
        }catch (TreatmentNotFoundException e) {
            return new InsertTreatmentResponse(StatusCode.REQUEST.getCode(), "Patient does not have treatment.");
        }catch (Exception e){
            return new InsertTreatmentResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
