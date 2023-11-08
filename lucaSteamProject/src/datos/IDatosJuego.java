package datos;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public interface IDatosJuego {

	public void leerArchivo(String nombreArchivo);
	
	public void escribirLineaEnPDF(Document document) throws DocumentException;
	
	public void leerYAlmacenarDatos(String file);
}
