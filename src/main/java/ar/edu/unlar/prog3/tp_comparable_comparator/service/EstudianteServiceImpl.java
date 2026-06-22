package ar.edu.unlar.prog3.tp_comparable_comparator.service;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;
import ar.edu.unlar.prog3.tp_comparable_comparator.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repository;
    private static final Map<String, Comparator<Estudiante>> ESTRATEGIAS = new HashMap<>();

    // Inicializamos las estrategias de ordenamiento (Patrón Strategy)
    static {
        // El enunciado pide que por defecto los empates se desempaten por legajo
        Comparator<Estudiante> porLegajo = Comparator.comparing(Estudiante::getLegajo);

        ESTRATEGIAS.put("promedio", Comparator.comparing(Estudiante::getPromedio).thenComparing(porLegajo));
        ESTRATEGIAS.put("edad", Comparator.comparing(Estudiante::getEdad).thenComparing(porLegajo));
        ESTRATEGIAS.put("nombre", Comparator.comparing(Estudiante::getNombre).thenComparing(porLegajo));
        ESTRATEGIAS.put("materiasAprobadas", Comparator.comparing(Estudiante::getCantidadMateriasAprobadas).thenComparing(porLegajo));
        ESTRATEGIAS.put("legajo", porLegajo);
    }

    public EstudianteServiceImpl(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return repository.obtenerTodos();
    }

    @Override
    public List<Estudiante> ordenar(List<Estudiante> lista, String sortBy, String order) {
        // Buscamos el comparador en nuestro mapa de estrategias
        Comparator<Estudiante> comparator = ESTRATEGIAS.get(sortBy);

        // Si el criterio no existe en el mapa, lanzamos una excepción (Ejercicio 9)
        if (comparator == null) {
            throw new IllegalArgumentException(sortBy);
        }

        // Duplicamos la lista para no alterar el orden del repositorio original
        List<Estudiante> listaOrdenada = new ArrayList<>(lista);

        // Si piden orden descendente, invertimos el comparador usando .reversed() (Ejercicio 5)
        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        // Ordenamos la lista aplicando la estrategia elegida
        listaOrdenada.sort(comparator);

        return listaOrdenada;
    }
}