package entidades;

public class Persona {
    private int dni;
    private String nombre;
    private String domicilio;

    public Persona(int dni, String nombre, String domicilio) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public boolean sosPersona(int dniPersona){
        return this.dni == dniPersona;
    }
}
