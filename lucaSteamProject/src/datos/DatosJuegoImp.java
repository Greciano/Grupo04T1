package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import model.Genero;
import model.Juego;
import model.Plataforma;

public class DatosJuegoImp implements IDatosJuego {

	private BufferedReader lector;
	private String linea;
	private String partes[] = null;
	private int numeroEnumeracion = 1;
	private List<Juego> listaJuegos = new ArrayList<>();

	public DatosJuegoImp() {
		leerYAlmacenarDatos("src/resources/vgsales.csv", listaJuegos);
	}

	@Override
	public void leerArchivo() {

		Document document = new Document(PageSize.A4.rotate());

		try {
			PdfWriter.getInstance(document, new FileOutputStream("src/resources/archivo.pdf"));
			document.open();

			lector = new BufferedReader(new FileReader("src/resources/vgsales.csv"));

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

	@Override
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

	@Override
	public void filtrarNintendo() {
		String file = "src/resources/vgsales.csv"; // Ruta del archivo CSV

		List<String[]> dataList = new ArrayList<>();
		int rowsToRead = 100; // Controla cuántas filas leer

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null && rowsToRead > 0) {
				if (line.contains("Nintendo")) { // Verifica si la línea contiene "Nintendo"
					String[] row = line.split(",");
					dataList.add(Arrays.copyOfRange(row, 1, row.length - 4)); // Elimina Rank y las ventas
					rowsToRead--;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no se pudo encontrar: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Ocurrió un error de lectura: " + e.getMessage());
		}

		// Imprime los encabezados sin Rank y ventas
		System.out.println(
				String.format("%-40s %-12s %-8s %-12s %-12s", "Name", "Platform", "Year", "Genre", "Publisher"));

		// Ahora dataList contiene los datos del CSV con las columnas eliminadas.
		for (String[] row : dataList) {
			System.out
					.println(String.format("%-40s %-12s %-8s %-12s %-12s", row[0], row[1], row[2], row[3], "Nintendo"));
		}
	}

	

	public Juego transformStringToGame(String linea) {

		return new Juego();
	}

	public static void leerYAlmacenarDatos(String file, List<Juego> listajuegos) {
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

		for (String[] row : dataList) {
			String nombre = row[0];
			int fecha = Integer.parseInt(row[2]); // Asegúrate de usar el índice correcto
			String editor = row[4];
			String plataformastr = row[1];
			String generostr = row[3];

			Plataforma plataforma = Plataforma.fromString(plataformastr);

			Genero genero = Genero.fromString(generostr);

			Juego juego = new Juego(nombre, fecha, editor, plataforma, genero);
			listajuegos.add(juego);
		}
	}

	


	@Override
	public void getJuegos() {
		StringBuilder sb = new StringBuilder();
        for (Juego e : listaJuegos) {
            sb.append(e.toString() + "\n");
        }
        System.out.println(sb.toString());
		
	}

	@Override
	public void leerYAlmacenarDatos() {
		// TODO Auto-generated method stub
		
	}

}