package cajero;

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
import compartido.RegComClie;
import compartido.SelecRegProv;

@SuppressWarnings("serial")
public class SubRegComCajero extends JFrame
{
	public SubRegComCajero()
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
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fch = new JLabel(fecha.fecha());
		lbl_fch.setForeground(Color.BLACK);
		lbl_fch.setFont(new Font("Roboto", Font.BOLD, 30));
		lbl_fch.setBounds(585, 9, 174, 35);
		getContentPane().add(lbl_fch);
		
		JLabel lbl_tit = new JLabel("REGISTRAR COMPRA");
		lbl_tit.setForeground(Color.BLACK);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(203, 75, 363, 45);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_prov = new JLabel("PROVEEDOR");
		lbl_prov.setForeground(Color.BLACK);
		lbl_prov.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_prov.setBounds(124, 327, 158, 33);
		getContentPane().add(lbl_prov);
		
		JLabel lbl_clie = new JLabel("CLIENTE");
		lbl_clie.setForeground(Color.BLACK);
		lbl_clie.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_clie.setBounds(510, 328, 110, 33);
		getContentPane().add(lbl_clie);
		
		JButton btn_reg_prov = new JButton("");
		btn_reg_prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecRegProv().setVisible(true);
				dispose();
			}
		});
		btn_reg_prov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reg_prov.setBackground(new Color(150, 251, 204));
		btn_reg_prov.setBorder(null);
		btn_reg_prov.setBounds(128, 178, 150, 150);
		Icon icono_prov = deco.icono("inventario (1).png", 150, 150);
		btn_reg_prov.setIcon(icono_prov);
		getContentPane().add(btn_reg_prov);
		
		JButton btn_reg_clie = new JButton("");
		btn_reg_clie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegComClie().setVisible(true);
				dispose();
			}
		});
		btn_reg_clie.setBorder(null);
		btn_reg_clie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reg_clie.setBackground(new Color(150, 251, 204));
		btn_reg_clie.setBounds(491, 178, 150, 150);
		Icon icono_clie = deco.icono("personas.png", 150, 150);
		btn_reg_clie.setIcon(icono_clie);
		getContentPane().add(btn_reg_clie);
		
		JButton btn_reg = new JButton("");
		btn_reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
