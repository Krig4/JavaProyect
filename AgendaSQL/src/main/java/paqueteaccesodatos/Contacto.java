package paqueteaccesodatos;

public class Contacto {
	String nombre;
	String edad;
    String telefono;
    public Contacto(String nombre, String edad, String telefono) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
}
