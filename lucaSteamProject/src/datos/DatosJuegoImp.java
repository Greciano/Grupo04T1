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
import java.util.Scanner;

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
import utilidades.LeerTeclado;

public class DatosJuegoImp implements IDatosJuego {

    // Atributos

	private BufferedReader lector;
	private String linea;
	private String partes[] = null;
	private int numeroEnumeracion = 1;
	private List<Juego> listaJuegos = new ArrayList<>();

    // Constructor

	public DatosJuegoImp() {
		leerYAlmacenarDatos("src/resources/vgsales.csv", listaJuegos);
	}

	
	//(método para leer un archivo CSV y generar un archivo PDF)
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

	
    

	
    // Este método podría implementar la transformación de una cadena a un objeto Juego.
	public Juego transformStringToGame(String linea) {

		return new Juego();
	}

	
    //(método para leer y almacenar datos desde un archivo CSV)

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

	
    //(método para obtener y mostrar la lista de juegos)
	@Override
	public void getJuegos() {
		StringBuilder sb = new StringBuilder();
		for (Juego e : listaJuegos) {
			sb.append(e.toString() + "\n");
		}
		System.out.println(sb.toString());

	}

	
    //(método para leer y almacenar datos desde un archivo CSV)
	@Override
	public void leerYAlmacenarDatos() {
		// TODO Auto-generated method stub

	}

    //(método para agregar un juego a la lista de juegos)
	@Override
	public void addJuego() {
	
		try {
			String nombre = LeerTeclado.leerLinea("Ingrese el nombre del juego:");

			int fecha = LeerTeclado.leerInt("Ingrese el año de lanzamiento: ");

			String editor = LeerTeclado.leerLinea("Ingrese el editor: ");

			mostrarOpcionesPlataforma();
			int opcionPlataforma = LeerTeclado.leerInt("Selecciona la plataforma:");
			
			mostrarOpcionesGenero();
			int opcionGenero = LeerTeclado.leerInt("Selecciona el genero:");
			

			Plataforma plataforma = seleccionarPlataforma(opcionPlataforma);
			Genero genero = seleccionarGenero(opcionGenero);

			Juego nuevoJuego = new Juego(nombre, fecha, editor, plataforma, genero);
			listaJuegos.add(nuevoJuego);

		} catch (Exception e) {
			System.out.println("Error al ingresar los datos: " + e.getMessage());
		} finally {

		}

	}

    //(método auxiliar para mostrar las opciones de plataforma)
	public static void mostrarOpcionesPlataforma() {
		for (int i = 0; i < Plataforma.values().length; i++) {
			System.out.println(i + 1 + ". " + Plataforma.values()[i].getValor());
		}
	}

    // Otros métodos privados auxiliares para seleccionar plataformas y géneros
	public static void mostrarOpcionesGenero() {
		for (int i = 0; i < Genero.values().length; i++) {
			System.out.println(i + 1 + ". " + Genero.values()[i].getValor());
		}
	}

	
    //(método auxiliar para seleccionar una plataforma)
	public static Plataforma seleccionarPlataforma(int opcion) {
		return Plataforma.values()[opcion - 1];
	}

    //(método auxiliar para seleccionar un género)

	public static Genero seleccionarGenero(int opcion) {
		return Genero.values()[opcion - 1];
	}

	
    //(método para filtrar juegos por plataforma y mostrar los resultados)
	@Override
	public void filtrarPlataforma() {
		
		mostrarOpcionesPlataforma();
		int opcionPlataforma = LeerTeclado.leerInt("Selecciona la plataforma:");
		Plataforma plataforma = seleccionarPlataforma(opcionPlataforma);
		
		 List<Juego> juegosFiltrados = new ArrayList<>();
		
		for (Juego juego : listaJuegos) {
	        if (juego.getPlataforma() == plataforma) {
	            juegosFiltrados.add(juego);
	        }
	    }

	    // Ahora tienes la lista de juegos filtrados por la plataforma seleccionada
	    for (Juego juego : juegosFiltrados) {
	        System.out.println(juego);
	    }


	}

    //(método para filtrar juegos por género y mostrar los resultados)

	@Override
	public void filtrarGenero() {
		
		mostrarOpcionesGenero();
		int opcionGenero = LeerTeclado.leerInt("Selecciona el genero:");
		Genero genero = seleccionarGenero(opcionGenero);
		
		 List<Juego> juegosFiltrados = new ArrayList<>();
			
			for (Juego juego : listaJuegos) {
		        if (juego.getGenero() == genero) {
		            juegosFiltrados.add(juego);
		        }
		    }

		    // Ahora tienes la lista de juegos filtrados por la plataforma seleccionada
		    for (Juego juego : juegosFiltrados) {
		        System.out.println(juego);
		    }
		
	}
	
	//(método para filtrar juegos relacionados con Nintendo en la lista de juegos)

		@Override
		public void filtrarNintendo() {
			
			String editorBuscado = "Nintendo"; // El editor que deseas buscar
			
			 List<Juego> juegosFiltrados = new ArrayList<>();
				
				for (Juego juego : listaJuegos) {
			        if (juego.getEditor().equalsIgnoreCase(editorBuscado)) {
			            juegosFiltrados.add(juego);
			        }
			    }

			    // Ahora tienes la lista de juegos filtrados por la plataforma seleccionada
			    for (Juego juego : juegosFiltrados) {
			        System.out.println(juego);
			    }
			
		}
	
	
	
	
	

}