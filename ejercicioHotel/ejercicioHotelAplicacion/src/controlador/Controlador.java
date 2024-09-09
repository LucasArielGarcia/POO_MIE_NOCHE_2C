package controlador;

import entidades.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controlador {
    List<Habitacion> listHabitaciones = new ArrayList<>();
    List<Reserva> listReservas = new ArrayList<>();
    List<Cliente> listCliente = new ArrayList<>();

    public void registrarCliente(int dni, String nombre){
        Cliente clienteNuevo;
        if (listCliente.isEmpty()){
            clienteNuevo = new Cliente(dni,nombre);
        }
        else {
            for (Cliente cliente : listCliente){
                if (cliente.sosCliente(dni)){
                    System.out.println("El cliente ya existe y es: ");
                    cliente.mostrarCliente();
                    return;
                }
            }
            clienteNuevo = new Cliente(dni,nombre);
        }
        listCliente.add(clienteNuevo);
        clienteNuevo.mostrarCliente();
    }

    public void registrarHabitacionSimple(int pisoHabitacion){
        habitacionSimple habitacionNueva = new habitacionSimple(pisoHabitacion);
        listHabitaciones.add(habitacionNueva);
    }
    public void registrarHabitacionDoble(int pisoHabitacion){
        HabitacionDoble habitacionNueva = new HabitacionDoble(pisoHabitacion);
        listHabitaciones.add(habitacionNueva);
    }
    public void registrarHabitacionMatrimonial(int pisoHabitacion){
        HabitacionMatrimonial habitacionNueva = new HabitacionMatrimonial(pisoHabitacion);
        listHabitaciones.add(habitacionNueva);
    }


    public void registrarReserva(int dni,int piso, int numeroHabitacion,Date fechaComienzo, Date fechaHasta) {
        Cliente clienteReserva = null;
        Habitacion habitacionReserva = null;
        Reserva nuevaReserva = null;
        for (Cliente cliente : listCliente) {
            if (cliente.sosCliente(dni))
                clienteReserva = cliente;

        }
        if (clienteReserva == null) {
            System.out.println("No existe cliente");
            return;
        }
        for (Habitacion habitacion: listHabitaciones){
            if (habitacion.sosHabitacion(piso,numeroHabitacion))
                habitacionReserva = habitacion;
        }
        if (habitacionReserva == null){
            System.out.println("No existe la habitacion");
            return;
        }
        int cantidadDias = (int) TimeUnit.MILLISECONDS.toDays(fechaHasta.getTime() - fechaComienzo.getTime());
        nuevaReserva = new Reserva(clienteReserva,habitacionReserva,fechaComienzo,fechaHasta, habitacionReserva.calcularReservaHabitacion(cantidadDias),cantidadDias);
        listReservas.add(nuevaReserva);

    }
    public void abonarsenaReserva(double abono, int idReserva){
        Reserva reservaAbonarSena = null;
        for (Reserva reserva: listReservas){
            if (reserva.sosReserva(idReserva))
                reservaAbonarSena = reserva;

        }
        if (reservaAbonarSena == null)
            System.out.println("No existe reserva");
        reservaAbonarSena.abonarSena(abono);


    }



    void habitacionesDisponibles(Date fechaDesde, Date fechaHasta){

    }



}
