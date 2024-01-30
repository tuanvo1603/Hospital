package project.hospital.api.treatment.prescriptiondetail;

import org.springframework.stereotype.Component;
import project.hospital.api.Api;
import project.hospital.constant.StatusCode;
import project.hospital.exception.*;
import project.hospital.request.treatment.prescription.InsertPrescriptionRequest;
import project.hospital.response.treatment.prescription.InsertPrescriptionResponse;
import project.hospital.service.SessionService;
import project.hospital.service.employee.doctor.ResidentDoctorService;
import project.hospital.service.patient.InpatientService;
import project.hospital.service.treatment.prescription.PrescriptionDetailService;

@Component
public class AddPrescriptionDetailForInpatientApi extends Api<InsertPrescriptionRequest, InsertPrescriptionResponse> {

    private final ResidentDoctorService residentDoctorService;

    private final PrescriptionDetailService prescriptionDetailService;

    private final InpatientService inpatientService;

    public AddPrescriptionDetailForInpatientApi(ResidentDoctorService residentDoctorService, PrescriptionDetailService prescriptionDetailService, SessionService sessionService, InpatientService inpatientService) {
        super(sessionService);
        this.residentDoctorService = residentDoctorService;
        this.prescriptionDetailService = prescriptionDetailService;
        this.inpatientService = inpatientService;
    }

    @Override
    public InsertPrescriptionResponse execute(InsertPrescriptionRequest requestData) {
        try {
            residentDoctorService.checkExistenceOfEmployee(requestData.getDoctorId());
            inpatientService.checkExistenceOfPatient(requestData.getPatientId());
            prescriptionDetailService.createPrescriptionDetail(requestData.getPatientId(), requestData.getPrescriptionDetail());

            return new InsertPrescriptionResponse();
        }catch (PatientNotFoundException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "Patient may be not managed in system.");
        }catch (EmployeeNotFoundException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "Error in employeeId.");
        }catch (TreatmentNotFoundException e){
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "There is no treatment of the patient in system.");
        }catch (MedicationNotFoundException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "Error in medicationId.");
        }catch (MedicationQuantityNotEnoughException e) {
            return new InsertPrescriptionResponse(StatusCode.REQUEST.getCode(), "There is not enough medication quantity in medication warehouse.");
        }catch (Exception e) {
            return new InsertPrescriptionResponse(StatusCode.UNKNOWN.getCode(), e.getMessage());
        }
    }
}
