package ar.edu.unlar.prog3.tp_comparable_comparator.dto;


import java.util.List;

public class ErrorResponseDTO {
    private String error;
    private String criterioRecibido;
    private List<String> criteriosAceptados;

    public ErrorResponseDTO(String error, String criterioRecibido, List<String> criteriosAceptados) {
        this.error = error;
        this.criterioRecibido = criterioRecibido;
        this.criteriosAceptados = criteriosAceptados;
    }

    // Getters (necesarios para que Spring los transforme a JSON)
    public String getError() { return error; }
    public String getCriterioRecibido() { return criterioRecibido; }
    public List<String> getCriteriosAceptados() { return criteriosAceptados; }
}