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
public class MenMosAdmin extends JPanel
{
	public MenMosAdmin()
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
		
		JLabel lbl_titulo = new JLabel("MOSTRAR");
		lbl_titulo.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_titulo.setBounds(298, 75, 200, 45);
		lbl_titulo.setForeground(Color.BLACK);
		add(lbl_titulo);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		add(lbl_fecha);
		
		JButton btn_cor = new JButton("");
		btn_cor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosCorAdmin().setVisible(true);
			}
		});
		btn_cor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cor.setBackground(new Color(150,251,204));
		btn_cor.setBorder(null);
		btn_cor.setBounds(161, 120, 115, 115);
		Icon icono_cor = deco.icono("caja-registradora.png", 115, 115);
		btn_cor.setIcon(icono_cor);
		add(btn_cor);
		
		JButton btn_venta = new JButton("");
		btn_venta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosVenAdmin().setVisible(true);
			}
		});
		btn_venta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_venta.setBackground(new Color(150,251,204));
		btn_venta.setBorder(null);
		btn_venta.setBounds(496, 120, 115, 115);
		Icon icono_venta = deco.icono("punto-de-venta.png", 115, 115);
		btn_venta.setIcon(icono_venta);
		add(btn_venta);
		
		JButton btn_prov = new JButton("");
		btn_prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MosProvAdmin().setVisible(true);
			}
		});
		btn_prov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_prov.setBackground(new Color(150,251,204));
		btn_prov.setBorder(null);
		btn_prov.setBounds(161, 313, 115, 115);
		Icon icono_prov = deco.icono("inventario (1).png", 115, 115);
		btn_prov.setIcon(icono_prov);
		add(btn_prov);
		
		JButton btn_usr = new JButton("");
		btn_usr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosUsrAdmin().setVisible(true);
			}
		});
		btn_usr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_usr.setBackground(new Color(150,251,204));
		btn_usr.setBorder(null);
		btn_usr.setBounds(496, 313, 115, 115);
		Icon icono_usr = deco.icono("cajero.png", 115, 115);
		btn_usr.setIcon(icono_usr);
		add(btn_usr);
		
		JLabel lbl_cor = new JLabel("CORTES");
		lbl_cor.setForeground(Color.BLACK);
		lbl_cor.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_cor.setBounds(166, 235, 114, 33);
		add(lbl_cor);
		
		JLabel lbl_ven = new JLabel("VENTAS");
		lbl_ven.setForeground(Color.BLACK);
		lbl_ven.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_ven.setBounds(502, 235, 121, 33);
		add(lbl_ven);
		
		JLabel lbl_prov = new JLabel("PROVEEDORES");
		lbl_prov.setForeground(Color.BLACK);
		lbl_prov.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_prov.setBounds(123, 428, 191, 33);
		add(lbl_prov);
		
		JLabel lbl_usr = new JLabel("USUARIOS");
		lbl_usr.setForeground(Color.BLACK);
		lbl_usr.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_usr.setBounds(488, 428, 135, 33);
		add(lbl_usr);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		add(lbl_margen);
	}

}
