package controlador;

import entidades.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SistemaHotel {
    List<Habitacion> listHabitaciones = new ArrayList<>();
    List<Reserva> listReservas = new ArrayList<>();
    List<Cliente> listCliente = new ArrayList<>();

    public void registrarCliente(int dni, String nombre){
        Cliente clienteNuevo;
        if (listCliente.isEmpty()){
            clienteNuevo = new Cliente(dni,nombre);
        }
        else {
            Cliente clienteViejo = buscarCliente(dni);
            if (clienteViejo != null){
                System.out.println("Existe el cliente");
                return;
            }
            clienteNuevo = new Cliente(dni,nombre);
        }
        listCliente.add(clienteNuevo);
        clienteNuevo.mostrarCliente();
    }

    public void registrarHabitacionSimple(int pisoHabitacion){
        HabitacionSimple habitacionNueva = new HabitacionSimple(pisoHabitacion);
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
        Cliente clienteReserva = buscarCliente(dni);
        Habitacion habitacionReserva = buscarHabitacion(piso,numeroHabitacion);
        Reserva nuevaReserva = null;
        if (clienteReserva == null) {
            System.out.println("No existe cliente");
            return;
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
        Reserva reservaAbonarSena = buscarReserva(idReserva);
        if (reservaAbonarSena == null)
            System.out.println("No existe reserva");
        reservaAbonarSena.abonarSena(abono);
    }



    void habitacionesDisponibles(Date fechaDesde, Date fechaHasta){

    }

    private Cliente buscarCliente(int dni){
        Cliente clienteBuscar = null;
        for (Cliente cliente : listCliente) {
            if (cliente.sosCliente(dni))
                clienteBuscar = cliente;
        }
        return clienteBuscar;
    }
    private Reserva buscarReserva(int idReserva){
        Reserva reservaBuscada = null;
        for (Reserva reserva: listReservas){
            if (reserva.sosReserva(idReserva))
                reservaBuscada = reserva;
        }
        return reservaBuscada;
    }
    private Habitacion buscarHabitacion(int piso, int nroHabitacion){
        Habitacion habitacionBuscada = null;
        for (Habitacion habitacion:listHabitaciones){
            if (habitacion.sosHabitacion(piso,nroHabitacion))
                habitacionBuscada = habitacion;
        }
        return habitacionBuscada;
    }

}
