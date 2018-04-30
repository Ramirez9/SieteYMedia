package sieteYMedia;

import utiles.*;

/**
 * Juego de las siete y media
 * 
 * @author Francisco Ramirez
 * @version 1.0
 *
 */
public class TestSieteYMedia {

	public static void main(String[] args) {
		String[] opciones = { "Jugar", "Resultados totales", "Salir" };
		Menu menu = new Menu("\n-----Juego de las siete y media-----", opciones);

		Jugador jugador1 = new Jugador(
				Teclado.leerCadena("Bienvenido a la siete y media. \nDame tu nombre, jugador 1: "));
		Jugador jugador2 = new Jugador(Teclado.leerCadena("Dame tu nombre, jugador 2: "));

		SieteYMedia juego = new SieteYMedia(jugador1, jugador2);

		int opcion;

		do {
			opcion = menu.gestionar();

			switch (opcion) {
			case 1:

				System.out.println(juego.jugar());
				break;

			case 2:

				System.out.println(jugador1.toString());
				System.out.println(jugador2.toString());
				break;

			case 3:
				System.out.println("\nSALIENDO...");
				break;

			default:
				System.out.println("\nPor favor introduzca una opción correcta.");
			}
		} while (opcion != 3);

	}

}
