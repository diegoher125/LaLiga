package main.java.ieseuropa;

import java.util.Scanner;

public class Start {

	private static String pedirString(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextLine();
	}

	private static int pedirInt(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.print(texto);
		return teclado.nextInt();
	}

	private static void menu(int opcion, Conexion conexion) {
		switch (opcion) {
		case 1:
			Partido partido = new Partido(pedirString("Escriba el nombre del equipo local"), pedirInt(""),
					pedirString("Escriba el nombre del equipo visitante"), pedirInt(""));
			conexion.ejecutarQuery(partido.agregarPartido());
			break;
		case 2:
			Partido partido2 = new Partido(pedirInt("Escriba el id del partido a eliminar"),
					pedirString("Escriba el nombre del equipo local"), pedirInt(""),
					pedirString("Escriba el nombre del equipo visitante"), pedirInt(""));
			conexion.ejecutarQuery(partido2.actualizarPartido());
			break;
		case 3:
			Partido partido3 = new Partido(pedirInt("Escriba el id del partido a eliminar"), "", 0, "", 0);
			conexion.ejecutarQuery(partido3.eliminarPartido());
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion conexion = new Conexion();
		/*
		 * Partido partido = new Partido("Sevilla", 3, "Atleti", 1);
		 * System.out.println(partido.agregarPartido());
		 * conexion.ejecutarQuery(partido.agregarPartido()); Partido partido2 = new
		 * Partido(3,"Valencia", 0, "Atletico Astorga", 5);
		 * conexion.ejecutarQuery(partido2.eliminarPartido());
		 */
		int opcion = 1;
		while (opcion > 0 && opcion < 4) {
			opcion = pedirInt("");
			menu(opcion, conexion);
		}
	}

}
