package ficheros.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ficheros.Alumno;

public class Servicios {
	
	public List<Alumno> leerFicheroAlumnos(String fichero) {
		List<Alumno> alumnos = new ArrayList<>();
		File archivo = new File(fichero);
		
		try(BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				String[] atributos = linea.split("\\|");
				String[] asignaturas = atributos[atributos.length - 1].split(";");
				alumnos.add(new Alumno(atributos[2], atributos[0], atributos[1], asignaturas));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return alumnos;
	}
	
	public Map<String, List<Alumno>> leerFicheroAlumnosColegio(String fichero) {
		Map<String, List<Alumno>> colegios = new HashMap<>();
		File archivo = new File(fichero);
		
		try(BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				String[] atributos = linea.split("\\|");
				String colegio = atributos[0];
				String[] asignaturas = atributos[atributos.length - 1].split(";");
				Alumno alumno = new Alumno(atributos[3], atributos[1], atributos[2], asignaturas);
				//Add alumnos a la lista con la clave del colegio
				colegios.computeIfAbsent(colegio, k -> new ArrayList<>()).add(alumno);
				//colegios.put(atributos[0], new Alumno(atributos[3], atributos[1], atributos[2], asignaturas));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return colegios;
	}
	
	public String colegioConMasAlumnos(Map<String, List<Alumno>> colegios) {
		int contadorAlumnos = 0;
		String colegioGanador = "";
		for (String colegio : colegios.keySet()) {
			if(colegios.get(colegio).size() > contadorAlumnos) {
				contadorAlumnos = colegios.get(colegio).size();
				colegioGanador = colegio;
			}
		}
		
		return colegioGanador;
	}

}
