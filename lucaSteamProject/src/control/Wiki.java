package control;

import gui.Menu;
import servicios.ServiciosJuego;
import servicios.IServiciosJuego;
import utilidades.LeerTeclado;

/**
 * Clase principal de la aplicación WikiJuegos que gestiona las interacciones
 * con el usuario y coordina los servicios de juegos.
 * 
 * Esta clase inicia la aplicación y proporciona un menú interactivo para que
 * los usuarios puedan elegir entre varias opciones, como listar juegos,
 * agregar un nuevo juego o aplicar filtros por plataforma y género.
 * 
 * Los servicios de juegos se gestionan a través de la interfaz `IServiciosJuego`
 * y la implementación `ServiciosJuego`. Los métodos de esta clase llaman a los
 * métodos correspondientes de los servicios para realizar las operaciones.
 */
public class Wiki {

	// Atributos
	IServiciosJuego servicios = new ServiciosJuego();

	/**
	 * Inicia la aplicación WikiJuegos y muestra el menú interactivo.
	 */
	public void start() {
		boolean continuar = true;
		do {
			try {
				Menu.mostrarMenu();
				continuar = this.seleccionOpciones();
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error: " + e.getMessage() + "\n");
			}
		} while (continuar);
		System.out.println("   --- Fin de la sesión ---");
	}

	/**
	 * Permite al usuario seleccionar una opción del menú interactivo.
	 *
	 * @return `false` si el usuario elige salir, de lo contrario, devuelve `true`.
	 */
	public boolean seleccionOpciones() {
		while (true) {
			try {
				String input = LeerTeclado.leerLinea().trim();
				if (input.isEmpty()) {
					throw new IllegalArgumentException("Entrada vacía. Por favor, ingrese un valor.");
				}
				int opcion = Integer.parseInt(input);
				switch (opcion) {
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
					servicios.filtrarNintendo();
					break;
				case 0:
					return salir();
				default:
					System.out.println("Opción no válida. Por favor, elija una opción válida.\n");
					mostrarMenuConEspera();
					break;
				}

				mostrarMenuConEspera();

			} catch (NumberFormatException e) {
				System.out.println("Error: Por favor, ingrese un número válido.\n");
				mostrarMenuConEspera();
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage() + "\n");
				mostrarMenuConEspera();
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado: " + e.getMessage() + "\n");
				mostrarMenuConEspera();
			}
		}
	}

	/**
	 * Muestra el menú y espera un momento para que el usuario pueda leerlo.
	 */
	private void mostrarMenuConEspera() {
		try {
			Thread.sleep(1000); // Espera de 1 segundo
			Menu.mostrarMenu();
		} catch (InterruptedException e) {
			System.out.println("Error al mostrar el menú. Inténtelo de nuevo.\n");
		}
	}

	/**
	 * Pregunta al usuario si está seguro de salir de la aplicación.
	 *
	 * @return `false` si el usuario confirma que quiere salir, `true` si el usuario
	 *         decide continuar.
	 */
	private boolean salir() {
		while (true) {
			try {
				String sino = LeerTeclado.leerLinea("   ¿Está seguro? (S/N)").trim();
				if (!sino.isEmpty()) {
					char respuesta = Character.toUpperCase(sino.charAt(0));
					if (respuesta == 'S') {
						return false;
					} else if (respuesta == 'N') {
						System.out.println("Elija una opción:\n");
						mostrarMenuConEspera();
						return true;
					} else {
						System.out.println("Respuesta no válida. Por favor, responda con 'S' para sí o 'N' para no.\n");
					}
				} else {
					System.out.println("Por favor, responda con 'S' para sí o 'N' para no.\n");
				}
			} catch (Exception e) {
				System.out.println("Error: Ha ocurrido un problema al leer la entrada del usuario.\n");
			}
		}
	}
}

