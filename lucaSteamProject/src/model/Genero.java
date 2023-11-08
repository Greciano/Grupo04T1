package model;

public enum Genero {
	Action("Action"), Sports("Sports"), Shooter("Shooter"), Role_Playing("Role-Playing"), Platform("Platform"),
	Misc("Misc"), Racing("Racing"), Fighting("Fighting"), Simulation("Simulation"), Adventure("Adventure"),
	Strategy("Strategy"), Puzzle("Puzzle");

	private String valor;

	Genero(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static Genero fromString(String valor) {
		for (Genero genero : values()) {
			if (genero.valor.equals(valor)) {
				return genero;
			}
		}
		throw new IllegalArgumentException("Género no válido: " + valor);
	}
}
