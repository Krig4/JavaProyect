package paqueteobjetos;
import java.util.ArrayList;

public class PintarHTML {
public static String crearOpcion(int indice, ArrayList<Entradas> lista_entradas)
	{
	String nombre="plato_"+indice;
	String combo="<select name="+nombre+">";
	for(int i=0; i<lista_entradas.size(); i++)
	{
		Entradas e=lista_entradas.get(i);
		combo+="\n<option value="+e.getId()+">"+e.getTotalEntradas()+"</option>";
	}
	
	combo+="\n</select>";
	return combo;
	}
public static String crearTabla(ArrayList<Reservas> lista_reservas) 
{
	String tabla="<table class='tabla_reservas'><tr><th>CLIENTE</th><th>FECHA</th><th>ENTRADAS</th></tr>";
	for(int i = 0; i<lista_reservas.size(); i++) 
	{
		Reservas c = lista_reservas.get(i);
		tabla += "<tr><td>"+ c.getUsuario() + "</td><td>" + c.getFecha()+"</td><td>"+ c.getEntradas() + "</td></tr>";
	}
	tabla += "</table>";
	return tabla;
}
}