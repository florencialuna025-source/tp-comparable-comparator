package ar.edu.unlar.prog3.tp_comparable_comparator.controller;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;
import ar.edu.unlar.prog3.tp_comparable_comparator.service.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api") // Mapea la base de la URL a /api
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping("/estudiantes")
    public List<Estudiante> obtenerEstudiantes(
            @RequestParam(defaultValue = "promedio") String sortBy,
            @RequestParam(defaultValue = "asc") String order) {
        
        List<Estudiante> todos = service.obtenerTodos();
        return service.ordenar(todos, sortBy, order);
    }
}