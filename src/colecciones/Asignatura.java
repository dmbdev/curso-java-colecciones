package colecciones;

public class Asignatura {
	
	private int nota;
	private String nombre;
	
	public Asignatura(int nota, String nombre) {
		this.nota = nota;
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
