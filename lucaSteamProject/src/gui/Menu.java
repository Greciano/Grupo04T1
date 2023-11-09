package gui;

/**
 * La clase "Menu" representa un menú de opciones para interactuar con el sistema WikiJuegos.
 * Puede mostrar las opciones disponibles al usuario.
 * 
 * @author Alvaro Medina
 */
public class Menu {

    /**
     * Muestra un menú de opciones en la consola.
     */
    public static void mostrarMenu() {
        System.out.println(" ");
        System.out.println(" WikiJuegos V1");
        System.out.println(" ");
        System.out.println("************************************************");
        System.out.println("*  Por favor, escoge una opcion: ");
        System.out.println("*    1.- Imprimir Lista");
        System.out.println("*    2.- Añadir Juego");
        System.out.println("*    3.- Filtrar Plataforma");
        System.out.println("*    4.- Filtrar Genero");
        System.out.println("*    5.- Filtrar Nintendo");
        System.out.println("*    0.- Terminar sesion");
        System.out.println("************************************************");
        System.out.println(" ");
        System.out.print(">> ");
    }
}
