package ar.edu.unlar.prog3.tp_comparable_comparator.model;


import java.util.Comparator;

public class ComparadoresEstudiante {

    // Lambda explícita: materias aprobadas (ascendente)
    public static Comparator<Estudiante> porMaterias =
            (e1, e2) -> Integer.compare(
                    e1.getCantidadMateriasAprobadas(),
                    e2.getCantidadMateriasAprobadas());

    // Method Reference: nombre (alfabético)
    public static Comparator<Estudiante> porNombre =
            Comparator.comparing(Estudiante::getNombre);

    // Method Reference: edad (ascendente)
    public static Comparator<Estudiante> porEdad =
            Comparator.comparing(Estudiante::getEdad);
            // Promedio descendente y, si empatan, nombre ascendente
public static Comparator<Estudiante> porPromedioYNombre =
        Comparator.comparing(Estudiante::getPromedio)
                .reversed()
                .thenComparing(Estudiante::getNombre);

// Promedio ascendente (a partir del anterior)
public static Comparator<Estudiante> porPromedioAsc =
        porPromedioYNombre.reversed();

// Materias aprobadas descendente y nombre ascendente
public static Comparator<Estudiante> porMateriasDescYNombre =
        Comparator.comparing(Estudiante::getCantidadMateriasAprobadas)
                .reversed()
                .thenComparing(Estudiante::getNombre);

}
