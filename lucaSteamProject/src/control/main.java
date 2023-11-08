package control;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManipularCSV archivo= new ManipularCSV();
		archivo.leerYAlmacenarDatos("src/resources/vgsales.csv");
		archivo.leerArchivo("src/resources/vgsales.csv");

	}

}
