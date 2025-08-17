package pe.edu.cibertec.msproductservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.edu.cibertec.msproductservice.dtos.ErrorResponse;
import pe.edu.cibertec.msproductservice.exceptions.ProductNotFoundException;
import pe.edu.cibertec.msproductservice.models.Product;

import java.time.LocalDateTime;

import static pe.edu.cibertec.msproductservice.exceptions.ErrorCatalog.PRODUCT_NOT_FOUND;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException() {
        return ErrorResponse.builder()
                .code(PRODUCT_NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND)
                .message(PRODUCT_NOT_FOUND.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
