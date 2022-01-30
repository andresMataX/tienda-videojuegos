package cajero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import clases.Decoracion;
import compartido.InfoUsr;
import compartido.Login;

@SuppressWarnings("serial")
public class Cajero extends JFrame
{	
	public Cajero()
	{
		Decoracion iconos = new Decoracion();
		InfoUsr iUser = new InfoUsr();
		MenRegCajero mRegistrar = new MenRegCajero();
		MenModCajero mModificar = new MenModCajero();
		MenMosCajero mMostrar = new MenMosCajero();
		
		
		JPanel contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 865, 540);
		setTitle("| - CAJERO - " + Login.user + " - |");
		setLocationRelativeTo(null);
		contentPane.setBackground(new Color(150,251,204)); // Color: 96FBCC
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Selector = new JPanel();
		Selector.setBounds(0, 0, 77, 501);
		contentPane.add(Selector);
		Selector.setLayout(null);
		
		JPanel Menus = new JPanel();
		Menus.setBackground(Color.WHITE);
		Menus.setBounds(76, 0, 773, 500);
		Menus.add(iUser);
		Menus.add(mRegistrar);
		Menus.add(mModificar);
		Menus.add(mMostrar);
		contentPane.add(Menus);
		
		iUser.setVisible(false);
		mRegistrar.setVisible(true);
		mModificar.setVisible(false);
		mMostrar.setVisible(false);
		
		JLabel lbl_selector_info = new JLabel("");
		JLabel lbl_selector_modificar = new JLabel("");
		JLabel lbl_selector_mostrar = new JLabel("");
		JLabel lbl_selector_cerrar = new JLabel("");
		JLabel lbl_selector_registrar = new JLabel("");
		
		JButton btn_cerrar = new JButton("");
		JButton btn_registrar = new JButton("");
		JButton btn_modificar = new JButton("");
		JButton btn_mostrar = new JButton("");
		
		/**
		 * Menú Info Usuario
		 * */
		JButton btn_info_usuario = new JButton("");
		btn_info_usuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_info_usuario.setBorder(null);
		btn_info_usuario.setBackground(new Color(76,250,168));
		btn_info_usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iUser.setVisible(true);
				mRegistrar.setVisible(false);
				mModificar.setVisible(false);
				mMostrar.setVisible(false);
				btn_info_usuario.setBackground(new Color(95,204,153));
				btn_cerrar.setBackground(new Color(76,250,168));
				btn_modificar.setBackground(new Color(76,250,168));
				btn_mostrar.setBackground(new Color(76,250,168));
				btn_registrar.setBackground(new Color(76,250,168));
				lbl_selector_info.setBorder(new LineBorder(new Color(95,204,153), 45));
				lbl_selector_cerrar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_modificar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_mostrar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_registrar.setBorder(new LineBorder(new Color(76,250,168), 45));
			}
		});
		btn_info_usuario.setBounds(14, 11, 49, 49);
		Icon icono_info_usuario = iconos.icono("avatar.png", 49, 49);
		btn_info_usuario.setIcon(icono_info_usuario);	
		Selector.add(btn_info_usuario);
		
		lbl_selector_info.setBorder(new LineBorder(new Color(76,250,168), 45));
		lbl_selector_info.setBounds(0, 0, 77, 72);		
		Menus.setLayout(new BorderLayout(0, 0));
		Selector.add(lbl_selector_info);
		
		/**
		 * Menú Registrar
		 * */
		btn_registrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_registrar.setBackground(new Color(95,204,153));
		btn_registrar.setBorder(null);
		btn_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iUser.setVisible(false);
				mRegistrar.setVisible(true);
				mModificar.setVisible(false);
				mMostrar.setVisible(false);
				btn_info_usuario.setBackground(new Color(76,250,168));
				btn_cerrar.setBackground(new Color(76,250,168));
				btn_modificar.setBackground(new Color(76,250,168));
				btn_mostrar.setBackground(new Color(76,250,168));
				btn_registrar.setBackground(new Color(95,204,153));
				lbl_selector_info.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_cerrar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_modificar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_mostrar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_registrar.setBorder(new LineBorder(new Color(95,204,153), 45));
			}
		});
		btn_registrar.setBounds(14, 82, 49, 49);
		Icon icono_registrar = iconos.icono("registro.png", 49, 49);
		btn_registrar.setIcon(icono_registrar);
		Selector.add(btn_registrar);
		
		lbl_selector_registrar.setBorder(new LineBorder(new Color(95,204,153), 45));
		lbl_selector_registrar.setBounds(0, 71, 77, 72);
		Menus.setLayout(new BorderLayout(0, 0));
		Selector.add(lbl_selector_registrar);
		
		/**
		 * Menú Modificar
		 * */
		btn_modificar.setBackground(new Color(76,250,168));		
		btn_modificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_modificar.setBounds(14, 153, 49, 49);
		btn_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iUser.setVisible(false);
				mRegistrar.setVisible(false);
				mModificar.setVisible(true);
				mMostrar.setVisible(false);
				btn_info_usuario.setBackground(new Color(76,250,168));
				btn_cerrar.setBackground(new Color(76,250,168));
				btn_modificar.setBackground(new Color(95,204,153));
				btn_mostrar.setBackground(new Color(76,250,168));
				btn_registrar.setBackground(new Color(76,250,168));
				lbl_selector_info.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_cerrar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_modificar.setBorder(new LineBorder(new Color(95,204,153), 45));
				lbl_selector_mostrar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_registrar.setBorder(new LineBorder(new Color(76,250,168), 45));
			}
		});
		btn_modificar.setBorder(null);
		btn_modificar.setBackground(new Color(76,250,168));
		Icon icono_modificar = iconos.icono("actualizar.png", 49, 49);
		btn_modificar.setIcon(icono_modificar);
		Selector.add(btn_modificar);
		
		lbl_selector_modificar.setBorder(new LineBorder(new Color(76,250,168), 45));
		lbl_selector_modificar.setBounds(0, 142, 77, 72);		
		Menus.setLayout(new BorderLayout(0, 0));
		Selector.add(lbl_selector_modificar);
		
		/**
		 * Menú Mostrar
		 * */
		btn_mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iUser.setVisible(false);
				mRegistrar.setVisible(false);
				mModificar.setVisible(false);
				mMostrar.setVisible(true);
				btn_info_usuario.setBackground(new Color(76,250,168));
				btn_cerrar.setBackground(new Color(76,250,168));
				btn_modificar.setBackground(new Color(76,250,168));
				btn_mostrar.setBackground(new Color(95,204,153));
				btn_registrar.setBackground(new Color(76,250,168));
				lbl_selector_info.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_cerrar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_modificar.setBorder(new LineBorder(new Color(76,250,168), 45));
				lbl_selector_mostrar.setBorder(new LineBorder(new Color(95,204,153), 45));
				lbl_selector_registrar.setBorder(new LineBorder(new Color(76,250,168), 45));
			}
		});
		btn_mostrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_mostrar.setBorder(null);
		btn_mostrar.setBackground(new Color(76,250,168));
		btn_mostrar.setBounds(14, 224, 49, 49);
		Icon icono_mostrar = iconos.icono("propension.png", 49, 49);
		btn_mostrar.setIcon(icono_mostrar);
		Selector.add(btn_mostrar);
		
		lbl_selector_mostrar.setBorder(new LineBorder(new Color(76,250,168), 45));
		lbl_selector_mostrar.setBounds(0, 213, 77, 72);		
		Menus.setLayout(new BorderLayout(0, 0));
		Selector.add(lbl_selector_mostrar);
		
		/**
		 * Botón Cerrar
		 * */		
		btn_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btn_cerrar.setBounds(14, 438, 49, 49);
		btn_cerrar.setBackground(new Color(76,250,168));
		btn_cerrar.setBorder(null);
		btn_cerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Icon icono_cerrar = iconos.icono("cerrar-sesion (1).png", 49, 49);
		btn_cerrar.setIcon(icono_cerrar);	
		Selector.add(btn_cerrar);
		
		lbl_selector_cerrar.setBorder(new LineBorder(new Color(76,250,168), 45));
		lbl_selector_cerrar.setBounds(0, 426, 77, 74);		
		Menus.setLayout(new BorderLayout(0, 0));
		Selector.add(lbl_selector_cerrar);
		
		/**
		 * Lugares sin botón
		 * */
		JLabel lbl_selector_nulo1= new JLabel("");
		lbl_selector_nulo1.setBorder(new LineBorder(new Color(76,250,168), 45));
		lbl_selector_nulo1.setBounds(0, 355, 77, 72);		
		Menus.setLayout(new BorderLayout(0, 0));
		Selector.add(lbl_selector_nulo1);
		
		JLabel lbl_selector_nulo2 = new JLabel("");
		lbl_selector_nulo2.setBorder(new LineBorder(new Color(76,250,168), 45));
		lbl_selector_nulo2.setBounds(0, 284, 77, 72);		
		Menus.setLayout(new BorderLayout(0, 0));
		Selector.add(lbl_selector_nulo2);
	}
}
