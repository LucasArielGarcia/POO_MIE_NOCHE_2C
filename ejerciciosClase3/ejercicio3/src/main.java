import controlador.Controlador;
import entidades.TipoVehiculo;

import java.util.Date;

public class main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.registrarCliente(41798869,"Lucas","segurola 329");
        controlador.registrarCliente(41798868,"Juan","aaaa 2");
        controlador.registrarCliente(41798862,"Marcos","vvv 1");

        controlador.registrarVehiculo(TipoVehiculo.AUTO,3);
        controlador.registrarVehiculo(TipoVehiculo.MOTO,2);
        controlador.registrarVehiculo(TipoVehiculo.BICICLETA,1);

        controlador.vehiculosOcupados();

        controlador.registrarAlquiler(41798869,"AUT1",new Date(2024,7,14),new Date(2024,7,16));

    }
}