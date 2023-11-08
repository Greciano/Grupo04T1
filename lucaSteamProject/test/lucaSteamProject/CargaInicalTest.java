package lucaSteamProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datos.DatosJuegoImp;
import datos.IDatosJuego;

class CargaInicalTest {

	IDatosJuego archivo = new DatosJuegoImp();

	@Test
	public void listavacia() {
		archivo.leerYAlmacenarDatos(null);
		archivo.leerYAlmacenarDatos(null);

		
	}

}
