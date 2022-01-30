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
public class MosRenCajero extends JFrame
{
	public MosRenCajero()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("| - Mostrar Rentas - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("INFORMACI\u00D3N RENTA");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(198, 75, 385, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom_ren = new JLabel("NOMBRE DEL CLIENTE");
		lbl_nom_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom_ren.setBounds(23, 131, 270, 28);
		getContentPane().add(lbl_nom_ren);
		
		JLabel lbl_col_ren = new JLabel("COLONIA DEL CLIENTE");
		lbl_col_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_col_ren.setBounds(23, 234, 260, 28);
		getContentPane().add(lbl_col_ren);
		
		JLabel lbl_call_ren = new JLabel("CALLE DEL CLIENTE");
		lbl_call_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_call_ren.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_call_ren);
		
		JLabel lbl_tel_ren = new JLabel("TEL\u00C9FONO DEL CLIENTE");
		lbl_tel_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_tel_ren.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_tel_ren);
		
		JTextField txt_nom_ren = new JTextField();
		txt_nom_ren.setEditable(false);
		txt_nom_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_ren.setBackground(Color.WHITE);
		txt_nom_ren.setForeground(Color.BLACK);
		txt_nom_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_ren.setColumns(10);
		txt_nom_ren.setBounds(22, 159, 350, 28);
		getContentPane().add(txt_nom_ren);
		
		JTextField txt_call_ren = new JTextField();
		txt_call_ren.setEditable(false);
		txt_call_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_call_ren.setBackground(Color.WHITE);
		txt_call_ren.setForeground(Color.BLACK);
		txt_call_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_call_ren.setColumns(10);
		txt_call_ren.setBounds(395, 159, 350, 28);
		getContentPane().add(txt_call_ren);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosRenCajero().setVisible(true);
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JTextField txt_col_ren = new JTextField();
		txt_col_ren.setEditable(false);
		txt_col_ren.setForeground(Color.BLACK);
		txt_col_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_col_ren.setColumns(10);
		txt_col_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_col_ren.setBackground(Color.WHITE);
		txt_col_ren.setBounds(23, 262, 350, 28);
		getContentPane().add(txt_col_ren);
		
		JTextField txt_tel_ren = new JTextField();
		txt_tel_ren.setEditable(false);
		txt_tel_ren.setForeground(Color.BLACK);
		txt_tel_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_tel_ren.setColumns(10);
		txt_tel_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_tel_ren.setBackground(Color.WHITE);
		txt_tel_ren.setBounds(396, 262, 350, 28);
		getContentPane().add(txt_tel_ren);
		
		JLabel lbl_pre_ren = new JLabel("PRECIO DE LA RENTA");
		lbl_pre_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_ren.setBounds(22, 334, 260, 28);
		getContentPane().add(lbl_pre_ren);
		
		JTextField txt_pre_ren = new JTextField();
		txt_pre_ren.setEditable(false);
		txt_pre_ren.setForeground(Color.BLACK);
		txt_pre_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_ren.setColumns(10);
		txt_pre_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_ren.setBackground(Color.WHITE);
		txt_pre_ren.setBounds(22, 362, 350, 28);
		getContentPane().add(txt_pre_ren);
		
		JLabel lbl_mgn = new JLabel("");
		lbl_mgn.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_mgn.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_mgn);
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select tel_ren, col_ren,nom_ren,call_ren from detalle_rentas where cve_ren = " + SelecMosRenCajero.cve_ren;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				//txt_apm_usr.setText(rs.getString("apm_usr"));
				txt_tel_ren.setText(rs.getString("tel_ren"));
				txt_col_ren.setText(rs.getString("col_ren"));
				txt_nom_ren.setText(rs.getString("nom_ren"));
				txt_call_ren.setText(rs.getString("call_ren"));
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
			String sql = "select pre_ren from rentas where cve_ren = " + SelecMosRenCajero.cve_ren;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_pre_ren.setText(rs.getDouble("pre_ren")+"");
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
