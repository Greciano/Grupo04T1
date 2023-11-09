/**
 * Interfaz que define los servicios relacionados con juegos.
 */
package servicios;

public interface IServiciosJuego {

    /**
     * Obtiene una lista de juegos.
     */
    public void getJuegos();

    /**
     * Agrega un nuevo juego.
     */
    public void addJuego();

    /**
     * Filtra juegos por plataforma.
     */
    public void filtrarPlataforma();

    /**
     * Filtra juegos por género.
     */
    public void filtrarGenero();
    
    public void filtrarNintendo();
}
