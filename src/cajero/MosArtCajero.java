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
public class MosArtCajero extends JFrame
{
	public MosArtCajero()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Mostrar Artículos - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_titulo = new JLabel("INFORMACI\u00D3N ART\u00CDCULO");
		lbl_titulo.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_titulo.setBounds(168, 75, 440, 45);
		lbl_titulo.setForeground(Color.BLACK);
		getContentPane().add(lbl_titulo);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom = new JLabel("NOMBRE DEL ART\u00CDCULO");
		lbl_nom.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom.setBounds(22, 131, 270, 28);
		getContentPane().add(lbl_nom);
		
		JLabel lbl_prov = new JLabel("PROVEEDOR DEL ART\u00CDCULO");
		lbl_prov.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_prov.setBounds(22, 234, 310, 28);
		getContentPane().add(lbl_prov);
		
		JLabel lbl_pre = new JLabel("PRECIO DEL ART\u00CDCULO");
		lbl_pre.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_pre);
		
		JLabel lbl_cat = new JLabel("CATEGOR\u00CDA DEL ART\u00CDCULO");
		lbl_cat.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cat.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_cat);
		
		JLabel lbl_cant = new JLabel("CANTIDAD DEL ART\u00CDCULO");
		lbl_cant.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cant.setBounds(22, 337, 288, 28);
		getContentPane().add(lbl_cant);
		
		JLabel lbl_cond = new JLabel("CONDICI\u00D3N DEL ART\u00CDCULO");
		lbl_cond.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cond.setBounds(395, 337, 300, 28);
		getContentPane().add(lbl_cond);
		
		JTextField txt_nom_art = new JTextField();
		txt_nom_art.setEditable(false);
		txt_nom_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_art.setBackground(Color.WHITE);
		txt_nom_art.setForeground(Color.BLACK);
		txt_nom_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_art.setBounds(22, 159, 350, 28);
		getContentPane().add(txt_nom_art);
		txt_nom_art.setColumns(10);
		
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
				new SelecMosArtCajero().setVisible(true);
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JTextField txt_prov_art = new JTextField();
		txt_prov_art.setEditable(false);
		txt_prov_art.setForeground(Color.BLACK);
		txt_prov_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_prov_art.setColumns(10);
		txt_prov_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_prov_art.setBackground(Color.WHITE);
		txt_prov_art.setBounds(22, 262, 350, 28);
		getContentPane().add(txt_prov_art);
		
		JTextField txt_cnd_art = new JTextField();
		txt_cnd_art.setEditable(false);
		txt_cnd_art.setForeground(Color.BLACK);
		txt_cnd_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cnd_art.setColumns(10);
		txt_cnd_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cnd_art.setBackground(Color.WHITE);
		txt_cnd_art.setBounds(395, 365, 350, 28);
		getContentPane().add(txt_cnd_art);
		
		JTextField txt_cat_art = new JTextField();
		txt_cat_art.setEditable(false);
		txt_cat_art.setForeground(Color.BLACK);
		txt_cat_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cat_art.setColumns(10);
		txt_cat_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cat_art.setBackground(Color.WHITE);
		txt_cat_art.setBounds(395, 262, 350, 28);
		getContentPane().add(txt_cat_art);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
		
		int prov=0, cnd=0,cat=0;
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_art, cat_art,cnd_art,cnt_art,pre_art,prov_art  from articulos where cve_art = " + SelecMosArtCajero.cve_art;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_nom_art.setText(rs.getString("nom_art"));
				cat = rs.getInt("cat_art");
				cnd = rs.getInt("cnd_art");
				txt_cnt_art.setText(rs.getString("cnt_art"));
				txt_pre_art.setText(rs.getString("pre_art"));
				prov = rs.getInt("prov_art");
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
			String sql = "select nom_prov from proveedores where cve_prov= " + prov;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_prov_art.setText(rs.getString(1));
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
			String sql = "select nom_cnd from condicion where cve_cnd= " + cnd;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_cnd_art.setText(rs.getString(1));
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
				txt_cat_art.setText(rs.getString(1));
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
