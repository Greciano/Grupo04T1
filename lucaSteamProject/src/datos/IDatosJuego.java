package datos;

import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import model.Juego;

public interface IDatosJuego {

	public void leerArchivo();

	public void escribirLineaEnPDF(Document document) throws DocumentException;

	public void filtrarNintendo();

	public void leerYAlmacenarDatos();

	public void getJuegos();
	
	public void addJuego();
	
	public void filtrarPlataforma();
	
	public void filtrarGenero();

}
