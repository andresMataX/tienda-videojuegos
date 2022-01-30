package cajero;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Conexion;
import clases.Decoracion;
import compartido.Login;

@SuppressWarnings("serial")
public class MosComCajero extends JFrame
{
	public MosComCajero()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Mostrar Compras - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("INFORMACI\u00D3N COMPRA");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(177, 75, 425, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom_com = new JLabel("NOMBRE DEL ART\u00CDCULO");
		lbl_nom_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom_com.setBounds(23, 131, 270, 28);
		getContentPane().add(lbl_nom_com);
		
		JLabel lbl_fch_com = new JLabel("FECHA DE COMPRA");
		lbl_fch_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_com.setBounds(23, 234, 220, 28);
		getContentPane().add(lbl_fch_com);
		
		JLabel lbl_pre_com = new JLabel("PRECIO DEL ART\u00CDCULO");
		lbl_pre_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_com.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_pre_com);
		
		JLabel lbl_cat_com = new JLabel("CATEGOR\u00CDA DEL ART\u00CDCULO");
		lbl_cat_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cat_com.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_cat_com);
		
		JTextField txt_nom_art = new JTextField();
		txt_nom_art.setEditable(false);
		txt_nom_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_art.setBackground(Color.WHITE);
		txt_nom_art.setForeground(Color.BLACK);
		txt_nom_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_art.setBounds(23, 159, 350, 28);
		getContentPane().add(txt_nom_art);
		txt_nom_art.setColumns(10);
		
		JTextField txt_pre_art = new JTextField();
		txt_pre_art.setEditable(false);
		txt_pre_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_art.setBackground(Color.WHITE);
		txt_pre_art.setForeground(Color.BLACK);
		txt_pre_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_art.setColumns(10);
		txt_pre_art.setBounds(395, 159, 350, 28);
		getContentPane().add(txt_pre_art);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosComCajero().setVisible(true);
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JTextField txt_fec_com = new JTextField();
		txt_fec_com.setEditable(false);
		txt_fec_com.setHorizontalAlignment(SwingConstants.CENTER);
		txt_fec_com.setForeground(Color.BLACK);
		txt_fec_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_fec_com.setColumns(10);
		txt_fec_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_fec_com.setBackground(Color.WHITE);
		txt_fec_com.setBounds(23, 262, 220, 28);
		getContentPane().add(txt_fec_com);
		
		JTextField txt_prov_com = new JTextField();
		txt_prov_com.setEditable(false);
		txt_prov_com.setForeground(Color.BLACK);
		txt_prov_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_prov_com.setColumns(10);
		txt_prov_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_prov_com.setBackground(Color.WHITE);
		txt_prov_com.setBounds(396, 364, 350, 28);
		getContentPane().add(txt_prov_com);
		
		JLabel lbl_prov_com = new JLabel("PROVEEDOR");
		lbl_prov_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_prov_com.setBounds(397, 336, 140, 28);
		getContentPane().add(lbl_prov_com);
		
		JTextField txt_cat_com = new JTextField();
		txt_cat_com.setEditable(false);
		txt_cat_com.setForeground(Color.BLACK);
		txt_cat_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cat_com.setColumns(10);
		txt_cat_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cat_com.setBackground(Color.WHITE);
		txt_cat_com.setBounds(395, 262, 350, 28);
		getContentPane().add(txt_cat_com);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
		
		int cve_art=0, cat_art=0;
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select cat_com, art_com from detalle_compras where cve_com = " + SelecMosComCajero.cve_com;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				cat_art = rs.getInt("cat_com");
				cve_art = rs.getInt("art_com");
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN CLAVES " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN CLAVES! Contactar con el Desarrollador.");
		}
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_art from articulos where cve_art = " + cve_art;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_nom_art.setText(rs.getString("nom_art"));
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_cat from categoria where cve_cat = " + cat_art;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_cat_com.setText(rs.getString("nom_cat"));
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
		int prov=0;
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select fec_com, pre_com,prov_com from compras where cve_com = " + SelecMosComCajero.cve_com;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{				
				txt_fec_com.setText(rs.getString("fec_com"));
				txt_pre_art.setText(rs.getString("pre_com"));
				prov = rs.getInt("prov_com");
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_prov from proveedores where cve_prov = " + prov;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{				
				txt_prov_com.setText(rs.getString("nom_prov"));
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
	}

}
