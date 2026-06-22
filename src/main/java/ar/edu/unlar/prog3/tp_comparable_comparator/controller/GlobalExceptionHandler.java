package ar.edu.unlar.prog3.tp_comparable_comparator.controller;



import ar.edu.unlar.prog3.tp_comparable_comparator.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Lista de criterios aceptados tal cual lo pide la consigna
    private static final List<String> CRITERIOS_ACEPTADOS = Arrays.asList(
            "promedio", "edad", "nombre", "materiasAprobadas", "legajo"
    );

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidSortBy(IllegalArgumentException ex) {
        
        // Creamos la estructura de error solicitada en el Ejercicio 9
        ErrorResponseDTO errorBody = new ErrorResponseDTO(
                "Criterio de ordenamiento no válido",
                ex.getMessage(), // El service nos pasa el sortBy incorrecto acá
                CRITERIOS_ACEPTADOS
        );

        // Devolvemos el JSON acompañado de un HTTP 400 Bad Request
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }
}