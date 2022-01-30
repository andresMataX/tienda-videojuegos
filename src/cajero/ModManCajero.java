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
import clases.Funcionalidades;
import clases.SentenciasSQL;
import compartido.Login;

@SuppressWarnings("serial")
public class ModManCajero extends JFrame
{
	public ModManCajero()
	{
		Decoracion deco = new Decoracion();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Modificar Mantenimiento - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("MODIFICAR MANTENIMIENTO");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(128, 75, 515, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom = new JLabel("NOMBRE DEL CLIENTE");
		lbl_nom.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom.setBounds(22, 131, 250, 28);
		getContentPane().add(lbl_nom);
		
		JLabel lbl_tel_man = new JLabel("TEL\u00C9FONO DEL CLIENTE");
		lbl_tel_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_tel_man.setBounds(22, 234, 270, 28);
		getContentPane().add(lbl_tel_man);
		
		JLabel lbl_pre_man = new JLabel("PRECIO FINAL");
		lbl_pre_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_man.setBounds(22, 337, 210, 28);
		getContentPane().add(lbl_pre_man);
		
		JTextField txt_nom_man = new JTextField();
		txt_nom_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_man.setBackground(Color.WHITE);
		txt_nom_man.setForeground(Color.BLACK);
		txt_nom_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_man.setBounds(22, 159, 350, 28);
		getContentPane().add(txt_nom_man);
		txt_nom_man.setColumns(10);
		
		JTextField txt_pre_man = new JTextField();
		txt_pre_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_man.setBackground(Color.WHITE);
		txt_pre_man.setForeground(Color.BLACK);
		txt_pre_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_man.setColumns(10);
		txt_pre_man.setBounds(22, 365, 350, 28);
		getContentPane().add(txt_pre_man);
		
		JTextField txt_tel_man = new JTextField();
		txt_tel_man.setForeground(Color.BLACK);
		txt_tel_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_tel_man.setColumns(10);
		txt_tel_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_tel_man.setBackground(Color.WHITE);
		txt_tel_man.setBounds(22, 262, 350, 28);
		getContentPane().add(txt_tel_man);
		
		JTextField txt_sal_man = new JTextField();
		txt_sal_man.setHorizontalAlignment(SwingConstants.CENTER);
		txt_sal_man.setForeground(Color.BLACK);
		txt_sal_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_sal_man.setColumns(10);
		txt_sal_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_sal_man.setBackground(Color.WHITE);
		txt_sal_man.setBounds(402, 262, 270, 28);
		getContentPane().add(txt_sal_man);
		
		JLabel lbl_fch_sal = new JLabel("FECHA DE SALIDA FINAL");
		lbl_fch_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_sal.setBounds(402, 234, 330, 28);
		getContentPane().add(lbl_fch_sal);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(txt_nom_man, txt_pre_man, txt_tel_man, txt_sal_man))
				{
					SentenciasSQL c = new SentenciasSQL();					
					String statement_com = "update mantenimiento set sal_man = ?, pre_man= ?, tel_man= ?, nom_man= ? where cve_man = " + SelecModManCajero.cve_man;
					String[] reg_com = {txt_sal_man.getText(), txt_pre_man.getText(), txt_tel_man.getText(), txt_nom_man.getText()};
					int[] tipo_com = {2,3,2,2};
					c.createSQL(statement_com, reg_com, tipo_com);
					
					dispose();
				}
			}
		});
		btn_aceptar.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_aceptar.setForeground(Color.BLACK);
		btn_aceptar.setBackground(new Color(60,199,134));
		btn_aceptar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_aceptar.setBounds(407, 415, 150, 50);
		getContentPane().add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				new SelecModManCajero().setVisible(true);
				dispose();
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
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_man, pre_man, sal_man, tel_man from mantenimiento where cve_man = " + SelecModManCajero.cve_man;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				//envio = rs2.getString("costo_envio");
				txt_nom_man.setText(rs.getString("nom_man"));
				txt_pre_man.setText(rs.getString("pre_man"));
				txt_sal_man.setText(rs.getString("sal_man"));
				txt_tel_man.setText(rs.getString("tel_man"));
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
