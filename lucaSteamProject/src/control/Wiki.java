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
			
			
			break;

		case 2:
			
			
			break;

		case 3:
			
			
			break;

		case 4:
			
			
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
