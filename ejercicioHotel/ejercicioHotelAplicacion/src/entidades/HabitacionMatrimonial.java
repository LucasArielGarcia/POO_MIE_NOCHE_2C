package entidades;

public class HabitacionMatrimonial extends Habitacion{
    final String tipo = "Matrimonial";
    public HabitacionMatrimonial(int pisoHabitacion) {
        super(pisoHabitacion);
    }

    @Override
    public double calcularprecioHabitacion(int cantidadDias) {
        return cantidadDias*2500;
    }
    @Override
    public double calcularReservaHabitacion(int cantidadDias) {
        double precio = calcularprecioHabitacion(cantidadDias);
        return precio*0.8;
    }

}
