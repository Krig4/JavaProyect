package paqueteobjetos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Cocinero {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	String nombre;
	String pass;
	
	public Cocinero(String nombre, String pass) {
		this.nombre = nombre;
		this.pass = pass;
	}
	
	public Cocinero() {
		
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}