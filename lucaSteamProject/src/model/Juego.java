package model;

public class Juego {

	private String nombre;
	private int fecha;
	private String editor;
	private Plataforma plataforma;
	private Genero genero;
	
	
	public Juego() {
		super();
	}


	public Juego(String nombre, int fecha, String editor, Plataforma plataforma, Genero genero) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.editor = editor;
		this.plataforma = plataforma;
		this.genero = genero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getFecha() {
		return fecha;
	}


	public void setFecha(int fecha) {
		this.fecha = fecha;
	}


	public String getEditor() {
		return editor;
	}


	public void setEditor(String editor) {
		this.editor = editor;
	}


	public Plataforma getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", fecha=" + fecha + ", editor=" + editor + ", plataforma=" + plataforma
				+ ", genero=" + genero + "]";
	}
	
	
}
