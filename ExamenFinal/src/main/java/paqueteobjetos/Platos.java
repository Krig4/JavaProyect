package paqueteobjetos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_platos")

public class Platos {
	private String tipo;
	private String nombre;
	private String precio;
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	public Platos(String tipo, String nombre, String precio, int id) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
	}
	public Platos() {
		super();
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
