package entidades;

import java.util.HashMap;
import java.util.Map;

public abstract class Habitacion {
    private static Map<Integer, Integer> habitacionesPorPiso = new HashMap<>();  // agregar UML
    protected int numeroHabitacion;
    protected int pisoHabitacion;
    protected EstadoHabitacion estadoHabitacion;

    public abstract double calcularprecioHabitacion(int cantidadDias);
    public abstract double calcularReservaHabitacion(int cantidadDias);

    public Habitacion(int pisoHabitacion) {
        int contadorId = habitacionesPorPiso.getOrDefault(pisoHabitacion,0);
        if (contadorId > 2){
            System.out.println("Se alcanzo el maximo de habitaciones por piso, son 3 habitaciones por piso");
            return;
        }
        this.numeroHabitacion = ++contadorId;
        habitacionesPorPiso.put(pisoHabitacion,numeroHabitacion);
        this.estadoHabitacion = EstadoHabitacion.DISPONILE;
        this.pisoHabitacion = pisoHabitacion;
        System.out.println("Se registro la habitacion: "+ this.numeroHabitacion + " En el piso: "+ this.pisoHabitacion + " Estado de la habitacion actual: "+ this.estadoHabitacion);
    }

    public boolean sosHabitacion(int pisoHabitacion, int numeroHabitacion){
        return this.pisoHabitacion == pisoHabitacion && this.numeroHabitacion == numeroHabitacion;
    }
}
