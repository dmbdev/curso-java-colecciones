package ficheros;

import ficheros.servicios.Servicios;

public class Main {

	public static void main(String[] args) {
		
		String nombreFicheroAlumnos = "./recursos/alumnos.txt";
		String nombreFicheroAlumnosColegio = "./recursos/alumnos-colegio.txt";
		Servicios servicios = new Servicios();
		
//		List<Alumno> alumnos = servicios.leerFicheroAlumnos(nombreFicheroAlumnos);
//		Map<String, List<Alumno>> colegios = servicios.leerFicheroAlumnosColegio(nombreFicheroAlumnosColegio);
		
		System.out.println("El numero de alumnos es de -> " + servicios.leerFicheroAlumnos(nombreFicheroAlumnos).size());
		System.out.println("El colegio con mas alumnos es -> " + servicios.colegioConMasAlumnos(servicios.leerFicheroAlumnosColegio(nombreFicheroAlumnosColegio)));
		
	}

}
