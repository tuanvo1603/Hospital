package project.hospital.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.hospital.exception.IncorrectIdException;
import project.hospital.exception.PatientCanNotBeFoundException;

@RestControllerAdvice
public class NoSuchElementController {

    @ExceptionHandler(PatientCanNotBeFoundException.class)
    public ResponseEntity<String> handleNoPatientInDB(PatientCanNotBeFoundException exception) {
        return new ResponseEntity<>("This patient is not in Database or managed by other Doctors", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectIdException.class)
    public ResponseEntity<String> handleIncorrectEmployeeId(IncorrectIdException exception) {
        return new ResponseEntity<>("Incorrect Employee ID", HttpStatus.NOT_FOUND);
    }
}
