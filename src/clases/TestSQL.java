package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class TestSQL
{

	public static void main(String[] args)
	{
		TestSQL c = new TestSQL();
		System.out.println("---------Test 1---------");
		String statement = "insert into ventas values (?,?,?,?)";
		String[] reg = {"0", "2", "1250.50", "2021-05-25"};
		int[] tipo = {1,1,3,2};
		c.createSQLTest(statement, reg, tipo);
		System.out.println("---------Test 2---------");
		String statement_2 = "insert into detalle_ventas values (?,?,?)";
		String[] reg_2 = {"14", "20", "5"};
		int[] tipo_2 = {1,1,1};
		c.createSQLTest(statement_2, reg_2, tipo_2);
		System.out.println("---------Test 3---------");
		String statement_3 = "insert into rentas values (?,?,?,?,?,?,?)";
		String[] reg_3 = {"0", "25", "2021-05-20", "2021-05-25", "45.50", "0.00", "4"};
		int[] tipo_3 = {1,1,2,2,3,3,1};
		c.createSQLTest(statement_3, reg_3, tipo_3);
	}
	
	/*
	 * Arreglo especificando a dónde entrar. Ejemplo []tipo = 1 2 1 1 1 2 3 3 1 
	 * Donde 1 es Int
	 * 		 2 es String
	 * 		 3 es Double
	 * */
	private void createSQLTest(String statement, String[] reg, int[] tipo)
	{
		try
		{
			/*Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(statement);*/
			System.out.println("statemen " + statement);
			System.out.println(reg.length);
			for (int i = 0; i < reg.length; i++)
			{
				System.out.println("Tipo = " + tipo[i]);
				switch (tipo[i])
				{
					case 1:
						System.out.println("pst.setInt("+(i+1)+", Integer.parseInt("+reg[i]+"))");
						break;
					case 2:
						System.out.println("pst.setString("+(i+1)+", "+reg[i]+")");
						break;
					case 3:
						System.out.println("pst.setDouble("+(i+1)+", Double.parseDouble("+reg[i]+"))");
						break;
				}
			}
			
			System.out.println("pst.executeUpdate()");
			System.out.println("cn.close();");
			System.out.println("¡Operación Exitosa!");
		} 
		catch (Exception e2)
		{
			System.err.print("¡ERROR EN OPERACIÓN REGISTRAR! " + e2);
			JOptionPane.showMessageDialog(null, "¡ERROR EN OPERACIÓN REGISTRAR! Contactar con el Desarrollador.");
		}
	}
	
	/*
	 * Arreglo especificando a dónde entrar. Ejemplo []tipo = 1 2 1 1 1 2 3 3 1 
	 * Donde 1 es Int
	 * 		 2 es String
	 * 		 3 es Double
	 * */
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

}
