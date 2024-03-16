package object;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String primero;
	private String segundo;
	private String postre;
	private int mesa;
	private String obs;
	private LocalDateTime date;
	private int isComplete;
	private LocalDateTime complete;
	
	public Pedido() {}
	public Pedido(String primero, String segundo, String postre, int mesa, String obs)
	{
		this.primero = primero;
		this.segundo = segundo;
		this.postre = postre;
		this.mesa = mesa;
		this.obs = obs;
		this.date = LocalDateTime.now();
		this.isComplete = 0;
		this.complete = null;
	}
	
	public int getId() {
		return id;
	}
	public String getPrimero() {
		return primero;
	}
	public String getSegundo() {
		return segundo;
	}
	public String getPostre() {
		return postre;
	}
	public int getMesa() {
		return mesa;
	}
	public String getObs() {
		return obs;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public int getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}
	public LocalDateTime getComplete() {
		return complete;
	}
}

