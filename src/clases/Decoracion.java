package clases;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Decoracion
{
	public String Nombre(String user)
	{
		try
		{
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select nom_usr from usuarios where usr_usr = '" + user + "'");
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
			{
				return rs.getString("nom_usr").toUpperCase();
			}
			cn.close();
		} 
		catch (Exception e)
		{
			System.err.print("ERROR EN BUSCAR NOMBRE DEL USUARIO. " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR AL BUSCAR NOMBRE DEL USUARIO! Contactar con el Desarrollador.");
		}
		return "";
	}
	
	public String fecha()
	{
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		return formatoFecha.format(fecha);
	}
	
	public String fechaDetallada()
	{
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyyy-MM-dd HH:mm:ss
		return formatoFecha.format(fecha);
	}
	
	public Icon icono(String n_imagen, int W, int H)
	{
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(n_imagen));
		Icon icono = new ImageIcon(image.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
		return icono;
	}
}
