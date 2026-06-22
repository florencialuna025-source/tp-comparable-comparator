package ar.edu.unlar.prog3.tp_comparable_comparator;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;
import ar.edu.unlar.prog3.tp_comparable_comparator.model.ComparadoresEstudiante;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPrueba {
 

    public static void main(String[] args) {

        List<Estudiante> lista = new ArrayList<>();

        lista.add(new Estudiante("LU-2024-001","Martín Quiroga",8.5,22,18));
        lista.add(new Estudiante("LU-2024-002","Valeria Díaz",8.5,20,15));
        lista.add(new Estudiante("LU-2024-003","Facundo Castro",7.2,24,22));
        lista.add(new Estudiante("LU-2024-004","Camila Torres",9.1,21,24));
        lista.add(new Estudiante("LU-2024-005","Lucas González",9.1,23,24));
        lista.add(new Estudiante("LU-2024-006","Agustina López",6.8,19,10));
        lista.add(new Estudiante("LU-2024-007","Nahuel Herrera",7.5,22,14));
        lista.add(new Estudiante("LU-2024-008","Florencia Ríos",8.9,25,20));
        lista.add(new Estudiante("LU-2024-009","Tomás Sosa",6.5,20,12));
       
 
        System.out.println("=== Antes de ordenar ===");
       lista.forEach(System.out::println);

        Collections.sort(lista);

         System.out.println("\n=== Después de ordenar ===");
         lista.forEach(System.out::println);

         System.out.println("\n=== Orden por nombre ===");
         lista.sort(ComparadoresEstudiante.porNombre);
         lista.forEach(System.out::println);

         System.out.println("\n=== Orden por edad ===");
         lista.sort(ComparadoresEstudiante.porEdad);
         lista.forEach(System.out::println);

               System.out.println("\n=== Orden por materias aprobadas ===");
             lista.sort(ComparadoresEstudiante.porMaterias);
         lista.forEach(System.out::println);
       
    }
}