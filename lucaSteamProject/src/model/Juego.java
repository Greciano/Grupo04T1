package model;

/**
 * Representa un videojuego con sus atributos principales.
 */
public class Juego {
	private String nombre; // Nombre del juego
	private int fecha; // Año de lanzamiento del juego
	private String editor; // Nombre del editor del juego
	private Plataforma plataforma; // Plataforma en la que se juega
	private Genero genero; // Género al que pertenece el juego

	/**
	 * Constructor vacío para un juego.
	 */
	public Juego() {
		super();
	}

	/**
	 * Constructor para un juego con atributos iniciales.
	 *
	 * @param nombre     El nombre del juego.
	 * @param fecha      El año de lanzamiento del juego.
	 * @param editor     El nombre del editor del juego.
	 * @param plataforma La plataforma en la que se juega.
	 * @param genero     El género al que pertenece el juego.
	 */
	public Juego(String nombre, int fecha, String editor, Plataforma plataforma, Genero genero) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.editor = editor;
		this.plataforma = plataforma;
		this.genero = genero;
	}

	/**
	 * Obtiene el nombre del juego.
	 *
	 * @return El nombre del juego.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del juego.
	 *
	 * @param nombre El nombre del juego.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el año de lanzamiento del juego.
	 *
	 * @return El año de lanzamiento del juego.
	 */
	public int getFecha() {
		return fecha;
	}

	/**
	 * Establece el año de lanzamiento del juego.
	 *
	 * @param fecha El año de lanzamiento del juego.
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el nombre del editor del juego.
	 *
	 * @return El nombre del editor del juego.
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * Establece el nombre del editor del juego.
	 *
	 * @param editor El nombre del editor del juego.
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * Obtiene la plataforma en la que se juega el juego.
	 *
	 * @return La plataforma en la que se juega el juego.
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * Establece la plataforma en la que se juega el juego.
	 *
	 * @param plataforma La plataforma en la que se juega el juego.
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Obtiene el género al que pertenece el juego.
	 *
	 * @return El género al que pertenece el juego.
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Establece el género al que pertenece el juego.
	 *
	 * @param genero El género al que pertenece el juego.
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Devuelve una representación en forma de cadena de un juego.
	 *
	 * @return Una cadena que representa un juego con sus atributos.
	 */
	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", fecha=" + fecha + ", editor=" + editor + ", plataforma=" + plataforma
				+ ", genero=" + genero + "]";
	}
}
