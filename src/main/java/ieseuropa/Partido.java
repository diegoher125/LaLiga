package main.java.ieseuropa;

public class Partido {

	private int idPartido;
	private String local;
	private int golesLocal;
	private String visitante;
	private int golesVisitante;

	public Partido(int idPartido, String local, int golesLocal, String visitante, int golesVisitante) {
		this.idPartido = idPartido;
		this.local = local;
		this.golesLocal = golesLocal;
		this.visitante = visitante;
		this.golesVisitante = golesVisitante;
	}

	public Partido(String local, int golesLocal, String visitante, int golesVisitante) {
		this.idPartido = 0;
		this.local = local;
		this.golesLocal = golesLocal;
		this.visitante = visitante;
		this.golesVisitante = golesVisitante;
	}
	
	public Partido(int idPartido) {
		this.idPartido = idPartido;
	}

	public int getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public String agregarPartido() {
		return "insert into partidos (local,golesLocal,visitante,golesVisitante) values ('" + this.local + "',"
				+ this.golesLocal + ",'" + this.visitante + "'," + this.golesVisitante + ");";
	}

	public String actualizarPartido() {
		return "update laliga.partidos set local = " + this.local + ", golesLocal = " + this.golesLocal
				+ ", visitante = " + this.visitante + ", golesVisitante = " + this.golesVisitante + 
				"where idPartido = " + this.idPartido + ";";
	}

	public String eliminarPartido() {
		return "delete from laliga.partidos where idPartido = " + this.idPartido + ";";
	}

	@Override
	public String toString() {
		return "Partido [idPartido=" + idPartido + ", local=" + local + ", golesLocal=" + golesLocal + ", visitante="
				+ visitante + ", golesVisitante=" + golesVisitante + "]";
	}

}
