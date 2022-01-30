package compartido;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import clases.Conexion;
import clases.Decoracion;
import clases.Funcionalidades;
import clases.SentenciasSQL;

@SuppressWarnings("serial")
public class RegManCon extends JFrame
{
	public RegManCon()
	{
		Decoracion deco = new Decoracion();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Registrar Mantenimiento - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("MANTENIMIENTO CONSOLAS");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(22, 75, 515, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_fecha = new JLabel(deco.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom = new JLabel("NOMBRE DEL CLIENTE");
		lbl_nom.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom.setBounds(22, 131, 250, 28);
		getContentPane().add(lbl_nom);
		
		JLabel lbl_tel_man = new JLabel("TEL\u00C9FONO DEL CLIENTE");
		lbl_tel_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_tel_man.setBounds(22, 234, 270, 28);
		getContentPane().add(lbl_tel_man);
		
		JLabel lbl_pre_man = new JLabel("PRECIO ESTIMADO");
		lbl_pre_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_man.setBounds(22, 337, 210, 28);
		getContentPane().add(lbl_pre_man);
		
		JTextField txt_nom_man = new JTextField();
		txt_nom_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_man.setBackground(Color.WHITE);
		txt_nom_man.setForeground(Color.BLACK);
		txt_nom_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_man.setBounds(22, 159, 350, 28);
		getContentPane().add(txt_nom_man);
		txt_nom_man.setColumns(10);
		
		JTextField txt_pre_man = new JTextField();
		txt_pre_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_man.setBackground(Color.WHITE);
		txt_pre_man.setForeground(Color.BLACK);
		txt_pre_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_man.setColumns(10);
		txt_pre_man.setBounds(22, 365, 350, 28);
		getContentPane().add(txt_pre_man);
		
		JTextField txt_tel_man = new JTextField();
		txt_tel_man.setForeground(Color.BLACK);
		txt_tel_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_tel_man.setColumns(10);
		txt_tel_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_tel_man.setBackground(Color.WHITE);
		txt_tel_man.setBounds(22, 262, 350, 28);
		getContentPane().add(txt_tel_man);
		
		JLabel lbl_fch_ent = new JLabel("FECHA DE ENTRADA");
		lbl_fch_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_ent.setBounds(402, 131, 230, 28);
		getContentPane().add(lbl_fch_ent);
		
		JLabel lbl_dia_ent = new JLabel("DIA");
		lbl_dia_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_dia_ent.setBounds(402, 159, 40, 28);
		getContentPane().add(lbl_dia_ent);
		
		JTextField txt_dia_ent = new JTextField();
		txt_dia_ent.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia_ent.setForeground(Color.BLACK);
		txt_dia_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_dia_ent.setColumns(10);
		txt_dia_ent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_dia_ent.setBackground(Color.WHITE);
		txt_dia_ent.setBounds(445, 159, 40, 28);
		getContentPane().add(txt_dia_ent);
		
		JLabel lbl_mes_ent = new JLabel("MES");
		lbl_mes_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_mes_ent.setBounds(490, 159, 49, 28);
		getContentPane().add(lbl_mes_ent);
		
		JTextField txt_mes_ent = new JTextField();
		txt_mes_ent.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mes_ent.setForeground(Color.BLACK);
		txt_mes_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_mes_ent.setColumns(10);
		txt_mes_ent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_mes_ent.setBackground(Color.WHITE);
		txt_mes_ent.setBounds(541, 159, 40, 28);
		getContentPane().add(txt_mes_ent);
		
		JLabel lbl_anio_ent = new JLabel("A\u00D1O");
		lbl_anio_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_anio_ent.setBounds(589, 159, 51, 28);
		getContentPane().add(lbl_anio_ent);
		
		JTextField txt_anio_ent = new JTextField();
		txt_anio_ent.setHorizontalAlignment(SwingConstants.CENTER);
		txt_anio_ent.setForeground(Color.BLACK);
		txt_anio_ent.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_anio_ent.setColumns(10);
		txt_anio_ent.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_anio_ent.setBackground(Color.WHITE);
		txt_anio_ent.setBounds(644, 159, 40, 28);
		getContentPane().add(txt_anio_ent);
		
		JTextField txt_anio_sal = new JTextField();
		txt_anio_sal.setHorizontalAlignment(SwingConstants.CENTER);
		txt_anio_sal.setForeground(Color.BLACK);
		txt_anio_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_anio_sal.setColumns(10);
		txt_anio_sal.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_anio_sal.setBackground(Color.WHITE);
		txt_anio_sal.setBounds(644, 262, 40, 28);
		getContentPane().add(txt_anio_sal);
		
		JLabel lbl_anio_sal = new JLabel("A\u00D1O");
		lbl_anio_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_anio_sal.setBounds(589, 262, 51, 28);
		getContentPane().add(lbl_anio_sal);
		
		JTextField txt_mes_sal = new JTextField();
		txt_mes_sal.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mes_sal.setForeground(Color.BLACK);
		txt_mes_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_mes_sal.setColumns(10);
		txt_mes_sal.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_mes_sal.setBackground(Color.WHITE);
		txt_mes_sal.setBounds(541, 262, 40, 28);
		getContentPane().add(txt_mes_sal);
		
		JLabel lbl_mes_sal = new JLabel("MES");
		lbl_mes_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_mes_sal.setBounds(490, 262, 49, 28);
		getContentPane().add(lbl_mes_sal);
		
		JTextField txt_dia_sal = new JTextField();
		txt_dia_sal.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia_sal.setForeground(Color.BLACK);
		txt_dia_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_dia_sal.setColumns(10);
		txt_dia_sal.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_dia_sal.setBackground(Color.WHITE);
		txt_dia_sal.setBounds(445, 262, 40, 28);
		getContentPane().add(txt_dia_sal);
		
		JLabel lbl_dia_sal = new JLabel("DIA");
		lbl_dia_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_dia_sal.setBounds(402, 262, 40, 28);
		getContentPane().add(lbl_dia_sal);
		
		JLabel lbl_fch_sal = new JLabel("FECHA DE SALIDA ESTIMADA");
		lbl_fch_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_sal.setBounds(402, 234, 330, 28);
		getContentPane().add(lbl_fch_sal);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubMant().setVisible(true);
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
				switch (new Funcionalidades().validadorReg(txt_nom_man, txt_pre_man, txt_tel_man, txt_dia_ent, txt_mes_ent, txt_anio_ent, txt_anio_sal, txt_mes_sal, txt_dia_sal))
				{
				case 0:
					new SubMant().setVisible(true);
					dispose();
					break;
				case 3:
					new SubMant().setVisible(true);
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
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(txt_nom_man, txt_pre_man, txt_tel_man, txt_dia_ent, txt_mes_ent, txt_anio_ent, txt_anio_sal, txt_mes_sal, txt_dia_sal))
				{
					String ent_man = "20"+txt_anio_ent.getText()+"-"+txt_mes_ent.getText()+"-"+txt_dia_ent.getText();
					String sal_man = "20"+txt_anio_sal.getText()+"-"+txt_mes_sal.getText()+"-"+txt_dia_sal.getText();
					
					SentenciasSQL c = new SentenciasSQL();
					String statement_dcom = "insert into mantenimiento values (?,?,?,?,?,?,?)";
					String[] reg_dcom = {"0", "2", ent_man, sal_man, txt_pre_man.getText(), txt_nom_man.getText(), txt_tel_man.getText()};
					int[] tipo_dcom = {1,1,2,2,3,2,2};
					c.createSQL(statement_dcom, reg_dcom, tipo_dcom);
					
					int cve_cor_act = c.cveDetalles("select max(cve_cor) as cve_cor from corte_caja", "cve_cor");
					double cob_cor = 0.00;
					try
					{
						Connection cn3 = Conexion.conectar();
						String sql3 = "select cob_cor from corte_caja where cve_cor = '"+ cve_cor_act+"'";
						PreparedStatement pst3 = cn3.prepareStatement(sql3);
						ResultSet rs3 = pst3.executeQuery();
						
						while(rs3.next()) 
						{
							cob_cor = rs3.getDouble("cob_cor");
						}
						
						cob_cor += Double.parseDouble(txt_pre_man.getText());
						
						String statement_cor = "update corte_caja set cob_cor = ? where cve_cor = '"+cve_cor_act+"'";
						String[] mod_cor = {cob_cor+""};
						int[] tipo_cor = {3};
						c.updateSQL(statement_cor, mod_cor, tipo_cor);	
					} 
					catch (Exception e2)
					{
						System.err.print("¡ERROR EN CORTE DE CAJA! " + e2);
						JOptionPane.showMessageDialog(null, "¡ERROR EN CORTE DE CAJA! Contactar con el Desarrollador.");
					}
					
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
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
	}

}
