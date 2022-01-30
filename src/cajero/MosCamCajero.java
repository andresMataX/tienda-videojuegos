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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Conexion;
import clases.Decoracion;
import compartido.Login;

@SuppressWarnings("serial")
public class MosCamCajero extends JFrame
{
	public MosCamCajero()
	{Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Mostrar Cambios - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("INFORMACI\u00D3N CAMBIO");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(182, 75, 405, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom = new JLabel("RAZ\u00D3N DEL CAMBIO");
		lbl_nom.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom.setBounds(57, 131, 230, 28);
		getContentPane().add(lbl_nom);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosCamCajero().setVisible(true);
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JLabel lbl_fch_ent = new JLabel("FECHA DE ENTRADA");
		lbl_fch_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_ent.setBounds(57, 335, 230, 28);
		getContentPane().add(lbl_fch_ent);
		
		JTextField txt_dia_ent = new JTextField();
		txt_dia_ent.setEditable(false);
		txt_dia_ent.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia_ent.setForeground(Color.BLACK);
		txt_dia_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_dia_ent.setColumns(10);
		txt_dia_ent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_dia_ent.setBackground(Color.WHITE);
		txt_dia_ent.setBounds(57, 363, 230, 28);
		getContentPane().add(txt_dia_ent);
		
		JScrollPane sc_raz_cam = new JScrollPane();
		sc_raz_cam.setBounds(57, 167, 654, 153);
		getContentPane().add(sc_raz_cam);
		
		JTextArea ta_raz_cam = new JTextArea();
		ta_raz_cam.setEditable(false);
		sc_raz_cam.setViewportView(ta_raz_cam);
		ta_raz_cam.setColumns(10);
		ta_raz_cam.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta_raz_cam.setFont(new Font("Roboto", Font.PLAIN, 24));
		ta_raz_cam.setForeground(Color.BLACK);
		ta_raz_cam.setBackground(Color.WHITE);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select fec_cam, raz_cam from cambios where cve_cam = " + SelecMosCamCajero.cve_cam;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_dia_ent.setText(rs.getString("fec_cam"));
				ta_raz_cam.setText(rs.getString("raz_cam"));
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
