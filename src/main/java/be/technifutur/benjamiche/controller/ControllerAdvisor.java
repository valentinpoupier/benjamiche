package be.technifutur.benjamiche.controller;

import be.technifutur.benjamiche.exceptions.FormValidationException;
import be.technifutur.benjamiche.exceptions.ReferencedResourceNotFoundException;
import be.technifutur.benjamiche.exceptions.ResourceNotFoundException;
import be.technifutur.benjamiche.model.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(FormValidationException.class)
    public ResponseEntity<ErrorDTO> handleFormValidationException(FormValidationException e, HttpServletRequest request){

        ErrorDTO errorDTO = new ErrorDTO(
                request.getMethod(),
                request.getRequestURL().toString(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);

    }

    @ExceptionHandler(ReferencedResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleReferencedResourceNotFoundException(ReferencedResourceNotFoundException e, HttpServletRequest request){

        ErrorDTO errorDTO = new ErrorDTO(
                request.getMethod(),
                request.getRequestURL().toString(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){

        ErrorDTO errorDTO = new ErrorDTO(
                request.getMethod(),
                request.getRequestURL().toString(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);

    }

}
