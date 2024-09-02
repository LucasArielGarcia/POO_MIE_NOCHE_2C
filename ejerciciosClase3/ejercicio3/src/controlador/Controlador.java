package controlador;

import entidades.Alquiler;
import entidades.Cliente;
import entidades.TipoVehiculo;
import entidades.Vehiculo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controlador {
    private List<Alquiler> alquileres = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();


    public void vehiculosOcupados(){
        for (Vehiculo listaVehiculos:vehiculos){
            if (listaVehiculos.vehiculoEstaOcupado()){
                System.out.println("Id del vehiculo: "+listaVehiculos.getIdVehiculo() + "Estado del vehiculo: Ocupado");
            }
        }
    }

    public void registrarCliente(int dni,String nombre, String direccion){
        Cliente nuevoCliente;
        int idCliente;
        if (clientes.isEmpty())
            idCliente = 1;
        else
            idCliente = clientes.size()+1;
        nuevoCliente = new Cliente(idCliente,nombre,dni,direccion);
        clientes.add(nuevoCliente);
    }

    public void registrarVehiculo(TipoVehiculo tipoVehiculo,double precio ){
        Vehiculo nuevoVehiculo;
        String idVehiculo = "";
        switch (tipoVehiculo){
            case AUTO -> idVehiculo = "AUT";
            case MOTO -> idVehiculo = "MOT";
            case BICICLETA -> idVehiculo = "BIC";
        }
        if (vehiculos.isEmpty())
            idVehiculo = idVehiculo + "1";
        else
            idVehiculo = idVehiculo + Integer.toString(vehiculos.size()+1);
        nuevoVehiculo = new Vehiculo(idVehiculo,false,tipoVehiculo,precio);
        vehiculos.add(nuevoVehiculo);
    }

    public void registrarAlquiler(Cliente cliente, String idVehiculo, Date fechaDesde, Date fechaHasta){
        Vehiculo vehiculoAlquilar = null;

        for (Vehiculo listaVehiculos : vehiculos) {
            if (listaVehiculos.sosVehiculo(idVehiculo))
                    vehiculoAlquilar = listaVehiculos;
        }
        if (vehiculoAlquilar == null){
            System.out.println("El vehiculo no existe");
            return;
        }





    }

    
}
