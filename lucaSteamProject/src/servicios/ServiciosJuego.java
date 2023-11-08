package servicios;

import datos.DatosJuegoImp;
import datos.IDatosJuego;
import model.Juego;

public class ServiciosJuego implements IServiciosJuego {

	private IDatosJuego datos = new DatosJuegoImp();

	@Override
	public void getJuegos() {
		datos.getJuegos();

	}

	@Override
	public void addJuego() {
		datos.addJuego();

	}

	@Override
	public void filtrarPlataforma() {
		datos.filtrarPlataforma();

	}

	@Override
	public void filtrarGenero() {
		datos.filtrarGenero();

	}

}
