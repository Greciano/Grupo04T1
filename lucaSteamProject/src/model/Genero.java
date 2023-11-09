package model;

/**
 * @author Adrian García Carpio
 * 
 *         Esta enumeración representa los géneros de los videojuegos.
 */
public enum Genero {
	Action("Action"), // Género de acción
	Sports("Sports"), // Género de deportes
	Shooter("Shooter"), // Género de disparos
	Role_Playing("Role-Playing"), // Género de rol
	Platform("Platform"), // Género de plataformas
	Misc("Misc"), // Otros géneros
	Racing("Racing"), // Género de carreras
	Fighting("Fighting"), // Género de lucha
	Simulation("Simulation"), // Género de simulación
	Adventure("Adventure"), // Género de aventuras
	Strategy("Strategy"), // Género de estrategia
	Puzzle("Puzzle"); // Género de rompecabezas

	private String valor;

	/**
	 * Constructor de la enumeración Genero.
	 *
	 * @param valor El valor asociado al género.
	 */
	Genero(String valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene el valor asociado al género.
	 *
	 * @return El valor del género.
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Convierte una cadena en un valor de enumeración Genero.
	 *
	 * @param valor La cadena que representa el género.
	 * @return El valor de enumeración Genero correspondiente.
	 * @throws IllegalArgumentException Si la cadena no corresponde a un género
	 *                                  válido.
	 */
	public static Genero fromString(String valor) {
		for (Genero genero : values()) {
			if (genero.valor.equals(valor)) {
				return genero;
			}
		}
		throw new IllegalArgumentException("Género no válido: " + valor);
	}
}
