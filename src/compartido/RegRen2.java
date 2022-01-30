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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import clases.Decoracion;
import clases.Funcionalidades;
import clases.SentenciasSQL;

@SuppressWarnings("serial")
public class RegRen2 extends JFrame
{
	public RegRen2()
	{	
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Registrar Renta - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("REGISTRAR RENTA");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(217, 75, 330, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom_ren = new JLabel("NOMBRE DEL CLIENTE");
		lbl_nom_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom_ren.setBounds(23, 131, 270, 28);
		getContentPane().add(lbl_nom_ren);
		
		JLabel lbl_col_ren = new JLabel("COLONIA DEL CLIENTE");
		lbl_col_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_col_ren.setBounds(23, 234, 260, 28);
		getContentPane().add(lbl_col_ren);
		
		JLabel lbl_call_ren = new JLabel("CALLE DEL CLIENTE");
		lbl_call_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_call_ren.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_call_ren);
		
		JLabel lbl_tel_ren = new JLabel("TEL\u00C9FONO DEL CLIENTE");
		lbl_tel_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_tel_ren.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_tel_ren);
		
		JTextField txt_nom_ren = new JTextField();
		txt_nom_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_ren.setBackground(Color.WHITE);
		txt_nom_ren.setForeground(Color.BLACK);
		txt_nom_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_ren.setColumns(10);
		txt_nom_ren.setBounds(22, 159, 350, 28);
		getContentPane().add(txt_nom_ren);
		
		JTextField txt_call_ren = new JTextField();
		txt_call_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_call_ren.setBackground(Color.WHITE);
		txt_call_ren.setForeground(Color.BLACK);
		txt_call_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_call_ren.setColumns(10);
		txt_call_ren.setBounds(395, 159, 350, 28);
		getContentPane().add(txt_call_ren);
		
		JTextField txt_col_ren = new JTextField();
		txt_col_ren.setForeground(Color.BLACK);
		txt_col_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_col_ren.setColumns(10);
		txt_col_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_col_ren.setBackground(Color.WHITE);
		txt_col_ren.setBounds(23, 262, 350, 28);
		getContentPane().add(txt_col_ren);
		
		JTextField txt_tel_ren = new JTextField();
		txt_tel_ren.setForeground(Color.BLACK);
		txt_tel_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_tel_ren.setColumns(10);
		txt_tel_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_tel_ren.setBackground(Color.WHITE);
		txt_tel_ren.setBounds(396, 262, 350, 28);
		getContentPane().add(txt_tel_ren);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(txt_nom_ren, txt_call_ren, txt_col_ren, txt_tel_ren))
				{
					SentenciasSQL c = new SentenciasSQL();
					int cve_ren = c.cveDetalles("select max(cve_ren) as cve_ren from rentas", "cve_ren");
					String statement = "insert into detalle_rentas values (?,?,?,?,?)";
					String[] reg = {cve_ren+"", txt_nom_ren.getText(), txt_call_ren.getText(), txt_col_ren.getText(), txt_tel_ren.getText()};
					int[] tipo = {1,2,2,2,2};
					c.createSQL(statement, reg, tipo);
					
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
				dispose();
			}
		});
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_cancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_cancelar.setBackground(new Color(73,122,100)); // COLOR 497A64
		btn_cancelar.setBounds(582, 415, 160, 50);
		getContentPane().add(btn_cancelar);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (new Funcionalidades().validadorReg(txt_nom_ren, txt_call_ren, txt_col_ren, txt_tel_ren))
				{
				case 0:
					new RegRen1().setVisible(true);
					dispose();
					break;
				case 3:
					new RegRen1().setVisible(true);
					dispose();
					break;
				}
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JLabel lbl_mgn = new JLabel("");
		lbl_mgn.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_mgn.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_mgn);
	}
}
