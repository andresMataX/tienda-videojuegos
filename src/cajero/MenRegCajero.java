package cajero;

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
import compartido.RegArt;
import compartido.RegRen1;
import compartido.RegVen;
import compartido.SubMant;

@SuppressWarnings("serial")
public class MenRegCajero extends JPanel
{
	public MenRegCajero()
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
		
		JLabel lbl_titulo = new JLabel("REGISTRAR");
		lbl_titulo.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_titulo.setBounds(284, 75, 200, 45);
		lbl_titulo.setForeground(Color.BLACK);
		add(lbl_titulo);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		add(lbl_fecha);
		
		JButton btn_comprar = new JButton("");
		btn_comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubRegComCajero().setVisible(true);
			}
		});
		btn_comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_comprar.setBackground(new Color(150,251,204));
		btn_comprar.setBorder(null);
		btn_comprar.setBounds(54, 134, 100, 100);
		Icon icono_comprar = deco.icono("carrito-de-compras.png", 100, 100);
		btn_comprar.setIcon(icono_comprar);
		add(btn_comprar);
		
		JButton btn_mantenimiento = new JButton("");
		btn_mantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubMant().setVisible(true);
			}
		});
		btn_mantenimiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_mantenimiento.setBackground(new Color(150,251,204));
		btn_mantenimiento.setBorder(null);
		btn_mantenimiento.setBounds(244, 134, 100, 100);
		Icon icono_mantenimiento= deco.icono("mantenimiento.png", 100, 100);
		btn_mantenimiento.setIcon(icono_mantenimiento);
		add(btn_mantenimiento);
		
		JButton btn_venta = new JButton("");
		btn_venta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegVen().setVisible(true);
			}
		});
		btn_venta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_venta.setBackground(new Color(150,251,204));
		btn_venta.setBorder(null);
		btn_venta.setBounds(434, 134, 100, 100);
		Icon icono_venta = deco.icono("punto-de-venta.png", 100, 100);
		btn_venta.setIcon(icono_venta);
		add(btn_venta);
		
		JButton btn_renta = new JButton("");
		btn_renta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegRen1().setVisible(true);
			}
		});
		btn_renta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_renta.setBackground(new Color(150,251,204));
		btn_renta.setBorder(null);
		btn_renta.setBounds(621, 134, 100, 100);
		Icon icono_renta = deco.icono("contactos.png", 100, 100);
		btn_renta.setIcon(icono_renta);
		add(btn_renta);
		
		JButton btn_articulo = new JButton("");
		btn_articulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegArt().setVisible(true);
			}
		});
		btn_articulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_articulo.setBackground(new Color(150,251,204));
		btn_articulo.setBorder(null);
		btn_articulo.setBounds(335, 300, 100, 100);
		Icon icono_articulo = deco.icono("consola.png", 100, 100);
		btn_articulo.setIcon(icono_articulo);
		add(btn_articulo);
		
		JLabel lbl_compra = new JLabel("COMPRA");
		lbl_compra.setForeground(Color.BLACK);
		lbl_compra.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_compra.setBounds(47, 234, 114, 33);
		add(lbl_compra);
		
		JLabel lbl_mantenimiento = new JLabel("MANTENI");
		lbl_mantenimiento.setForeground(Color.BLACK);
		lbl_mantenimiento.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_mantenimiento.setBounds(229, 234, 130, 33);
		add(lbl_mantenimiento);
		
		JLabel lbl_mantenimiento_2 = new JLabel("MIENTO");
		lbl_mantenimiento_2.setForeground(Color.BLACK);
		lbl_mantenimiento_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mantenimiento_2.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_mantenimiento_2.setBounds(229, 267, 130, 33);
		add(lbl_mantenimiento_2);
		
		JLabel lbl_venta = new JLabel("VENTA");
		lbl_venta.setForeground(Color.BLACK);
		lbl_venta.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_venta.setBounds(438, 234, 90, 33);
		add(lbl_venta);
		
		JLabel lbl_renta = new JLabel("RENTA");
		lbl_renta.setForeground(Color.BLACK);
		lbl_renta.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_renta.setBounds(624, 234, 90, 33);
		add(lbl_renta);
		
		JLabel lbl_articulo = new JLabel("ART\u00CDCULO");
		lbl_articulo.setForeground(Color.BLACK);
		lbl_articulo.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_articulo.setBounds(319, 400, 130, 33);
		add(lbl_articulo);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		add(lbl_margen);
	}
}
