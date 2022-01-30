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
import clases.Funcionalidades;
import clases.SentenciasSQL;
import compartido.Login;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class RegCamAdmin extends JFrame
{
	public RegCamAdmin()
	{	
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Registrar Cambio - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("REGISTRAR CAMBIO");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(208, 75, 350, 45);
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
		
		JLabel lbl_fch_ent = new JLabel("FECHA DE ENTRADA");
		lbl_fch_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_ent.setBounds(57, 335, 230, 28);
		getContentPane().add(lbl_fch_ent);
		
		JLabel lbl_dia_ent = new JLabel("DIA");
		lbl_dia_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_dia_ent.setBounds(57, 363, 40, 28);
		getContentPane().add(lbl_dia_ent);
		
		JTextField txt_dia_ent = new JTextField();
		txt_dia_ent.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia_ent.setForeground(Color.BLACK);
		txt_dia_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_dia_ent.setColumns(10);
		txt_dia_ent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_dia_ent.setBackground(Color.WHITE);
		txt_dia_ent.setBounds(100, 363, 40, 28);
		getContentPane().add(txt_dia_ent);
		
		JLabel lbl_mes_ent = new JLabel("MES");
		lbl_mes_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_mes_ent.setBounds(145, 363, 49, 28);
		getContentPane().add(lbl_mes_ent);
		
		JTextField txt_mes_ent = new JTextField();
		txt_mes_ent.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mes_ent.setForeground(Color.BLACK);
		txt_mes_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_mes_ent.setColumns(10);
		txt_mes_ent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_mes_ent.setBackground(Color.WHITE);
		txt_mes_ent.setBounds(199, 363, 40, 28);
		getContentPane().add(txt_mes_ent);
		
		JLabel lbl_anio_ent = new JLabel("A\u00D1O");
		lbl_anio_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_anio_ent.setBounds(244, 363, 51, 28);
		getContentPane().add(lbl_anio_ent);
		
		JTextField txt_anio_ent = new JTextField();
		txt_anio_ent.setHorizontalAlignment(SwingConstants.CENTER);
		txt_anio_ent.setForeground(Color.BLACK);
		txt_anio_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_anio_ent.setColumns(10);
		txt_anio_ent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_anio_ent.setBackground(Color.WHITE);
		txt_anio_ent.setBounds(298, 363, 40, 28);
		getContentPane().add(txt_anio_ent);
		
		JScrollPane sc_raz_cam = new JScrollPane();
		sc_raz_cam.setBounds(57, 167, 654, 153);
		getContentPane().add(sc_raz_cam);
		
		JTextArea ta_raz_cam = new JTextArea();
		sc_raz_cam.setViewportView(ta_raz_cam);
		ta_raz_cam.setColumns(10);
		ta_raz_cam.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta_raz_cam.setFont(new Font("Roboto", Font.PLAIN, 24));
		ta_raz_cam.setForeground(Color.BLACK);
		ta_raz_cam.setBackground(Color.WHITE);
		
		JButton btn_ace = new JButton("ACEPTAR");
		btn_ace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(txt_dia_ent, txt_mes_ent, txt_anio_ent, ta_raz_cam))
				{
					String fec_cam = "20"+txt_anio_ent.getText()+"-"+txt_mes_ent.getText()+"-"+txt_dia_ent.getText();
					
					SentenciasSQL c = new SentenciasSQL();
					String statement_cam = "insert into cambios values (?,?,?,?)";
					String[] reg_cam = {"0", Login.cve_user+"", fec_cam, ta_raz_cam.getText()};
					int[] tipo_cam = {1,1,2,2};
					c.createSQL(statement_cam, reg_cam, tipo_cam);	
					
					int cve_art = 0;
					try 
					{
						Connection cn = Conexion.conectar();
						String sql = "select art_ven from detalle_ventas where cve_ven =" +SelecRegCamAdmin.cve_cam;
						PreparedStatement pst = cn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						
						while(rs.next()) 
						{
							cve_art = rs.getInt("art_ven");
						}
						cn.close();
					} 
					catch (SQLException e1) 
					{
						System.err.print("¡ERROR EN AGARRAR CLAVE! " + e1);
						JOptionPane.showMessageDialog(null, "¡ERROR EN BUSCAR CLAVE! Contactar con el Desarrollador.");
					}
					int cve_cam = c.cveDetalles("select max(cve_cam) as cve_cam from cambios", "cve_cam");
					String statement_dcam = "insert into detalle_cambios values (?,?)";
					String[] reg_dcam = {cve_cam+"", cve_art+""};
					int[] tipo_dcam = {1,1};
					c.createSQL(statement_dcam, reg_dcam, tipo_dcam);
					
					dispose();
				}
			}
		});
		btn_ace.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_ace.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ace.setForeground(Color.BLACK);
		btn_ace.setBackground(new Color(60,199,134));
		btn_ace.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_ace.setBounds(407, 415, 150, 50);
		getContentPane().add(btn_ace);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecRegCamAdmin().setVisible(true);
				dispose();
			}
		});
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_cancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_cancelar.setBackground(new Color(73,122,100)); // COLOR 497A64
		btn_cancelar.setBounds(582, 415, 160, 50);
		getContentPane().add(btn_cancelar);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (new Funcionalidades().validadorReg(txt_anio_ent, txt_dia_ent, txt_mes_ent, ta_raz_cam))
				{
				case 0:
					
					dispose();
					break;
				case 3:
					
					dispose();
					break;
				}
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
	}
}
