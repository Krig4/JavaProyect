package paqueteaccesodatos;

import java.util.ArrayList;

public class PintarHTML {
public static String crearTabla(ArrayList<Contacto> lista) 
{
	String tabla="<table class='tabla_contactos'><tr><th>NOMBRE</th><th>EDAD</th><th>TELEFONO</th><th>BORRAR</th></tr>";
	for(int i = 0; i<lista.size(); i++) 
	{
		Contacto c = lista.get(i);
		tabla += "<tr><td>" + c.getNombre()+"</td><td>"+ c.getEdad() + "</td><td>" + c.getTelefono() + "</td><td><a href='Servlet?accion=borrar&telefono="+c.getTelefono()+"'><img src='./imagenes/basura.jpg' width='20px'></td></tr>";
	}
	tabla += "</table>";
	return tabla;
}
}
