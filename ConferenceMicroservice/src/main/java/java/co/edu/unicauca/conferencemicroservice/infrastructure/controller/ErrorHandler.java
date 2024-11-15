package java.co.edu.unicauca.conferencemicroservice.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.co.edu.unicauca.conferencemicroservice.application.dto.ErrorDTO;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.DuplicateInformation;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.InvalidValue;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.NotFound;
import java.co.edu.unicauca.conferencemicroservice.domain.exception.Unauthorized;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    /**
     * Handler DuplicateInformation exception
     * @param exception exception threw
     * @param request request of the client
     * @return The appropriate error
     */
    @ExceptionHandler(DuplicateInformation.class)
    public ResponseEntity<ErrorDTO> handlerDuplicateInformation(DuplicateInformation exception, WebRequest request){
        ErrorDTO response = new ErrorDTO(
                "DuplicateInformation, some value is already exist",
                exception.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    /**
     * Handler InvalidValue exception
     * @param exception exception threw
     * @param request request of the client
     * @return The appropriate error
     */
    @ExceptionHandler(InvalidValue.class)
    public ResponseEntity<ErrorDTO> handlerInvalidValue( InvalidValue exception, WebRequest request){
        ErrorDTO response = new ErrorDTO(
                "Invalid Value: The values sender are invalid",
                exception.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
    /**
     * Handler NotFound exception
     * @param exception exception threw
     * @param request request of the client
     * @return The appropriate error
     */
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErrorDTO> handlerNotFound( NotFound exception, WebRequest request){
        ErrorDTO response = new ErrorDTO(
                "Not Found: The source doesn't exist",
                exception.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
    /**
     * Handler Unauthorized exception
     * @param exception exception threw
     * @param request request of the client
     * @return The appropriate error
     */
    @ExceptionHandler(Unauthorized.class)
    public ResponseEntity<ErrorDTO> handlerUnauthorized( Unauthorized exception, WebRequest request){
        ErrorDTO response = new ErrorDTO(
                "Unauthorized: You don't have the permission",
                exception.getMessage()
        );
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }
}
