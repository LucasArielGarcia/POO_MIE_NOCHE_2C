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

    public Alquiler(int idAlquiler, Cliente cliente, Vehiculo vehiculo, Date fechaAlquilerDesde, Date fechaAlquilerHasta) {
        this.idAlquiler = idAlquiler;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaAlquilerDesde = fechaAlquilerDesde;
        this.FechaAlquilerHasta = fechaAlquilerHasta;
        this.MontoAPagar = calcularAlquiler(fechaAlquilerDesde,fechaAlquilerHasta,vehiculo.getPrecio());
    }

    public double calcularAlquiler(Date fechaAlquilerDesde, Date fechaAlquilerHasta, double precio){
        long calcularFecha = fechaAlquilerHasta.getTime() - fechaAlquilerDesde.getTime();
        long horas = TimeUnit.MILLISECONDS.toHours(calcularFecha);
        System.out.println(horas + " || " + horas * precio);
        return horas * precio;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }
}
