package compartido;

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

@SuppressWarnings("serial")
public class SubMant extends JFrame
{
	public SubMant()
	{
		Decoracion deco = new Decoracion();
		
		getContentPane().setBackground(new Color(150,251,204));	
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);		
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("| - Registrar Mantenimiento - |");
		
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
		
		JLabel lbl_tit = new JLabel("REGISTRAR MANTENIMIENTO");
		lbl_tit.setForeground(Color.BLACK);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(129, 75, 520, 45);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_man_con = new JLabel("CONSOLA");
		lbl_man_con.setForeground(Color.BLACK);
		lbl_man_con.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_man_con.setBounds(89, 340, 126, 33);
		getContentPane().add(lbl_man_con);
		
		JLabel lbl_man_acc = new JLabel("ACCESORIO");
		lbl_man_acc.setForeground(Color.BLACK);
		lbl_man_acc.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_man_acc.setBounds(544, 342, 150, 33);
		getContentPane().add(lbl_man_acc);
		
		JButton btn_man_con = new JButton("");
		btn_man_con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegManCon().setVisible(true);
				dispose();
			}
		});
		btn_man_con.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_man_con.setBackground(new Color(150, 251, 204));
		btn_man_con.setBorder(null);
		btn_man_con.setBounds(77, 192, 150, 150);
		Icon icono_prov = deco.icono("estacion-de-juegos.png", 150, 150);
		btn_man_con.setIcon(icono_prov);
		getContentPane().add(btn_man_con);
		
		JButton btn_man_acc = new JButton("");
		btn_man_acc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_man_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegManAcc().setVisible(true);
				dispose();
			}
		});
		btn_man_acc.setBorder(null);
		btn_man_acc.setBackground(new Color(150, 251, 204));
		btn_man_acc.setBounds(544, 192, 150, 150);
		Icon icono_clie = deco.icono("headphones (1).png", 150, 150);
		btn_man_acc.setIcon(icono_clie);
		getContentPane().add(btn_man_acc);
		
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
		
		JButton btn_man_disc = new JButton("");
		btn_man_disc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_man_disc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegManDisc().setVisible(true);
				dispose();
			}
		});
		btn_man_disc.setBorder(null);
		btn_man_disc.setBackground(new Color(150, 251, 204));
		btn_man_disc.setBounds(311, 192, 150, 150);
		Icon icono_man_disc = deco.icono("reproductor-de-cd.png", 150, 150);
		btn_man_disc.setIcon(icono_man_disc);
		getContentPane().add(btn_man_disc);
		
		JLabel lbl_man_disc = new JLabel("DISCO");
		lbl_man_disc.setForeground(Color.BLACK);
		lbl_man_disc.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_man_disc.setBounds(346, 340, 80, 33);
		getContentPane().add(lbl_man_disc);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
	}

}
