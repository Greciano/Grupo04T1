package control;

import java.util.Date;


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
			
			servicios.
			break;

		case 2:
			
			servicios.
			break;

		case 3:
			
			servicios.
			break;

		case 4:
			
			servicios.
			break;

		case 5:
			
			servicios.
			break;

		case 6:
			servicios.
			break;

		case 7:
			
			servicios.
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
