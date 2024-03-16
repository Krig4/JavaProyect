package paqueteobjetos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String usuario;
	private String password;
	private String rol;
	private int entradas;
	public Usuario() {}
	public Usuario(int id, String usuario, String password, String rol, int entradas) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.entradas = entradas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getEntradas() {
		return entradas;
	}
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
}
