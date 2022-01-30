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
import clases.Funcionalidades;
import clases.SentenciasSQL;
import compartido.Login;
import compartido.SelecRegProv;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegProvAdmin extends JFrame
{
	public RegProvAdmin()
	{		
		Decoracion deco = new Decoracion();
		
		getContentPane().setBackground(new Color(150,251,204));	
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);		
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("| - Registrar Proveedor - |");
		
		JLabel lbl_bvd = new JLabel("\u00A1HOLA "+ deco.Nombre(Login.user) +"!");
		lbl_bvd.setForeground(Color.BLACK);
		lbl_bvd.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_bvd.setBounds(11, 9, 316, 45);
		getContentPane().add(lbl_bvd);
		
		JLabel lbl_fch = new JLabel(deco.fecha());
		lbl_fch.setForeground(Color.BLACK);
		lbl_fch.setFont(new Font("Roboto", Font.BOLD, 30));
		lbl_fch.setBounds(585, 9, 174, 35);
		getContentPane().add(lbl_fch);
		
		JLabel lbl_tit = new JLabel("REGISTRAR PROVEEDOR");
		lbl_tit.setForeground(Color.BLACK);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(172, 75, 423, 45);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_exist_prov = new JLabel("NOMBRE DEL PROVEEDOR");
		lbl_exist_prov.setForeground(Color.BLACK);
		lbl_exist_prov.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_exist_prov.setBounds(234, 299, 293, 28);
		getContentPane().add(lbl_exist_prov);
		
		JLabel lbl_logo_prov = new JLabel("");
		lbl_logo_prov.setBounds(309, 134, 150, 150);
		Icon icono_prov = deco.icono("inventario (1).png", 150, 150);
		lbl_logo_prov.setIcon(icono_prov);
		getContentPane().add(lbl_logo_prov);
		
		JTextField txt_nom_prov = new JTextField();
		txt_nom_prov.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_prov.setBackground(Color.WHITE);
		txt_nom_prov.setForeground(Color.BLACK);
		txt_nom_prov.setBounds(209, 327, 350, 28);
		getContentPane().add(txt_nom_prov);
		txt_nom_prov.setColumns(10);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(txt_nom_prov))
				{
					SentenciasSQL c = new SentenciasSQL();					
					String statement_com = "insert into proveedores values (?,?)";
					String[] reg_com = {"0", txt_nom_prov.getText()};
					int[] tipo_com = {1,2};
					c.createSQL(statement_com, reg_com, tipo_com);
					
					new SelecRegProv().setVisible(true);
					dispose();
				} 
			}
		});
		btn_aceptar.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_aceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_aceptar.setForeground(Color.BLACK);
		btn_aceptar.setBackground(new Color(60,199,134));
		btn_aceptar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_aceptar.setBounds(407, 415, 150, 50);
		getContentPane().add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubProvAdmin().setVisible(true);
				dispose();
			}
		});
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_cancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_cancelar.setBackground(new Color(73,122,100)); // COLOR 497A64
		btn_cancelar.setBounds(582, 415, 160, 50);
		getContentPane().add(btn_cancelar);
		
		JButton btn_reg = new JButton("");
		btn_reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (new Funcionalidades().validadorReg(txt_nom_prov))
				{
				case 0:
					new SubProvAdmin().setVisible(true);
					dispose();
					break;
				case 3:
					new SubProvAdmin().setVisible(true);
					dispose();
					break;
				}
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
