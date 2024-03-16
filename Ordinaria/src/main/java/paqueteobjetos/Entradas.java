package paqueteobjetos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entradas {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 private int totalEntradas;
	 private int MaxEntradas = 4;
	 public Entradas() {}
	public Entradas(int id, int totalEntradas) {
		super();
		this.id = id;
		this.totalEntradas = totalEntradas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalEntradas() {
		return totalEntradas;
	}
	public void setTotalEntradas(int totalEntradas) {
		this.totalEntradas = totalEntradas;
	}
	public int getMaxEntradas() {
		return MaxEntradas;
	}
}
