import controlador.Controlador;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.registrarCliente(41798869,"Lucas Garcia");
        controlador.registrarCliente(41798869,"Lucas Garcia");
        controlador.registrarCliente(41798868,"Juani Garcia");
        controlador.registrarHabitacionSimple(1);
        controlador.registrarHabitacionDoble(1);
        controlador.registrarHabitacionMatrimonial(1);
        controlador.registrarHabitacionSimple(1);
        controlador.registrarHabitacionSimple(2);
        controlador.registrarHabitacionDoble(2);
        controlador.registrarHabitacionMatrimonial(2);
        controlador.registrarReserva(41798869,1,1,new Date(2024,7,14),new Date(2024,7,16));
    }
}