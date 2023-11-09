package model;

/**
 * Enumeración que representa diferentes plataformas de videojuegos.
 */
public enum Plataforma {
	PS2("PS2"), X360("X360"), PS3("PS3"), WII("Wii"), DS("DS"), PS("PS"), GBA("GB"), PS4("PS4"), PSP("PSP"), PC("PC"),
	XB("XB"), GC("GC"), _3DS("3DS"), N64("N64"), PSV("PSV"), SAT("SAT"), SNES("SNES"), XOne("XOne"), WiiU("WiiU"),
	GEN("GEN"), DC("DC"), NES("NES"), NG("NG"), WS("WS"), SCD("SCD"), TG16("TG16"), _2600("2600"), _3DO("3DO"),
	GG("GG"), PCFX("PCFX"), GB("GBA"), OTRA("OTRA");

	private String valor;

	/**
	 * Constructor de la plataforma con un valor asociado.
	 *
	 * @param valor El valor de la plataforma.
	 */
	Plataforma(String valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene el valor de la plataforma.
	 *
	 * @return El valor de la plataforma.
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Obtiene la plataforma a partir de su valor.
	 *
	 * @param valor El valor de la plataforma.
	 * @return La plataforma correspondiente.
	 * @throws IllegalArgumentException Si el valor no coincide con ninguna
	 *                                  plataforma.
	 */
	public static Plataforma fromString(String valor) {
		for (Plataforma plataforma : values()) {
			if (plataforma.valor.equals(valor)) {
				return plataforma;
			}
		}
		throw new IllegalArgumentException("Plataforma no válida: " + valor);
	}
}
