package entidades;

public class HabitacionDoble extends Habitacion{
    final String tipo = "Doble";
    public HabitacionDoble(int pisoHabitacion) {
        super(pisoHabitacion);
    }

    @Override
    public double calcularprecioHabitacion(int cantidadDias) {
        return cantidadDias*2000;
    }

    @Override
    public double calcularReservaHabitacion(int cantidadDias) {
        double precio = calcularprecioHabitacion(cantidadDias);
        return precio*0.8;
    }
}
