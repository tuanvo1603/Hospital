package project.hospital.mapper;

import org.springframework.stereotype.Component;
import project.hospital.model.treatment.HospitalFee;
import project.hospital.model.treatment.Treatment;

@Component
public class TreatmentMapper {

    public Treatment cloneTreatment(Treatment treatment) {
        Treatment newTreatment = new Treatment();
        newTreatment.setHospitalFee(treatment.getHospitalFee());
        newTreatment.setTreatmentProcedure(treatment.getTreatmentProcedure());
        newTreatment.setDescription(treatment.getDescription());
        newTreatment.setDiagnostic(treatment.getDiagnostic());
        return newTreatment;
    }

    public HospitalFee cloneHospitalFee(HospitalFee hospitalFee) {
        HospitalFee newHospitalFee = new HospitalFee();
        newHospitalFee.setTotalMoney(hospitalFee.getTotalMoney());
        newHospitalFee.setAdvancePayment(hospitalFee.getAdvancePayment());
        return newHospitalFee;
    }
}
