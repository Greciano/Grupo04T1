package control;

import java.util.Date;

import datos.DatosJuegoImp;
import datos.IDatosJuego;
import gui.Menu;
import servicios.ServiciosJuego;
import servicios.IServiciosJuego;
import utilidades.LeerTeclado;

public class Wiki {

	// atributos
	IServiciosJuego servicios = new ServiciosJuego();

	public void start() {

		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = this.seleccionOpciones();
		} while (seguir);
		System.out.println("   --- Fin de la sesion ---");

	}

	public boolean seleccionOpciones() {

		boolean continuar = true;
		switch (LeerTeclado.leerInt()) {
		case 1:

			servicios.getJuegos();

			break;

		case 2:
			servicios.addJuego();

			break;

		case 3:

			servicios.filtrarPlataforma();

			break;

		case 4:

			servicios.filtrarGenero();
			break;

		case 5:

			break;

		case 6:

			break;

		case 7:

			break;

		case 0:
			continuar = salir();
			break;
		}

		return continuar;
	}

	private boolean salir() {
		String sino = LeerTeclado.leerLinea("   �Esta seguro?(S/N)");
		return (sino.toUpperCase().charAt(0) != 'S');
	}

}
