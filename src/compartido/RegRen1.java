package compartido;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.CbRellenar;
import clases.Conexion;
import clases.Decoracion;
import clases.Funcionalidades;
import clases.SentenciasSQL;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class RegRen1 extends JFrame
{	
	@SuppressWarnings("unchecked")
	public RegRen1()
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
		lbl_tit.setBounds(221, 75, 330, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom_art = new JLabel("NOMBRE DEL ART\u00CDCULO");
		lbl_nom_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom_art.setBounds(22, 131, 268, 28);
		getContentPane().add(lbl_nom_art);
		
		JLabel lbl_pre_ren = new JLabel("PRECIO DE LA RENTA");
		lbl_pre_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_ren.setBounds(22, 234, 240, 28);
		getContentPane().add(lbl_pre_ren);
		
		JLabel lbl_pre_man = new JLabel("CANTIDAD DISPONIBLE");
		lbl_pre_man.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_man.setBounds(22, 337, 260, 28);
		getContentPane().add(lbl_pre_man);
		
		JTextField txt_cnt_ren = new JTextField();
		txt_cnt_ren.setEditable(false);
		txt_cnt_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cnt_ren.setBackground(Color.WHITE);
		txt_cnt_ren.setForeground(Color.BLACK);
		txt_cnt_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cnt_ren.setColumns(10);
		txt_cnt_ren.setBounds(22, 365, 350, 28);
		getContentPane().add(txt_cnt_ren);
		
		JTextField txt_pre_ren = new JTextField();
		txt_pre_ren.setEditable(false);
		txt_pre_ren.setForeground(Color.BLACK);
		txt_pre_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_ren.setColumns(10);
		txt_pre_ren.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_ren.setBackground(Color.WHITE);
		txt_pre_ren.setBounds(22, 262, 350, 28);
		getContentPane().add(txt_pre_ren);
		
		JLabel lbl_fch_ent = new JLabel("FECHA DE SALIDA");
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
		
		JLabel lbl_fch_sal = new JLabel("FECHA DE RETORNO ESTIMADA");
		lbl_fch_sal.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_sal.setBounds(402, 234, 360, 28);
		getContentPane().add(lbl_fch_sal);
		
		@SuppressWarnings("rawtypes")
		JComboBox cb_art_ren = new JComboBox();
		cb_art_ren.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{		
				if(arg0.getStateChange() == ItemEvent.SELECTED)
				{
					CbRellenar sus = (CbRellenar) cb_art_ren.getSelectedItem();
					
					try 
					{
						Connection cn = Conexion.conectar();
						String sql = "select cnt_art, pre_art from articulos where cve_art = '" + sus.getId() +"'";
						PreparedStatement pst = cn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						
						while(rs.next()) 
						{
							txt_pre_ren.setText(rs.getString("pre_art"));
							txt_cnt_ren.setText(rs.getString("cnt_art"));
						}
						cn.close();
					} 
					catch (SQLException e) 
					{
						System.err.print("¡ERROR EN MOSTRAR ARTÍCULOS! " + e);
						JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR INFORMACIÓN! Contactar con el Supervisor.");
					}
				}
			}
		});
		cb_art_ren.setForeground(Color.BLACK);
		cb_art_ren.setFont(new Font("Roboto", Font.PLAIN, 24));
		cb_art_ren.setBackground(Color.WHITE);
		cb_art_ren.setBounds(22, 159, 350, 28);
		getContentPane().add(cb_art_ren);
		
		CbRellenar sc_ren = new CbRellenar();
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel mRentas = new DefaultComboBoxModel(
				sc_ren.mostrarCbox("select cve_art, nom_art from articulos where cnd_art = '3'", "Seleccionar Artículo", "cve_art", "nom_art"));
		cb_art_ren.setModel(mRentas);
		
		JButton btn_sig = new JButton("SIGUIENTE");
		btn_sig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CbRellenar index_ren = (CbRellenar) cb_art_ren.getSelectedItem();
				if (!new Funcionalidades().validadorAcep(txt_cnt_ren, txt_pre_ren, txt_dia_ent, txt_mes_ent, txt_anio_ent, txt_anio_sal, txt_mes_sal, txt_dia_sal, index_ren.getId()) && !txt_cnt_ren.getText().equals("0"))
				{
					String sal_ren = txt_anio_sal.getText() +"-"+ txt_mes_sal.getText() +"-"+ txt_dia_sal.getText();
					String ret_ren = txt_anio_ent.getText() +"-"+ txt_mes_ent.getText() +"-"+ txt_dia_ent.getText(); 
					
					int cnt_restante = Integer.parseInt(txt_cnt_ren.getText()) - 1;
					
					SentenciasSQL c = new SentenciasSQL();					
					String statement = "insert into rentas values (?,?,?,?,?,?,?)";
					String[] reg = {"0", index_ren.getId()+"", sal_ren, ret_ren, txt_pre_ren.getText(), "0.00", cnt_restante+""};
					int[] tipo = {1,1,2,2,3,3,1};
					c.createSQL(statement, reg, tipo);					
					
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
						
						cob_cor += Double.parseDouble(txt_pre_ren.getText());
						
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
					
					new RegRen2().setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "¡NO HAY SUFICIENTES ARTÍCULOS PARA LA RENTA!");
				}
			}
		});
		btn_sig.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_sig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sig.setForeground(Color.BLACK);
		btn_sig.setBackground(new Color(60,199,134));
		btn_sig.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_sig.setBounds(407, 415, 150, 50);
		getContentPane().add(btn_sig);
		
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
				switch (new Funcionalidades().validadorReg(txt_cnt_ren, txt_pre_ren, txt_dia_ent, txt_mes_ent, txt_anio_ent, txt_anio_sal, txt_mes_sal, txt_dia_sal))
				{
				case 0:
					dispose();
					break;
				case 3:
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
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
	}
}
