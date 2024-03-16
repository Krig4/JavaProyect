package paqueteobjetos;
import java.util.ArrayList;

public class PintarHTML {
public static String crearOpcion(int indice, ArrayList<Platos> lista_platos)
	{
	String nombre="plato_"+indice;
	String combo="<select name="+nombre+">";
	for(int i=0; i<lista_platos.size(); i++)
	{
		Platos e=lista_platos.get(i);
		combo+="\n<option value="+e.getId()+">"+e.getNombre()+e.getPrecio()+"</option>";
	}
	
	combo+="\n</select>";
	return combo;
	}
public static String crearTabla(ArrayList<Platos> lista_platos) 
{
	String tabla="<table class='tabla_platos'><tr><th>TIPO</th><th>NOMBRE</th><th>PRECIO</th><th>BORRAR</th></tr>";
	for(int i = 0; i<lista_platos.size(); i++) 
	{
		Platos c = lista_platos.get(i);
		tabla += "<tr><td>"+ c.getId() + "</td><td>" + c.getTipo()+"</td><td>"+ c.getNombre() + "</td><td>" + c.getPrecio() + "</td><td><a href='Servlet?accion=borrar&idPlato="+c.getId()+"'><img src='./imagenes/basura.jpg' width='20px'></td></tr>";
	}
	tabla += "</table>";
	return tabla;
}
}