package ar.edu.unlar.prog3.tp_comparable_comparator;

import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPrueba {
 

    public static void main(String[] args) {

        List<Estudiante> lista = new ArrayList<>();

        lista.add(new Estudiante("LU-001", "Juan", 8.5, 20, 15));
        lista.add(new Estudiante("LU-002", "Ana", 9.2, 21, 18));
        lista.add(new Estudiante("LU-003", "Pedro", 7.6, 22, 12));
        lista.add(new Estudiante("LU-004", "Lucía", 6.8, 19, 10));
        lista.add(new Estudiante("LU-005", "Marcos", 8.9, 23, 20));

 
        System.out.println("=== Antes de ordenar ===");
       lista.forEach(System.out::println);

        Collections.sort(lista);

         System.out.println("\n=== Después de ordenar ===");
         lista.forEach(System.out::println);
       
    }
}