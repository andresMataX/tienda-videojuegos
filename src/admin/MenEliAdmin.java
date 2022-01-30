package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Decoracion;
import compartido.Login;

@SuppressWarnings("serial")
public class MenEliAdmin extends JPanel
{
	public MenEliAdmin()
	{
		Decoracion deco = new Decoracion();
		
		setLayout(null);
		setBounds(0, 0, 773, 500);
		setBackground(new Color(150,251,204));
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		add(lbl_usuario);
		
		JLabel lbl_titulo = new JLabel("ELIMINAR");
		lbl_titulo.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_titulo.setBounds(297, 75, 175, 45);
		lbl_titulo.setForeground(Color.BLACK);
		add(lbl_titulo);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		add(lbl_fecha);
		
		JButton btn_art = new JButton("");
		btn_art.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliArtAdmin().setVisible(true);
			}
		});
		btn_art.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_art.setBackground(new Color(150,251,204));
		btn_art.setBorder(null);
		btn_art.setBounds(75, 178, 150, 150);
		Icon icono_art = deco.icono("consola.png", 150, 150);
		btn_art.setIcon(icono_art);
		add(btn_art);
		
		JButton btn_prov = new JButton("");
		btn_prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliProvAdmin().setVisible(true);
			}
		});
		btn_prov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_prov.setBackground(new Color(150,251,204));
		btn_prov.setBorder(null);
		btn_prov.setBounds(309, 178, 150, 150);
		Icon icono_prov = deco.icono("inventario (1).png", 150, 150);
		btn_prov.setIcon(icono_prov);
		add(btn_prov);
		
		JButton btn_usr = new JButton("");
		btn_usr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EliUsrAdmin().setVisible(true);
			}
		});
		btn_usr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_usr.setBackground(new Color(150,251,204));
		btn_usr.setBorder(null);
		btn_usr.setBounds(542, 178, 150, 150);
		Icon icono_usr = deco.icono("cajero.png", 150, 150);
		btn_usr.setIcon(icono_usr);
		add(btn_usr);
		
		JLabel lbl_art = new JLabel("ART\u00CDCULOS");
		lbl_art.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_art.setForeground(Color.BLACK);
		lbl_art.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_art.setBounds(78, 328, 150, 33);
		add(lbl_art);
		
		JLabel lbl_prov = new JLabel("PROVEEDORES");
		lbl_prov.setForeground(Color.BLACK);
		lbl_prov.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_prov.setBounds(288, 328, 195, 33);
		add(lbl_prov);
		
		JLabel lbl_usr = new JLabel("USUARIOS");
		lbl_usr.setForeground(Color.BLACK);
		lbl_usr.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_usr.setBounds(551, 328, 135, 33);
		add(lbl_usr);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		add(lbl_margen);
	}

}
