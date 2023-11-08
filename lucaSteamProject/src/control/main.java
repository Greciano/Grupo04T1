package control;

import datos.DatosJuegoImp;
import datos.IDatosJuego;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDatosJuego archivo= new DatosJuegoImp();
		archivo.leerYAlmacenarDatos("src/resources/vgsales.csv");
		archivo.leerArchivo("src/resources/vgsales.csv");
	}
}
