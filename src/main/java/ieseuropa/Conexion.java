package main.java.ieseuropa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private static String db_ = "laliga";
	private static String login_ = "root";
	private static String pwd_ = "root";
	private static String url_ = "jdbc:mysql://localhost/" + db_ + "?serverTimezone=UTC";
	private static Connection conection_;
	private static Statement st_;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conection_ = DriverManager.getConnection(url_, login_, pwd_);
			if(conection_ != null) {
				st_ = conection_.createStatement();
				System.out.println("Conexion exitosa a la base de datos " + db_);
			}else {
				System.out.println("Conexion fallida. Muerte y destruccion");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ejecutarQuery(String query) {
		try {
			Statement st = conection_.createStatement();
			
			st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
