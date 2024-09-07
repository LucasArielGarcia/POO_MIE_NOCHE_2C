package controlador;

import entidades.Alquiler;
import entidades.Cliente;
import entidades.TipoVehiculo;
import entidades.Vehiculo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controlador {
    private List<Alquiler> listaAlquileres = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Vehiculo> listaVvehiculos = new ArrayList<>();


    public void vehiculosOcupados(){
        for (Vehiculo vehiculo: listaVvehiculos){
            if (vehiculo.vehiculoEstaOcupado()){
                System.out.println("Id del vehiculo: "+vehiculo.getIdVehiculo() + "Estado del vehiculo: Ocupado");
            }
        }
    }

    public void registrarCliente(int dni,String nombre, String direccion){
        Cliente nuevoCliente;
        int idCliente;
        if (listaClientes.isEmpty())
            idCliente = 1;
        else
            idCliente = listaClientes.size()+1;
        nuevoCliente = new Cliente(idCliente,nombre,dni,direccion);
        listaClientes.add(nuevoCliente);
    }

    public void registrarVehiculo(TipoVehiculo tipoVehiculo,double precio ){
        Vehiculo nuevoVehiculo;
        String idVehiculo = "";
        switch (tipoVehiculo){
            case AUTO -> idVehiculo = "AUT";
            case MOTO -> idVehiculo = "MOT";
            case BICICLETA -> idVehiculo = "BIC";
        }
        if (listaVvehiculos.isEmpty())
            idVehiculo = idVehiculo + "1";
        else
            idVehiculo = idVehiculo + Integer.toString(listaVvehiculos.size()+1);
        nuevoVehiculo = new Vehiculo(idVehiculo,true,tipoVehiculo,precio);
        listaVvehiculos.add(nuevoVehiculo);
        System.out.println("Se registro el vehiculo con el id: "+ nuevoVehiculo.getIdVehiculo());
    }

    public void registrarAlquiler(int dniCliente, String idVehiculo, Date fechaDesde, Date fechaHasta){
        Vehiculo vehiculoAlquilar = null;
        Cliente clienteAlquilar = null;
        Alquiler nuevoAlquiler;
        int idAlquiler;

        for (Vehiculo vehiculo : listaVvehiculos) {
            if (vehiculo.sosVehiculo(idVehiculo))
                    vehiculoAlquilar = vehiculo;
        }
        if (vehiculoAlquilar == null){
            System.out.println("El vehiculo no existe, registre el vehiculo");
            return;
        }
        for(Cliente cliente : listaClientes){
            if (cliente.sosCliente(dniCliente)){
                clienteAlquilar = cliente;
            }
        }
        if (clienteAlquilar == null){
            System.out.println("El cliente no existe, registre el cliente primero");
            return;
        }
        if (listaAlquileres.isEmpty())
            idAlquiler = 1;
        else
            idAlquiler = listaAlquileres.size()+1;
        nuevoAlquiler = new Alquiler(idAlquiler,clienteAlquilar,vehiculoAlquilar,fechaDesde,fechaHasta);
        listaAlquileres.add(nuevoAlquiler);
        System.out.println("Se registro el alquiler con el id: " + nuevoAlquiler.getIdAlquiler());
    }

    
}
