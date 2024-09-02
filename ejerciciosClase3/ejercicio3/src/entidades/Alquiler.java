package entidades;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Alquiler {
    private int idAlquiler;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Date fechaAlquilerDesde;
    private Date FechaAlquilerHasta;
    private double MontoAPagar;

    public Alquiler(int idAlquiler, Cliente cliente, Vehiculo vehiculo, Date fechaAlquilerDesde, Date fechaAlquilerHasta, double montoAPagar) {
        this.idAlquiler = idAlquiler;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaAlquilerDesde = fechaAlquilerDesde;
        this.FechaAlquilerHasta = fechaAlquilerHasta;
        this.MontoAPagar = montoAPagar;
    }

    public double calcularAlquiler(Date fechaAlquilerDesde, Date fechaAlquilerHasta, double precio){
        long calcularFecha = fechaAlquilerHasta.getTime() - fechaAlquilerDesde.getTime();
        long horas = TimeUnit.MILLISECONDS.toHours(calcularFecha);
        System.out.println(horas);
        return horas * precio;
    }

}
