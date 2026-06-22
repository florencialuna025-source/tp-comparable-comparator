package ar.edu.unlar.prog3.tp_comparable_comparator.service;


import ar.edu.unlar.prog3.tp_comparable_comparator.model.Estudiante;

import java.util.List;

public interface EstudianteService {

    List<Estudiante> obtenerTodos();
    List<Estudiante> ordenar(List<Estudiante> lista, String sortBy, String order); 
   

   }

