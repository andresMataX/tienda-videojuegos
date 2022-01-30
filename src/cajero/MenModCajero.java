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
import javax.swing.border.LineBorder;

import clases.Decoracion;
import compartido.Login;

@SuppressWarnings("serial")
public class MenModCajero extends JPanel
{
	public MenModCajero()
	{
		Decoracion deco = new Decoracion();
		
		setBackground(new Color(150,251,204));	
		setLayout(null);
		setBounds(0, 0, 785, 540);		
		
		JLabel lbl_bvd = new JLabel("\u00A1HOLA "+ deco.Nombre(Login.user) +"!");
		lbl_bvd.setForeground(Color.BLACK);
		lbl_bvd.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_bvd.setBounds(11, 9, 316, 45);
		add(lbl_bvd);
		
		JLabel lbl_fch = new JLabel(deco.fecha());
		lbl_fch.setForeground(Color.BLACK);
		lbl_fch.setFont(new Font("Roboto", Font.BOLD, 30));
		lbl_fch.setBounds(585, 9, 174, 35);
		add(lbl_fch);
		
		JLabel lbl_tit = new JLabel("MODIFICAR");
		lbl_tit.setForeground(Color.BLACK);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(287, 75, 200, 45);
		add(lbl_tit);
		
		JLabel lbl_man = new JLabel("MANTENIMIENTO");
		lbl_man.setForeground(Color.BLACK);
		lbl_man.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_man.setBounds(92, 308, 230, 33);
		add(lbl_man);
		
		JLabel lbl_ren = new JLabel("RENTAS");
		lbl_ren.setForeground(Color.BLACK);
		lbl_ren.setFont(new Font("Roboto", Font.PLAIN, 28));
		lbl_ren.setBounds(515, 308, 105, 33);
		add(lbl_ren);
		
		JButton btn_man = new JButton("");
		btn_man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecModManCajero().setVisible(true);
			}
		});
		btn_man.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_man.setBackground(new Color(150, 251, 204));
		btn_man.setBorder(null);
		btn_man.setBounds(128, 158, 150, 150);
		Icon icono_man = deco.icono("mantenimiento.png", 150, 150);
		btn_man.setIcon(icono_man);
		add(btn_man);
		
		JButton btn_ren = new JButton("");
		btn_ren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecModRenCajero().setVisible(true);
			}
		});
		btn_ren.setBorder(null);
		btn_ren.setBackground(new Color(150, 251, 204));
		btn_ren.setBounds(491, 158, 150, 150);
		Icon icono_ren = deco.icono("contactos.png", 150, 150);
		btn_ren.setIcon(icono_ren);
		add(btn_ren);		
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		add(lbl_margen);
	}

}
