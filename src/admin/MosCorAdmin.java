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
public class MosCorAdmin extends JFrame
{
	public MosCorAdmin()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Mostrar Cortes de Caja - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("INFORMACI\u00D3N CORTE");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(194, 75, 390, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_arqi_cor = new JLabel("FONDO INICIAL");
		lbl_arqi_cor.setForeground(Color.BLACK);
		lbl_arqi_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_arqi_cor.setBounds(28, 129, 185, 28);
		getContentPane().add(lbl_arqi_cor);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setForeground(Color.BLACK);
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosCorAdmin().setVisible(true);
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JLabel lbl_ret_cor = new JLabel("RETIROS DE DINERO");
		lbl_ret_cor.setForeground(Color.BLACK);
		lbl_ret_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_ret_cor.setBounds(397, 129, 230, 28);
		getContentPane().add(lbl_ret_cor);
		
		JTextField txt_ret_cor = new JTextField();
		txt_ret_cor.setEditable(false);
		txt_ret_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_ret_cor.setBackground(Color.WHITE);
		txt_ret_cor.setForeground(Color.BLACK);
		txt_ret_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_ret_cor.setColumns(10);
		txt_ret_cor.setBounds(397, 157, 350, 28);
		getContentPane().add(txt_ret_cor);
		
		JTextField txt_arqf_cor = new JTextField();
		txt_arqf_cor.setEditable(false);
		txt_arqf_cor.setForeground(Color.BLACK);
		txt_arqf_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_arqf_cor.setColumns(10);
		txt_arqf_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_arqf_cor.setBackground(Color.WHITE);
		txt_arqf_cor.setBounds(28, 260, 350, 28);
		getContentPane().add(txt_arqf_cor);
		
		JTextField txt_fal_cor = new JTextField();
		txt_fal_cor.setEditable(false);
		txt_fal_cor.setForeground(Color.BLACK);
		txt_fal_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_fal_cor.setColumns(10);
		txt_fal_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_fal_cor.setBackground(Color.WHITE);
		txt_fal_cor.setBounds(28, 363, 350, 28);
		getContentPane().add(txt_fal_cor);
		
		JTextField txt_cob_cor = new JTextField();
		txt_cob_cor.setEditable(false);
		txt_cob_cor.setForeground(Color.BLACK);
		txt_cob_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cob_cor.setColumns(10);
		txt_cob_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cob_cor.setBackground(Color.WHITE);
		txt_cob_cor.setBounds(397, 260, 350, 28);
		getContentPane().add(txt_cob_cor);
		
		JLabel lbl_ret_cor_1 = new JLabel("ARQUEO FINAL");
		lbl_ret_cor_1.setForeground(Color.BLACK);
		lbl_ret_cor_1.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_ret_cor_1.setBounds(28, 227, 230, 28);
		getContentPane().add(lbl_ret_cor_1);
		
		JLabel lbl_fal_cor = new JLabel("FALTANTE");
		lbl_fal_cor.setForeground(Color.BLACK);
		lbl_fal_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fal_cor.setBounds(28, 330, 230, 28);
		getContentPane().add(lbl_fal_cor);
		
		JLabel lbl_cob_cor = new JLabel("COBRANZA DE VENTAS");
		lbl_cob_cor.setForeground(Color.BLACK);
		lbl_cob_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cob_cor.setBounds(397, 227, 260, 28);
		getContentPane().add(lbl_cob_cor);
		
		JTextField txt_arqfi_cor = new JTextField();
		txt_arqfi_cor.setEditable(false);
		txt_arqfi_cor.setForeground(Color.BLACK);
		txt_arqfi_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_arqfi_cor.setColumns(10);
		txt_arqfi_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_arqfi_cor.setBackground(Color.WHITE);
		txt_arqfi_cor.setBounds(27, 157, 350, 28);
		getContentPane().add(txt_arqfi_cor);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select arqf_cor, cob_cor, ret_cor, arqfi_cor, fal_cor from corte_caja where cve_cor = " + SelecMosCorAdmin.cve_cor;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_arqf_cor.setText(rs.getString("arqf_cor"));
				txt_arqfi_cor.setText(rs.getString("arqfi_cor"));
				txt_cob_cor.setText(rs.getString("cob_cor"));
				txt_fal_cor.setText(rs.getString("fal_cor"));
				txt_ret_cor.setText(rs.getString("ret_cor"));
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
