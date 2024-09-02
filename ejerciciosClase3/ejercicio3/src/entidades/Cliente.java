package entidades;

public class Cliente extends Persona{
    private int idCliente;

    public Cliente(int idCliente,String nombre, int dni, String direccion) {
        super(dni,nombre,direccion);
        this.idCliente = idCliente;
    }

    public boolean sosCliente(int dniCliente){
        return super.sosPersona(dniCliente);
    }


}
