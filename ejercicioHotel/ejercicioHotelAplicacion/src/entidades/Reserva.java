package entidades;

import java.util.Date;

public class Reserva {
    private static int contadorId = 0;
    private int idReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaComienzo ;
    private Date fechaHasta ;
    private int cantidadDias;
    private double importeSena;
    private double imprteTotal;
    private double importesAbonados;
    private EstadoReserva estadoReserva;

    public Reserva(Cliente cliente, Habitacion habitacion, Date fechaComienzo, Date fechaHasta, double importeSena,int cantidadDias) {
        this.idReserva = ++contadorId;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaComienzo = fechaComienzo;
        this.fechaHasta = fechaHasta;
        this.importeSena = importeSena;
        this.imprteTotal = habitacion.calcularprecioHabitacion(cantidadDias);
        this.cantidadDias = cantidadDias;
        this.importesAbonados = 0;
        this.estadoReserva = EstadoReserva.ESPERA;

        System.out.println("Su reserva fue creada satisfactoriamente, el id es : "+ this.idReserva);
    }

    public boolean sosReserva(int id){
        return this.idReserva == id;
    }
    public void abonarSena(double abono){
        if (abono == importeSena) {
            this.importesAbonados = abono;
            this.estadoReserva = EstadoReserva.SEÑADA;
            System.out.println("Su reserva fue señada satisfactoriamente");
        }
        else {
            System.out.println("Lo abonado no llega la seña, la seña es de: "+this.importeSena);
        }
    }


}
