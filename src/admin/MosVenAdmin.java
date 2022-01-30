package admin;

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
public class MosVenAdmin extends JFrame
{
	public MosVenAdmin()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Mostrar Ventas - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("INFORMACI\u00D3N VENTA");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(195, 75, 390, 45);
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
		
		JLabel lbl_fch_ven = new JLabel("FECHA");
		lbl_fch_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_ven.setBounds(23, 234, 80, 28);
		getContentPane().add(lbl_fch_ven);
		
		JLabel lbl_pre_com = new JLabel("PRECIO DEL ART\u00CDCULO");
		lbl_pre_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_com.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_pre_com);
		
		JLabel lbl_cat_com = new JLabel("CATEGOR\u00CDA DEL ART\u00CDCULO");
		lbl_cat_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cat_com.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_cat_com);
		
		JLabel lbl_cnt_com = new JLabel("CANTIDAD DEL ART\u00CDCULO");
		lbl_cnt_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cnt_com.setBounds(23, 337, 290, 28);
		getContentPane().add(lbl_cnt_com);
		
		JTextField txt_cnt_art = new JTextField();
		txt_cnt_art.setEditable(false);
		txt_cnt_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cnt_art.setBackground(Color.WHITE);
		txt_cnt_art.setForeground(Color.BLACK);
		txt_cnt_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cnt_art.setColumns(10);
		txt_cnt_art.setBounds(22, 365, 350, 28);
		getContentPane().add(txt_cnt_art);
		
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
				new SelecMosVenAdmin().setVisible(true);
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JTextField txt_fec_ven = new JTextField();
		txt_fec_ven.setEditable(false);
		txt_fec_ven.setForeground(Color.BLACK);
		txt_fec_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_fec_ven.setColumns(10);
		txt_fec_ven.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_fec_ven.setBackground(Color.WHITE);
		txt_fec_ven.setBounds(23, 262, 350, 28);
		getContentPane().add(txt_fec_ven);
		
		JTextField txt_cat_ven = new JTextField();
		txt_cat_ven.setEditable(false);
		txt_cat_ven.setForeground(Color.BLACK);
		txt_cat_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cat_ven.setColumns(10);
		txt_cat_ven.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cat_ven.setBackground(Color.WHITE);
		txt_cat_ven.setBounds(396, 262, 350, 28);
		getContentPane().add(txt_cat_ven);
		
		JTextField txt_nom_ven = new JTextField();
		txt_nom_ven.setEditable(false);
		txt_nom_ven.setForeground(Color.BLACK);
		txt_nom_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_ven.setColumns(10);
		txt_nom_ven.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_ven.setBackground(Color.WHITE);
		txt_nom_ven.setBounds(23, 159, 350, 28);
		getContentPane().add(txt_nom_ven);
		
		JLabel lbl_mgn = new JLabel("");
		lbl_mgn.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_mgn.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_mgn);
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select fec_ven, pre_ven from ventas where cve_ven = " + SelecMosVenAdmin.cve_ven;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{				
				
				txt_fec_ven.setText(rs.getString("fec_ven"));
				txt_pre_art.setText(rs.getString("pre_ven"));
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
		int cve_art=0;
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select art_ven, cnt_ven from detalle_ventas where cve_ven = " + SelecMosVenAdmin.cve_ven;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{			
				cve_art = rs.getInt("art_ven");
				txt_cnt_art.setText(rs.getString("cnt_ven"));
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
		
		int cat=0;		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_art, cat_art from articulos where cve_art= " + cve_art;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				cat = rs.getInt("cat_art");
				txt_nom_ven.setText(rs.getString(1));
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
			String sql = "select nom_cat from categoria where cve_cat= " + cat;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_cat_ven.setText(rs.getString(1));
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
