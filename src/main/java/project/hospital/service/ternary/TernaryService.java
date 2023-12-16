package project.hospital.service.ternary;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hospital.exception.PatientCanNotBeFoundException;
import project.hospital.model.ternary.DTP;
import project.hospital.repository.ternary.TernaryRepository;

@Service
public abstract class TernaryService {

    private final TernaryRepository ternaryRepository;

    @Autowired
    public TernaryService(TernaryRepository ternaryRepository) {
        this.ternaryRepository = ternaryRepository;
    }

    @Transactional
    public void setDoctorInTernary(Long doctorId, Long patientId) throws PatientCanNotBeFoundException {
        DTP DTP = ternaryRepository.findById(patientId)
                                            .orElseThrow(PatientCanNotBeFoundException::new);
        DTP.setEmployeeId(doctorId);
        ternaryRepository.save(DTP);
    }
}
