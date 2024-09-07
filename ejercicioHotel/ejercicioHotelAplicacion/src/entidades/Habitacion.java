package entidades;

public abstract class Habitacion {
    protected int numeroHabitacion;
    protected int pisoHabitacion;
    protected double precioHabitacion;
    //protected EstadoHabitacion estadoHabitacion;

    protected abstract double calcularprecioHabitacion();

}
