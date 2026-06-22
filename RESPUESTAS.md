# RESPUESTAS

## Pregunta 1

Collections.sort() necesita que los elementos de la lista implementen la interfaz Comparable para conocer cuál es su orden natural. Como la clase Estudiante no implementa Comparable<Estudiante>, Java no sabe cómo comparar dos objetos de esa clase y produce un error de compilación.

## Pregunta 3

Comparable permite definir únicamente un orden natural para una clase. Si el sistema necesitara ordenar estudiantes por promedio, nombre, edad y cantidad de materias aprobadas, modificar constantemente el método `compareTo()` sería una mala práctica.

Esto violaría el principio de Responsabilidad Única (SRP), porque la clase tendría la responsabilidad de manejar múltiples criterios de ordenamiento. Además, también violaría el principio Abierto/Cerrado (OCP), ya que cada nuevo criterio obligaría a modificar la clase existente.

La solución es utilizar `Comparator`, que permite crear distintos criterios de ordenamiento sin modificar la clase `Estudiante`.

## Ejercicio 6

No es recomendable implementar un Comparator utilizando la resta de dos enteros (por ejemplo, `a - b`), porque cuando los valores son muy grandes puede producirse un overflow, obteniendo resultados incorrectos.

La forma correcta es utilizar `Integer.compare(a, b)` o `Double.compare(a, b)`, ya que estos métodos realizan la comparación de manera segura y evitan el desbordamiento de enteros.
