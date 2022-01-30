package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import clases.Decoracion;
import compartido.Login;
import compartido.SelecRegProv;

@SuppressWarnings("serial")
public class SubProvAdmin extends JFrame
{
	public SubProvAdmin()
	{
		Decoracion deco = new Decoracion();
		
		getContentPane().setBackground(new Color(150,251,204));	
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);		
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("| - Registrar Compra - |");
		
		JLabel lbl_bvd = new JLabel("\u00A1HOLA "+ deco.Nombre(Login.user) +"!");
		lbl_bvd.setForeground(Color.BLACK);
		lbl_bvd.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_bvd.setBounds(11, 9, 316, 45);
		getContentPane().add(lbl_bvd);
		
		JLabel lbl_fch = new JLabel("");
		lbl_fch.setForeground(Color.BLACK);
		lbl_fch.setFont(new Font("Roboto", Font.PLAIN, 30));
		lbl_fch.setBounds(585, 9, 174, 35);
		getContentPane().add(lbl_fch);
		
		JLabel lbl_tit = new JLabel("REGISTRAR COMPRA - PROVEEDOR");
		lbl_tit.setForeground(Color.BLACK);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(81, 75, 607, 45);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_new_prov = new JLabel("NUEVO");
		lbl_new_prov.setForeground(Color.BLACK);
		lbl_new_prov.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_new_prov.setBounds(157, 327, 91, 33);
		getContentPane().add(lbl_new_prov);
		
		JLabel lbl_exist_prov = new JLabel("EXISTENTE");
		lbl_exist_prov.setForeground(Color.BLACK);
		lbl_exist_prov.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_exist_prov.setBounds(492, 329, 145, 33);
		getContentPane().add(lbl_exist_prov);
		
		JButton btn_new_prov = new JButton("");
		btn_new_prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegProvAdmin().setVisible(true);
				dispose();
			}
		});
		btn_new_prov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_new_prov.setBackground(new Color(150, 251, 204));
		btn_new_prov.setBorder(null);
		btn_new_prov.setBounds(128, 178, 150, 150);
		Icon icono_prov = deco.icono("agregar-usuario.png", 150, 150);
		btn_new_prov.setIcon(icono_prov);
		getContentPane().add(btn_new_prov);
		
		JButton btn_exis_prov = new JButton("");
		btn_exis_prov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_exis_prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecRegProv().setVisible(true);
				dispose();
			}
		});
		btn_exis_prov.setBorder(null);
		btn_exis_prov.setBackground(new Color(150, 251, 204));
		btn_exis_prov.setBounds(491, 178, 150, 150);
		Icon icono_clie = deco.icono("registros-medicos.png", 150, 150);
		btn_exis_prov.setIcon(icono_clie);
		getContentPane().add(btn_exis_prov);
		
		JButton btn_reg = new JButton("");
		btn_reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SubRegComAdmin().setVisible(true);
			}
		});
		btn_reg.setBorder(null);
		btn_reg.setBackground(new Color(150, 251, 204));
		btn_reg.setBounds(23, 426, 49, 49);
		Icon icono_reg = deco.icono("regreso.png", 49, 49);
		btn_reg.setIcon(icono_reg);
		getContentPane().add(btn_reg);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
	}

}
