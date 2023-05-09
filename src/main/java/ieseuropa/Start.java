package main.java.ieseuropa;

import java.util.ArrayList;
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
			Partido partido = new Partido(pedirString("Escriba el nombre del equipo local"),
					pedirInt("Escriba los goles del equipo local"),
					pedirString("Escriba el nombre del equipo visitante"), pedirInt("visitante"));
			conexion.ejecutarQuery(partido.agregarPartido());
			break;
		case 2:
			Partido partido2 = new Partido(pedirInt("Escriba el id del partido a eliminar"),
					pedirString("Escriba el nombre del equipo local"), pedirInt("Escriba los goles del equipo local"),
					pedirString("Escriba el nombre del equipo visitante"), pedirInt("visitante"));
			conexion.ejecutarQuery(partido2.actualizarPartido());
			break;
		case 3:
			Partido partido3 = new Partido(pedirInt("Escriba el id del partido a eliminar"));
			conexion.ejecutarQuery(partido3.eliminarPartido());
			break;
		case 4:
			ArrayList<Partido> partidos = conexion.cargarPartidos("SELECT * FROM partidos;");
			for (int i = 0; i < partidos.size(); i++) {
				System.out.println(partidos.get(i));
			}
			break;
		case 5:
			ArrayList<Partido> partidos1 = conexion.cargarPartidos("SELECT * FROM partidos;");
			String equipo = pedirString("Ingrese el equipo del que quiere listar los partidos");
			for (int i = 0; i < partidos1.size(); i++) {
				if (partidos1.get(i).getLocal().equalsIgnoreCase(equipo)
						|| partidos1.get(i).getVisitante().equalsIgnoreCase(equipo)) {
					System.out.println(partidos1.get(i));
				}
			}
			break;
		case 6:
			ArrayList<Partido> partidos2 = conexion.cargarPartidos("SELECT * FROM partidos;");
			int goles = pedirInt("Ingrese los goles en el partido que quiere listar los partidos");
			for (int i = 0; i < partidos2.size(); i++) {
				if (partidos2.get(i).getGolesLocal() + partidos2.get(i).getGolesVisitante() >= goles) {
					System.out.println(partidos2.get(i));
				}
			}
			break;
		case 7:
			ArrayList<Partido> partidos3 = conexion.cargarPartidos("SELECT * FROM partidos;");
			String equipo1 = pedirString("Ingrese el equipo del que quiere listar los partidos");
			for (int i = 0; i < partidos3.size(); i++) {
				if ((partidos3.get(i).getLocal().equalsIgnoreCase(equipo1)
						&& partidos3.get(i).getGolesLocal() > partidos3.get(i).getGolesVisitante())
						|| (partidos3.get(i).getVisitante().equalsIgnoreCase(equipo1)
								&& partidos3.get(i).getGolesVisitante() > partidos3.get(i).getGolesLocal())) {
					System.out.println(partidos3.get(i));
				}
			}
			break;
		case 8:
			System.out.println(conexion.calculoPartidos("SELECT count(idPartido) as idPartido FROM partidos;"));
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
		while (opcion > 0 && opcion < 9) {
			opcion = pedirInt("Indique la opcion:\n" + "1.Nuevo partido\n" + "2.Actualizar partido\n"
					+ "3.Eliminar partido\n" + "4.Listar partidos\n" + "5.Listar partidos de un equipo\n"
					+ "6.Listar partidos si tienen x goles o mas\n" + "7.Listar partidos que gana un equipo\n"
					+ "8.Nuemro de partidos");
			menu(opcion, conexion);
		}
	}

}
