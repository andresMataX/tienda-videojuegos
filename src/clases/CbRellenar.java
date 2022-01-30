package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class CbRellenar
{
	private int id;
	private String nombre;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String toString()
	{
		return this.nombre;
	}
	/**
	 * @param statemen = La sentencia SQL para rellenar el JCombobox
	 * @param til_0 = Un String para agregar al JCombox como título
	 * @param cve = La columna de Clave de la tabla SQL
	 * @param nom = La columna de Nombre de la tabla SQL
	 * */
	public Vector<CbRellenar> mostrarCbox(String statement, String til_0, String cve, String nom)
	{
		Vector<CbRellenar> datos = new Vector<CbRellenar>();
		CbRellenar dat = null;
		
		try 
		{
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(statement);
			ResultSet rs = pst.executeQuery();
			
			dat = new CbRellenar();
			dat.setId(0);
			dat.setNombre(til_0);
			datos.add(dat);
			
			while(rs.next()) 
			{
				dat = new CbRellenar();
				dat.setId(rs.getInt(cve));
				dat.setNombre(rs.getString(nom));
				datos.add(dat);
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR COMBOBOX! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR INFORMACIÓN! Contactar con el Desarrollador.");
		}
		return datos;
	}
}
