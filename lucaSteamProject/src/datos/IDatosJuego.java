/**
 * Interfaz para manejar datos de juegos.
 */
package datos;

import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import model.Juego;

public interface IDatosJuego {

    /**
     * Lee un archivo y realiza operaciones sobre él.
     */
    public void leerArchivo();

    /**
     * Escribe una línea en un documento PDF.
     *
     * @param document El documento PDF en el que se escribe la línea.
     * @throws DocumentException Excepción relacionada con el documento PDF.
     */
    public void escribirLineaEnPDF(Document document) throws DocumentException;

    /**
     * Filtra datos relacionados con "Nintendo" en un archivo.
     */
    public void filtrarNintendo();

    /**
     * Lee y almacena datos desde una fuente de datos.
     */
    public void leerYAlmacenarDatos();

    /**
     * Obtiene una lista de juegos.
     */
    public void getJuegos();

    /**
     * Agrega un nuevo juego a la lista de juegos.
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
}
