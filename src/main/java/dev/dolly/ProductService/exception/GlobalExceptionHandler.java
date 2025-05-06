package dev.dolly.ProductService.exception;

import dev.dolly.ProductService.dtos.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value= ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(ProductNotFoundException ex){
        ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCategoryNotFoundException(CategoryNotFoundException ex){
        ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= DuplicateCategoryNameException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateCategoryNameException(DuplicateCategoryNameException ex){
        ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO();
        errorResponseDTO.setMessage(ex.getMessage());
        errorResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
    }
}
