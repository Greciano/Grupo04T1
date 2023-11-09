package servicios;

import datos.DatosJuegoImp;
import datos.IDatosJuego;

/**
 * Implementación de la interfaz IServiciosJuego que proporciona servicios relacionados con juegos.
 */
public class ServiciosJuego implements IServiciosJuego {

    private IDatosJuego datos = new DatosJuegoImp();

    /**
     * Obtiene una lista de juegos.
     */
    @Override
    public void getJuegos() {
        datos.getJuegos();
    }

    /**
     * Agrega un nuevo juego.
     */
    @Override
    public void addJuego() {
        datos.addJuego();
    }

    /**
     * Filtra juegos por plataforma.
     */
    @Override
    public void filtrarPlataforma() {
        datos.filtrarPlataforma();
    }

    /**
     * Filtra juegos por género.
     */
    @Override
    public void filtrarGenero() {
        datos.filtrarGenero();
    }

	@Override
	public void filtrarNintendo() {
		datos.filtrarNintendo();
		
	}
}
