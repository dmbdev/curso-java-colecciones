package colecciones;

import java.util.HashSet;

public class Estudiante {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private HashSet<Asignatura> asignaturas;
	
	public Estudiante(String dni, String nombre, String apellidos, HashSet<Asignatura> asignaturas) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.asignaturas = asignaturas;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public HashSet<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturasFavoritas(HashSet<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
}