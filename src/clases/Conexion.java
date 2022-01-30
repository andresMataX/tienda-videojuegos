package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion
{
	public static Connection conectar()
	{
		String url, user, pass;
		
		url = "jdbc:mysql://localhost/tienda_videojuegos";
		user = "chers0";
		pass = "Chersito21";
		
		try
		{
			Connection cn = DriverManager.getConnection(url, user, pass);
			return cn;
		}
		catch(SQLException err)
		{
			System.err.print("¡ERROR EN CONEXIÓN LOCAL! " + err);
			JOptionPane.showMessageDialog(null, "¡ERROR EN CREDENCIALES! Contacte con el Supervisor." + err);
		}
		return(null);
	}
}
