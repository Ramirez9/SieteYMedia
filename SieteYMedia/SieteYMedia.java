package sieteYMedia;

import utiles.Utilidades;

/**
 * Clase SieteYMedia que saca
 * 
 * @author Francisco Ramirez
 *
 */
public class SieteYMedia {

	Jugador[] jugadores = new Jugador[2];
	Carta carta;

	public SieteYMedia(Jugador j1, Jugador j2) {
		jugadores[0] = j1;
		jugadores[1] = j2;
		carta = new Carta();
	}

	String jugar() {
		String cadena = "";
		double contador1 = 0;
		double contador2 = 0;

		do {
			carta.sacarCarta();
			contador1 += carta.valorCarta();
			System.out.println("\n" + jugadores[0].getNombre() + ": " + carta.toString() + ". Lleva acumulado: " + contador1);
			if (contador1 > 7.5) {
				System.out.println("\nTe has pasado!! PIERDES...");
				break;
			}
		} while (Utilidades.deseaContinuar("\nQuiere seguir apostando? s/n: "));

		do {                                     
			carta.sacarCarta();
			contador2 += carta.valorCarta();
			System.out.println("\n" + jugadores[1].getNombre() + ": " + carta.toString() + ". Lleva acumulado: " + contador2);
			if (contador2 > 7.5) {
				System.out.println("\nTe has pasado!! PIERDES...");
				break;
			}
		} while (Utilidades.deseaContinuar("\nQuiere seguir apostando? s/n: "));

		jugadores[0].incPartidasJugadas();
		jugadores[1].incPartidasJugadas();
		cadena += comprobarResultado(contador1, contador2);
		return cadena;
	}

	String comprobarResultado(double valor1, double valor2) {
		if (valor1 > 7.5 && valor2 <= 7.5) {
			jugadores[1].incPartidasGanadas();
			return "\n" + jugadores[1].getNombre() + " gana";
		} else if (valor2 > 7.5 && valor1 <= 7.5) {
			jugadores[0].incPartidasGanadas();
			return "\n" + jugadores[0].getNombre() + " gana";
		} else if (valor2 > 7.5 && valor1 > 7.5) {
			return "\nAmbos jugadores pierden";
		} else if (valor1 == valor2) {
			return "\nLos dos jugadores empatan!";
		} else {
			if (valor1 > valor2) {
				jugadores[0].incPartidasGanadas();
				return "\n" + jugadores[0].getNombre() + " gana";
			} else {
				jugadores[1].incPartidasGanadas();
				return "\n" + jugadores[1].getNombre() + " gana";
			}
		}
	}
}
