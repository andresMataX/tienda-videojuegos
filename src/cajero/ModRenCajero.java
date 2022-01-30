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
public class ModRenCajero extends JFrame
{
	public ModRenCajero()
	{	
		Decoracion deco = new Decoracion();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Modificar Rentas - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("REGISTRAR RETORNO");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(201, 76, 377, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_rec_ren = new JLabel("RECARGOS DE LA RENTA");
		lbl_rec_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_rec_ren.setBounds(32, 236, 280, 28);
		getContentPane().add(lbl_rec_ren);
		
		JTextField txt_rec_ren = new JTextField();
		txt_rec_ren.setForeground(Color.BLACK);
		txt_rec_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_rec_ren.setColumns(10);
		txt_rec_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_rec_ren.setBackground(Color.WHITE);
		txt_rec_ren.setBounds(32, 264, 350, 28);
		getContentPane().add(txt_rec_ren);
		
		JTextField txt_dia_ren = new JTextField();
		txt_dia_ren.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia_ren.setForeground(Color.BLACK);
		txt_dia_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_dia_ren.setColumns(10);
		txt_dia_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_dia_ren.setBackground(Color.WHITE);
		txt_dia_ren.setBounds(412, 264, 292, 28);
		getContentPane().add(txt_dia_ren);
		
		JLabel lbl_fch_sal = new JLabel("FECHA DE RETORNO REAL");
		lbl_fch_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_sal.setBounds(412, 236, 330, 28);
		getContentPane().add(lbl_fch_sal);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(txt_rec_ren, txt_dia_ren))
				{
					SentenciasSQL c = new SentenciasSQL();					
					String statement_com = "update rentas set ret_ren = ?, ext_ren = ? where cve_ren = '"+ SelecModRenCajero.cve_ren +"'";
					String[] reg_com = {txt_dia_ren.getText(), txt_rec_ren.getText()};
					int[] tipo_com = {2,3};
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
				new SelecModRenCajero().setVisible(true);
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
			String sql = "select ext_ren, ret_ren from rentas where cve_ren = " + SelecModRenCajero.cve_ren;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_rec_ren.setText(rs.getString("ext_ren"));
				txt_dia_ren.setText(rs.getString("ret_ren"));
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
