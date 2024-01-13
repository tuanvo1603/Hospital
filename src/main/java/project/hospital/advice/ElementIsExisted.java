package project.hospital.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.hospital.exception.CitizenIdIsExistedException;

@RestControllerAdvice
public class ElementIsExisted {

    @ExceptionHandler(CitizenIdIsExistedException.class)
    public ResponseEntity<String> handleCitizenIdIsExisted(CitizenIdIsExistedException exception) {
        return new ResponseEntity<>("CitizenId is already used.", HttpStatus.CONFLICT);
    }
}
