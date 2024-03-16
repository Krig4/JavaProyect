package paqueteobjetos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Plato {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	String nombre;
	int precio;
	String tipo;
	
	public Plato(String nombre, int precio, String tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Plato() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}