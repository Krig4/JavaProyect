package paqueteobjetos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_reservas")

public class Reservas {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 private String usuario;
	 private String fecha;
	 private String entradas;
	 public Reservas() {}
	public Reservas(int id, String usuario, String fecha, String entradas) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.entradas = entradas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEntradas() {
		return entradas;
	}
	public void setEntradas(String entradas) {
		this.entradas = entradas;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	 	 
}
