package paqueteobjetos;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabla_pedidos")
public class Pedidos {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String mesa;
		private String primero;
		private String segundo;
		private String postre;
		private String observacion;
		private LocalDateTime date;
		private int isComplete;
		private LocalDateTime complete;
		public Pedidos() {}
		public Pedidos(int id, String mesa, String primero, String segundo, String postre, String observacion) {
			super();
			this.id = id;
			this.mesa = mesa;
			this.primero = primero;
			this.segundo = segundo;
			this.postre = postre;
			this.observacion = observacion;
			this.date = LocalDateTime.now();
			this.isComplete = 0;
			this.complete = null;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMesa() {
			return mesa;
		}
		public void setMesa(String mesa) {
			this.mesa = mesa;
		}
		public String getObs() {
			return observacion;
		}
		public void setObs(String obs) {
			this.observacion = obs;
		}
		public LocalDateTime getDate() {
			return date;
		}
		public void setDate(LocalDateTime date) {
			this.date = date;
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
		public void setComplete(LocalDateTime complete) {
			this.complete = complete;
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
}
