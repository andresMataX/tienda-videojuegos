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
public class MosUsrAdmin extends JFrame
{
	public MosUsrAdmin()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Mostrar Usuarios - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("INFORMACI\u00D3N DEL USUARIO");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(138, 75, 500, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom_usr = new JLabel("NOMBRE (S)");
		lbl_nom_usr.setForeground(Color.BLACK);
		lbl_nom_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom_usr.setBounds(28, 129, 185, 28);
		getContentPane().add(lbl_nom_usr);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setForeground(Color.BLACK);
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosUsrAdmin().setVisible(true);
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JLabel lbl_app_usr = new JLabel("APELLIDO PATERNO");
		lbl_app_usr.setForeground(Color.BLACK);
		lbl_app_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_app_usr.setBounds(397, 129, 230, 28);
		getContentPane().add(lbl_app_usr);
		
		JTextField txt_app_usr = new JTextField();
		txt_app_usr.setEditable(false);
		txt_app_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_app_usr.setBackground(Color.WHITE);
		txt_app_usr.setForeground(Color.BLACK);
		txt_app_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_app_usr.setColumns(10);
		txt_app_usr.setBounds(397, 157, 350, 28);
		getContentPane().add(txt_app_usr);
		
		JTextField txt_apm_usr = new JTextField();
		txt_apm_usr.setEditable(false);
		txt_apm_usr.setForeground(Color.BLACK);
		txt_apm_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_apm_usr.setColumns(10);
		txt_apm_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_apm_usr.setBackground(Color.WHITE);
		txt_apm_usr.setBounds(28, 260, 350, 28);
		getContentPane().add(txt_apm_usr);
		
		JTextField txt_call_usr = new JTextField();
		txt_call_usr.setEditable(false);
		txt_call_usr.setForeground(Color.BLACK);
		txt_call_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_call_usr.setColumns(10);
		txt_call_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_call_usr.setBackground(Color.WHITE);
		txt_call_usr.setBounds(28, 374, 350, 28);
		getContentPane().add(txt_call_usr);
		
		JTextField txt_tel_usr = new JTextField();
		txt_tel_usr.setEditable(false);
		txt_tel_usr.setForeground(Color.BLACK);
		txt_tel_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_tel_usr.setColumns(10);
		txt_tel_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_tel_usr.setBackground(Color.WHITE);
		txt_tel_usr.setBounds(397, 260, 350, 28);
		getContentPane().add(txt_tel_usr);
		
		JLabel lbl_apm_usr = new JLabel("APELLIDO MATERNO");
		lbl_apm_usr.setForeground(Color.BLACK);
		lbl_apm_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_apm_usr.setBounds(28, 227, 250, 28);
		getContentPane().add(lbl_apm_usr);
		
		JLabel lbl_call_usr = new JLabel("CALLE");
		lbl_call_usr.setForeground(Color.BLACK);
		lbl_call_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_call_usr.setBounds(28, 346, 230, 28);
		getContentPane().add(lbl_call_usr);
		
		JLabel lbl_tel_usr = new JLabel("TEL\u00C9FONO");
		lbl_tel_usr.setForeground(Color.BLACK);
		lbl_tel_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_tel_usr.setBounds(397, 227, 260, 28);
		getContentPane().add(lbl_tel_usr);
		
		JTextField txt_nom_usr = new JTextField();
		txt_nom_usr.setEditable(false);
		txt_nom_usr.setForeground(Color.BLACK);
		txt_nom_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_usr.setColumns(10);
		txt_nom_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_usr.setBackground(Color.WHITE);
		txt_nom_usr.setBounds(27, 157, 350, 28);
		getContentPane().add(txt_nom_usr);
		
		JLabel lbl_col_usr = new JLabel("COLONIA");
		lbl_col_usr.setForeground(Color.BLACK);
		lbl_col_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_col_usr.setBounds(396, 346, 230, 28);
		getContentPane().add(lbl_col_usr);
		
		JTextField txt_col_usr = new JTextField();
		txt_col_usr.setForeground(Color.BLACK);
		txt_col_usr.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_col_usr.setEditable(false);
		txt_col_usr.setColumns(10);
		txt_col_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_col_usr.setBackground(Color.WHITE);
		txt_col_usr.setBounds(397, 374, 350, 28);
		getContentPane().add(txt_col_usr);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_usr, app_usr, apm_usr,  tel_usr, call_usr, col_usr from usuarios where cve_usr = " + SelecMosUsrAdmin.cve_usr;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_apm_usr.setText(rs.getString("apm_usr"));
				txt_app_usr.setText(rs.getString("app_usr"));
				txt_call_usr.setText(rs.getString("call_usr"));
				txt_col_usr.setText(rs.getString("col_usr"));
				txt_nom_usr.setText(rs.getString("nom_usr"));
				txt_tel_usr.setText(rs.getString("tel_usr"));
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("?ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "?ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
	}

}
