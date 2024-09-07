package entidades;

public class Vehiculo {
    private String IdVehiculo;
    private boolean disponibilidad;
    private TipoVehiculo tipoVehiculo;
    private double precio;

    public Vehiculo(String idVehiculo, boolean disponibilidad, TipoVehiculo tipoVehiculo, double precio) {
        IdVehiculo = idVehiculo;
        this.disponibilidad = disponibilidad;
        this.tipoVehiculo = tipoVehiculo;
        this.precio = precio;
    }

    public boolean vehiculoEstaOcupado(){
        return !this.disponibilidad;
    }
    public void marcarVehiculoOcupado(){
        this.disponibilidad = false;
    }
    public void marcarVehiculoDisponible(){
        this.disponibilidad = true;
    }

    public boolean sosVehiculo(String id){
        return this.IdVehiculo.equals(id);
    }
    public String getIdVehiculo() {
        return IdVehiculo;
    }
    public double getPrecio() {
        return precio;
    }
}
