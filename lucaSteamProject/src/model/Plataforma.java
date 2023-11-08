package model;

public enum Plataforma {
	PS2("PS2"), X360("X360"), PS3("PS3"), WII("Wii"), DS("DS"), PS("PS"), GBA("GB"), PS4("PS4"), PSP("PSP"), PC("PC"),
	XB("XB"), GC("GC"), _3DS("3DS"), N64("N64"), PSV("PSV"), SAT("SAT"), SNES("SNES"), XOne("XOne"), WiiU("WiiU"),
	GEN("GEN"), DC("DC"), NES("NES"), NG("NG"), WS("WS"), SCD("SCD"), TG16("TG16"), _2600("2600"), _3DO("3DO"),
	GG("GG"), PCFX("PCFX"), GB("GBA") , OTRA("OTRA");

	private String valor;

	Plataforma(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static Plataforma fromString(String valor) {
		for (Plataforma plataforma : values()) {
			if (plataforma.valor.equals(valor)) {
				return plataforma;
			}
		}
		throw new IllegalArgumentException("Plataforma no válida: " + valor);
	}
}
