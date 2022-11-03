package mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Colegio {
	
	private String nombre;
	private String direccion;
	
	public Colegio(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public static void main(String[] args) {
		
		Map<Colegio, List<Alumno>> colegios = creaColegios();
		mostrarInformacion(colegios);
		buscarPorDNI(colegios, "12365478C");
		
	}

	private static void buscarPorDNI(Map<Colegio, List<Alumno>> colegios, String dni) {
		Set<Entry<Colegio, List<Alumno>>> entrySet = colegios.entrySet();
		for (Entry<Colegio, List<Alumno>> entry : entrySet) {
			for (Alumno alumno : entry.getValue()) {
				if(alumno.getDni().contentEquals(dni)) {
					System.out.println("El alumno esta en el colegio " + entry.getKey().getNombre());
				}
			}
		}
	}

	private static void mostrarInformacion(Map<Colegio, List<Alumno>> colegios) {
		Set<Entry<Colegio, List<Alumno>>> entrySet = colegios.entrySet();
		for (Entry<Colegio, List<Alumno>> entry : entrySet) {
			System.out.println("Nombre -> " + entry.getKey().getNombre());
			System.out.println("Direccion -> " + entry.getKey().getDireccion());
			for (Alumno alumno : entry.getValue()) {
				System.out.println("\t" + alumno.getNombre() + " " + alumno.getApellidos());
			}
		}
		
	}

	private static Map<Colegio, List<Alumno>> creaColegios() {
		Map<Colegio, List<Alumno>> colegios = new HashMap<>();
		colegios.put(
				new Colegio("Colegio 1", "Calle1 N32"),
				new ArrayList<Alumno>() {{
					add(new Alumno("12365478Q", "Pedro", "Martinez"));
					add(new Alumno("12365478V", "Eva", "Lopez"));
					add(new Alumno("12365478K", "Alejandro", "Gonzalez"));
				}}
				);
		
		colegios.put(
				new Colegio("Colegio 2", "Calle2 N45"),
				new ArrayList<Alumno>() {{
					add(new Alumno("12365478H", "Maria", "Perez"));
					add(new Alumno("12365478C", "Fernando", "Martin"));
					add(new Alumno("12365478S", "Laura", "Alvarez"));
				}}
				);
		
		return colegios;
	}

}
