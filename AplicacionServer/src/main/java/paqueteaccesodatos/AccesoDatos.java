package paqueteaccesodatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.catalina.LifecycleState;

public class AccesoDatos {
	
	static String route = "C:\\Users\\madrid\\eclipse-workspace\\AplicacionServer\\datos.csv";
	
	public static String insertarContacto(Contacto c) 
	{	
		try {
			FileWriter fw = new FileWriter(route, true);
	        fw.write(c.getNombre() + "," + c.getEdad() + "," + c.getTelefono() + "\n");			
	        fw.close();
		} catch(IOException e) {
			System.out.println("La ruta no existe");
		}
		return "OK";
	}
	public static ArrayList<Contacto> recuperarContactos(){
		ArrayList<Contacto> lista = null;
		try {
			lista = new ArrayList<Contacto>();
			FileReader fr=new FileReader(route);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null) {
				String[] datos = linea.split(",");
				String nombre = datos[0];
				String edad = datos[1];
				String telefono = datos[2];
				Contacto c = new Contacto(nombre, edad, telefono);
				lista.add(c);
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public static ArrayList<Contacto> buscarContactos(String nombre, String route) {
        ArrayList<Contacto> lista = new ArrayList<>();
        try {
            FileReader fr = new FileReader(route);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 3 && datos[0].equalsIgnoreCase(nombre)) {
                    String nombreContacto = datos[0];
                    String edad = datos[1];
                    String telefono = datos[2];
                    Contacto contacto = new Contacto(nombreContacto, edad, telefono);
                    lista.add(contacto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

	public static ArrayList<Contacto> Borrar(String tlf) {
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		lista = recuperarContactos();
		try {
			FileWriter fw = new FileWriter(route, false);
			fw.write("");
			fw.close();
			fw = new FileWriter(route,true);
			for (int i = 0; i< lista.size(); i++) {
				if(!lista.get(i).getTelefono().equals(tlf)) {
					Contacto c = new Contacto(lista.get(i).getNombre(),lista.get(i).getEdad(),lista.get(i).getTelefono());
					insertarContacto(c);
				}
			}
			fw.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
	}
}

