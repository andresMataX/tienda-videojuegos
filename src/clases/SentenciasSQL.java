package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SentenciasSQL
{
	/**
	 * Crea un registro en la base de datos
	 * @param statemet = la sentencia SQL
	 * @param reg[] = Arreglo donde se almacenan las variables para registrarse en la base de datos
	 * @param tipo[] = Guía que define el tipo de dato de cómo se guardará en la base de datos (1=Int, 2=String, 3=Double)
	 **/
	public void createSQL(String statement, String[] reg, int[] tipo)
	{
		try
		{
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(statement);
			for (int i = 0; i < reg.length; i++)
			{
				switch (tipo[i])
				{
					case 1:
						pst.setInt(i+1, Integer.parseInt(reg[i]));
						break;
					case 2:
						pst.setString(i+1, reg[i]);
						break;
					case 3:
						pst.setDouble(i+1, Double.parseDouble(reg[i]));
						break;
				}
			}
			
			pst.executeUpdate();
			cn.close();
			JOptionPane.showMessageDialog(null, "¡Operación Exitosa!");
		} 
		catch (Exception e2)
		{
			System.err.print("¡ERROR EN OPERACIÓN REGISTRAR! " + e2);
			JOptionPane.showMessageDialog(null, "¡ERROR EN OPERACIÓN REGISTRAR! Contactar con el Desarrollador.");
		}
	}
	
	/**
	 * Modifica un registro de la base de datos
	 * @param statemet = la sentencia SQL
	 * @param reg[] = Arreglo donde se almacenan las variables para modificarse en la base de datos
	 * @param tipo[] = Guía que define el tipo de dato de cómo se guardará en la base de datos (1=Int, 2=String, 3=Double)
	 * */
	public void updateSQL(String statement, String[] mod, int[] tipo)
	{
		try
		{
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(statement);
			
			for (int i = 0; i < mod.length; i++)
			{
				switch (tipo[i])
				{
					case 1:
						pst.setInt(i+1, Integer.parseInt(mod[i]));
						break;
					case 2:
						pst.setString(i+1, mod[i]);
						break;
					case 3:
						pst.setDouble(i+1, Double.parseDouble(mod[i]));
						break;
				}
			}
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "¡Modificación Realizada!");
		} 
		catch (Exception e)
		{
			System.err.print("¡ERROR EN ACTUALIZAR REGISTRO! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR ACTUALIZANDO REGISTRO! Contactar con el Desarrollador.");
		}
	}
	
	public void deleteSQL(String statement)
	{
		try 
		{
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(statement);
			
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "¡Registro Eliminado!");
		} 
		catch (SQLException e1) 
		{
			System.err.print("¡ERROR ELIMINANDO REGISTRO! " + e1);
			JOptionPane.showMessageDialog(null, "¡ERROR ELIMINANDO REGISTRO! Contactar con el Desarrollador.");
		}
	}
	
	public int cveDetalles(String statement, String cve)
	{
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = statement;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) 
			{
				return rs.getInt(cve);
			}
		} 
		catch (SQLException e1) 
		{
			System.err.print("¡ERROR BUSCANDO CLAVE! " + e1);
			JOptionPane.showMessageDialog(null, "¡ERROR EN BUSCAR CLAVE! Contactar con el Desarrollador.");
		}
		return 0;
	}

}
