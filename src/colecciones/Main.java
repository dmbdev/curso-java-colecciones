package colecciones;

import java.util.HashSet;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		
		HashSet<Estudiante> estudiantes = new HashSet<Estudiante>();
		crearEstudiantes(estudiantes);
		//mostrarInformacion(estudiantes);
		//soloMatematicas(estudiantes);
		//mostrarAprobados(estudiantes);
		//eliminarEstudiante(estudiantes);
		mostrarInformacion(eliminarEstudiante(estudiantes));
		
	}

	private static HashSet<Estudiante> eliminarEstudiante(HashSet<Estudiante> estudiantes) {
		Iterator iterator = estudiantes.iterator();
		while(iterator.hasNext()) {
			Estudiante estudiante = (Estudiante) iterator.next();
			Iterator asignaturas = estudiante.getAsignaturas().iterator();
			while(asignaturas.hasNext()) {
				Asignatura asignatura = (Asignatura) asignaturas.next();
				if(asignatura.getNombre().contentEquals("Lengua") && asignatura.getNota() < 5) {
					iterator.remove();
				}
			}
		}
		
		return estudiantes;
	}

	private static void mostrarAprobados(HashSet<Estudiante> estudiantes) {
		for (Estudiante estudiante : estudiantes) {
			int nota = 0;
			for (Asignatura asignatura : estudiante.getAsignaturas()) {
				nota += asignatura.getNota();
			}
			if((nota / estudiante.getAsignaturas().size()) >= 5) {
				System.out.println(estudiante.getNombre() + " " + estudiante.getApellidos());
			}
		}
	}

	private static void soloMatematicas(HashSet<Estudiante> estudiantes) {
		for (Estudiante estudiante : estudiantes) {
			for (Asignatura asignatura : estudiante.getAsignaturas()) {
				if(asignatura.getNombre().contentEquals("Matematicas")) {
					System.out.println(estudiante.getNombre() + " " + estudiante.getApellidos());
				}
			}
		}
	}

	private static void mostrarInformacion(HashSet<Estudiante> estudiantes) {
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante.getNombre() + " " + estudiante.getApellidos());
			for (Asignatura asignatura : estudiante.getAsignaturas()) {
				System.out.println("\t" + asignatura.getNombre() + " - " + asignatura.getNota());
			}
		}
	}

	public static void crearEstudiantes(HashSet<Estudiante> estudiantes) {
		estudiantes.add(new Estudiante("12345678Q", "Pedro", "Martinez", new HashSet<Asignatura>() {{
			add(new Asignatura(7, "Lengua"));
			add(new Asignatura(4, "Matematicas"));
			add(new Asignatura(6, "Biologia"));
		}}));
		
		estudiantes.add(new Estudiante("12345678T", "Laura", "Perez", new HashSet<Asignatura>() {{
			add(new Asignatura(5, "Fisica"));
			add(new Asignatura(3, "Matematicas"));
			add(new Asignatura(6, "Historia"));
		}}));
		
		estudiantes.add(new Estudiante("12345678V", "Maria", "Lopez", new HashSet<Asignatura>() {{
			add(new Asignatura(9, "Lengua"));
			add(new Asignatura(7, "Filosofia"));
			add(new Asignatura(8, "Matematicas"));
		}}));
		
		estudiantes.add(new Estudiante("12345678Q", "Alejandro", "Gonzalez", new HashSet<Asignatura>() {{
			add(new Asignatura(3, "Lengua"));
			add(new Asignatura(4, "Historia"));
			add(new Asignatura(3, "Biologia"));
		}}));
		
		estudiantes.add(new Estudiante("12345678Q", "Valeria", "Martin", new HashSet<Asignatura>() {{
			add(new Asignatura(5, "Lengua"));
			add(new Asignatura(8, "Matematicas"));
			add(new Asignatura(6, "Historia"));
		}}));
	}

}
