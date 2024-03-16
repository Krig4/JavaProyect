package paqueteobjetos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	String fecha;
	int numMesa;
	String primero;
	String segundo;
	String postre;
	String obs;
	boolean entregado;
	
	public Pedido(String fecha, int numMesa, String primero, String segundo, String postre, String obs, boolean entregado) {
		this.fecha = fecha;
		this.numMesa = numMesa;
		this.primero = primero;
		this.segundo = segundo;
		this.postre = postre;
		this.obs = obs;
		this.entregado = entregado;
	}
	
	public Pedido() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public String getPrimero() {
		return primero;
	}

	public void setPrimero(String primero) {
		this.primero = primero;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public String getPostre() {
		return postre;
	}

	public void setPostre(String postre) {
		this.postre = postre;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}


}