package project.hospital.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.model.patient.Inpatient;
import project.hospital.model.treatment.Treatment;
import project.hospital.service.treatment.TreatmentService;

@Service
public class TreatmentMapper {

    private final TreatmentService treatmentService;

    @Autowired
    public TreatmentMapper(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    public Treatment mapTreatmentOutpatientToInpatient(Long outpatientId, Inpatient inpatient) {
        Treatment mappedTreatment = treatmentService.getTreatmentById(outpatientId);
        Treatment treatment = new Treatment();
        treatment.setPatient(inpatient);
        treatment.setHospitalFee(mappedTreatment.getHospitalFee());
        treatment.setTreatmentProcedure(mappedTreatment.getTreatmentProcedure());
        treatment.setDescription(mappedTreatment.getDescription());
        treatment.setDiagnostic(mappedTreatment.getDiagnostic());
        return treatment;
    }
}
