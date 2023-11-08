package servicios;

import datos.DatosJuegoImp;
import datos.IDatosJuego;

public class ServiciosJuego implements IServiciosJuego {
	
	private IDatosJuego datos = new DatosJuegoImp();

	@Override
	public void getJuegos() {
		datos.getJuegos();
		
	}
	
	
	

}
