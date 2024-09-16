package entidades;

public class HabitacionSimple extends Habitacion{
    final String tipo = "Simple";
    public HabitacionSimple(int pisoHabitacion) {
        super(pisoHabitacion);

    }


    @Override
    public double calcularprecioHabitacion(int cantidadDias) {
        return cantidadDias*1000;
    }
    @Override
    public double calcularReservaHabitacion(int cantidadDias) {
        double precio = calcularprecioHabitacion(cantidadDias);
        return precio*0.2;
    }

}
