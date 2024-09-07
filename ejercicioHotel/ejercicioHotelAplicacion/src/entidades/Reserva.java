package entidades;

import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaComienzo ;
    private Date fechaHasta ;
    private int cantidadDias;
    private double importeSena;
    private double imprteTotal;

    public Reserva(Cliente cliente, Habitacion habitacion, Date fechaComienzo, Date fechaHasta, double importeSena) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaComienzo = fechaComienzo;
        this.fechaHasta = fechaHasta;
        this.importeSena = importeSena;
    }
}
