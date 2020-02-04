# Actividad práctica voluntaria de IAW

En el IES Jesús Marín se va a desarrollar un torneo de debates. En el torneo participarán institutos de la provincia de Málaga, a los que llamaremos *equipos*. El torneo estará compuesto por varias fases:

- Fase de grupos
- Fase de octavos de final
- Fase de cuartos de final
- Fase consolatoria de cuartos
- Fase de semifinales
- Fase final

Habrá un conjunto de aulas que estarán disponibles para cada fase, según decida el equipo educativo del centro. Estas aulas podrán ser asignadas a cada uno de los enfrentamientos.

A continuación se pasa a detallar cada una de las fases:

## Fase de grupos

En la fase de grupos, 28 equipos se enfrentarán entre sí siguiendo las siguientes reglas:
- Los 28 equipos se organizarán en 7 grupos de 4 equipos cada uno. 
- Los equipos de cada grupo se enfrentarán en tres rondas.
- En cada ronda habrán dos enfrentamientos, en los que se enfrentarán los equipos dos a dos.
- Al terminar la tercera ronda, cada equipo de cada grupo se habrán enfrentado con todos los demás de su grupo.

## Fase de octavos de final

De acuerdo a criterios ajenos a la aplicación, se indicarán 16 equipos que participarán en esta fase. Estos equipos pueden estar entre los equipos de la *Fase de grupos* o no (se pueden incorporar nuevos equipos). Los equipos de octavos de final se enfrentarán por parejas, quedando un total de 8 enfrentamientos. Los ganadores de cada enfrentamiento pasarán a la fase de cuartos de final.

## Fase de cuartos de final

Los ganadores de la fase anterior se vuelven a enfrentar por parejas. De un total de 8 equipos, habrán 4 enfrentamientos. Los ganadores pasarán a semifinales.

## Fase consolatoria de cuartos

Los equipos perdedores de cuartos de final, se enfrentarán en una fase consolatoria por parejas. En total, 4 equipos se enfrentarán por parejas en 2 enfrentamientos. 

## Fase de semifinales

Los equipos ganadores de cuartos de final, se enfrentarán en semifinales. 4 equipos se enfrentarán por parejas en 2 enfrentamientos. Los dos equipos ganadores se enfrentarán en la final.

## Fase final

Los 2 equipos ganadores de semifinal, se enfrentarán en una final.

# Se pide

0. Diseñar un sistema para introducir las aulas disponibles en cada fase.
### Fase de grupos
1. Diseñar un sistema para introducir los equipos que participarán en la *fase de grupos*
2. Planificar automáticamente los grupos de la *fase de grupos*. Éstos deben ser aleatorios. 
3. Planificar automáticamente los enfrentamientos por rondas de la *fase de grupos*. 
4. Asignar automáticamente las aulas disponibles, de manera que dos enfrentamientos no puedan ocurrir en la misma aula durante la misma ronda.
5. Mostrar la información anterior de manera clara. 
> Se desea que la información se muestre con cierto "suspense", para que haya cierto espectáculo alrededor de los equipos que forman los grupos y los enfrentamientos, ya que la aplicación se ejecutará en un auditorio.
### Fase de octavos de final
6. Diseñar un sistema para introducir los equipos que participarán en la *fase de octavos de final*.
7. Planificar automáticamente los enfrentamientos de la fase *octavos de final*.
8. Asignar automaticamente las aulas disponibles, de manera que dos enfrentamientos no puedan ocurrir en la misma aula.
9. Mostrar la información anterior de manera clara.
### Fase cuartos de final
10. Planificar automáticamente los enfrentamientos de *cuartos de final* a partir de los ganadores de la fase anterior.
11. Asignar automáticamente las aulas disponibles, de manera que  dos enfrentamientos no puedan ocurrir en la misma aula.
12. Mostrar la información anterior de manera clara.
### Fase consolatoria de cuartos
13. Planificar automáticamente los enfrentamientos de *cuartos de final* a partir de los perdedores de la fase anterior.
14. Asignar automáticamente las aulas disponibles, de manera que  dos enfrentamientos no puedan ocurrir en la misma aula.
15. Mostrar la información anterior de manera clara.
### Fase de semifinales
16. Planificar automáticamente los enfrentamientos de *semifinales* a partir de los ganadores de *cuartos*.
17. Asignar automáticamente las aulas disponibles, de manera que  dos enfrentamientos no puedan ocurrir en la misma aula.
18. Mostrar la información anterior de manera clara.
### Fase final
19. Planificar el enfrentamiento de *final* a partir de los perdedores de la fase anterior.
20. Asignar automáticamente un aula para el enfrentamiento.
21. Mostrar la información anterior de manera clara.
### Otras consideraciones
22. Toda la información debe estar respaldada de algún modo, de manera que se pueda consultar en cualquier momento.
23. Sólo un usuario con permisos podrá realizar los sorteos y decidir los ganadores de una fase.
24. Cualquier persona podrá consultar los resultados.
### Características opcionales
25. Opcionalmente, se puede dar la opción de reiniciar una fase para volver a sortearla por cualquier motivo.
26. Una fase se considera cerrada cuando ya se considera terminada, y no admite modificaciones de ningún tipo.

