package Metodos;

public class Entrenamiento {
	String ent1;
	String ent2;
	String ent3;
	String ent4;
	String usuario;
	String fecha;

	public Entrenamiento(String ent1, String ent2, String ent3, String ent4, String usuario, String fecha) {
		super();
		this.ent1 = ent1;
		this.ent2 = ent2;
		this.ent3 = ent3;
		this.ent4 = ent4;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public String getEnt1() {
		return ent1;
	}

	public void setEnt1(String ent1) {
		this.ent1 = ent1;
	}

	public String getEnt2() {
		return ent2;
	}

	public void setEnt2(String ent2) {
		this.ent2 = ent2;
	}

	public String getEnt3() {
		return ent3;
	}

	public void setEnt3(String ent3) {
		this.ent3 = ent3;
	}

	public String getEnt4() {
		return ent4;
	}

	public void setEnt4(String ent4) {
		this.ent4 = ent4;
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
