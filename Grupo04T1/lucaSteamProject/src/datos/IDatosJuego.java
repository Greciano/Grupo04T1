package datos;

import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import model.Juego;

public interface IDatosJuego {
	
	public List<Juego> getJuego();
	
	public void setJuego(List<Juego> juego);
	
	public void addJuego(Juego e);
	
	public void leerArchivo(String nombreArchivo);
	
	public void escribirLineaEnPDF(Document document) throws DocumentException;
	
	public void leerYAlmacenarDatos(String file);
}
