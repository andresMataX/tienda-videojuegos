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

@SuppressWarnings("serial")
public class MenMosCajero extends JPanel
{
	public MenMosCajero()
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
		lbl_titulo.setBounds(299, 75, 180, 45);
		lbl_titulo.setForeground(Color.BLACK);
		add(lbl_titulo);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		add(lbl_fecha);
		
		JButton btn_com = new JButton("");
		btn_com.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosComCajero().setVisible(true);
			}
		});
		btn_com.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_com.setBackground(new Color(150,251,204));
		btn_com.setBorder(null);
		btn_com.setBounds(54, 134, 100, 100);
		Icon icono_comprar = deco.icono("carrito-de-compras.png", 100, 100);
		btn_com.setIcon(icono_comprar);
		add(btn_com);
		
		JButton btn_man = new JButton("");
		btn_man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosManCajero().setVisible(true);
			}
		});
		btn_man.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_man.setBackground(new Color(150,251,204));
		btn_man.setBorder(null);
		btn_man.setBounds(244, 134, 100, 100);
		Icon icono_mantenimiento= deco.icono("mantenimiento.png", 100, 100);
		btn_man.setIcon(icono_mantenimiento);
		add(btn_man);
		
		JButton btn_cam = new JButton("");
		btn_cam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosCamCajero().setVisible(true);
			}
		});
		btn_cam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cam.setBackground(new Color(150,251,204));
		btn_cam.setBorder(null);
		btn_cam.setBounds(434, 134, 100, 100);
		Icon icono_venta = deco.icono("caja-de-devolucion.png", 100, 100);
		btn_cam.setIcon(icono_venta);
		add(btn_cam);
		
		JButton btn_ren = new JButton("");
		btn_ren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosRenCajero().setVisible(true);
			}
		});
		btn_ren.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ren.setBackground(new Color(150,251,204));
		btn_ren.setBorder(null);
		btn_ren.setBounds(621, 134, 100, 100);
		Icon icono_renta = deco.icono("contactos.png", 100, 100);
		btn_ren.setIcon(icono_renta);
		add(btn_ren);
		
		JButton btn_art = new JButton("");
		btn_art.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecMosArtCajero().setVisible(true);
			}
		});
		btn_art.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_art.setBackground(new Color(150,251,204));
		btn_art.setBorder(null);
		btn_art.setBounds(335, 300, 100, 100);
		Icon icono_articulo = deco.icono("consola.png", 100, 100);
		btn_art.setIcon(icono_articulo);
		add(btn_art);
		
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
		
		JLabel lbl_venta = new JLabel("CAMBIOS");
		lbl_venta.setForeground(Color.BLACK);
		lbl_venta.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_venta.setBounds(423, 234, 121, 33);
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
