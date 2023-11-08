package control;

/**
*
* @author Adrián García
* 
*/
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ManipularCSV {

	private BufferedReader lector;
	private String linea;
	private String partes[] = null;
	private int numeroEnumeracion = 1;

	public void leerArchivo(String nombreArchivo) {
		Document document = new Document(PageSize.A4.rotate());

		try {
			PdfWriter.getInstance(document, new FileOutputStream("src/resources/archivo.pdf"));
			document.open();

			lector = new BufferedReader(new FileReader(nombreArchivo));

			while ((linea = lector.readLine()) != null) {
				partes = linea.split(",");
				escribirLineaEnPDF(document);
				numeroEnumeracion++;
			}
			lector.close();

			document.close();

			linea = null;
			partes = null;
		} catch (DocumentException | IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void escribirLineaEnPDF(Document document) throws DocumentException {
		Phrase phrase = new Phrase(numeroEnumeracion + ") ");

		// Suponemos que las columnas son Rank (partes[0]), Name (partes[1]), Platform
		// (partes[2]),
		// Year (partes[3]), Genre (partes[4]) y Publisher (partes[5]).
		if (partes.length >= 6) {
			phrase.add(partes[1] + " | ");
			phrase.add(partes[2] + " | ");
			phrase.add(partes[3] + " | ");
			phrase.add(partes[4] + " | ");
			phrase.add(partes[5] + " | ");
		}

		document.add(phrase);
		document.add(Chunk.NEWLINE);
	}

	public void leerYAlmacenarDatos(String file) {
		List<String[]> dataList = new ArrayList<>();
		boolean isFirstLine = true;
		int rowsToRead = 100; // Cambia este valor para controlar cuántas filas leer

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null && rowsToRead > 0) {
				if (isFirstLine) {
					isFirstLine = false;
					continue; // Saltar la primera línea (encabezados)
				}
				String[] row = line.split(",");

				// F
				String[] filteredData = new String[row.length - 6]; // Eliminar Rank y las ventas
				int targetIndex = 0;
				for (int sourceIndex = 1; sourceIndex < row.length - 5; sourceIndex++) {
					filteredData[targetIndex] = row[sourceIndex];
					targetIndex++;
				}
				dataList.add(filteredData);
				rowsToRead--;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Imprimir los encabezados sin Rank y ventas
		System.out.println(
				String.format("%-40s %-12s %-8s %-12s %-12s", "Name", "Platform", "Year", "Genre", "Publisher"));

		// Ahora dataList contiene los datos del CSV con las columnas eliminadas.
		for (String[] row : dataList) {
			System.out.println(String.format("%-40s %-12s %-8s %-12s %-12s", row[0], row[1], row[2], row[3], row[4]));
		}
	}

}
