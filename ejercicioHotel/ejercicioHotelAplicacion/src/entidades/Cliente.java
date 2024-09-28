package entidades;

public class Cliente {
    private static int contadorId = 0;
    private int idCliente;
    private int dni;
    private String nombre;
    private int cantidadReservas;
    private TipoCliente tipoCliente;
    public Cliente(int dni, String nombre) {
        this.idCliente = ++contadorId;
        this.dni = dni;
        this.nombre = nombre;
    }
    public boolean sosCliente(int dni){
        return this.dni == dni;
    }

    public void mostrarCliente(){
        System.out.println("Id cliente: "+this.idCliente+" Dni cliente: "+this.dni + " Nombre: "+this.nombre);
    }
}
