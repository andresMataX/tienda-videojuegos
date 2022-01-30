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
import javax.swing.JComboBox;
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

@SuppressWarnings("serial")
public class RegVen extends JFrame
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegVen()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Registrar Venta - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("REGISTRAR VENTA");
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
		
		JLabel lbl_nom_com = new JLabel("NOMBRE DEL ART\u00CDCULO");
		lbl_nom_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom_com.setBounds(23, 131, 270, 28);
		getContentPane().add(lbl_nom_com);
		
		JLabel lbl_fch_ven = new JLabel("FECHA");
		lbl_fch_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_ven.setBounds(23, 234, 80, 28);
		getContentPane().add(lbl_fch_ven);
		
		JLabel lbl_pre_com = new JLabel("PRECIO DEL ART\u00CDCULO");
		lbl_pre_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_com.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_pre_com);
		
		JLabel lbl_cat_com = new JLabel("CATEGOR\u00CDA DEL ART\u00CDCULO");
		lbl_cat_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cat_com.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_cat_com);
		
		JLabel lbl_cnt_com = new JLabel("CANTIDAD DEL ART\u00CDCULO");
		lbl_cnt_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cnt_com.setBounds(23, 337, 290, 28);
		getContentPane().add(lbl_cnt_com);
		
		JTextField txt_cnt_art = new JTextField();
		txt_cnt_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cnt_art.setBackground(Color.WHITE);
		txt_cnt_art.setForeground(Color.BLACK);
		txt_cnt_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cnt_art.setColumns(10);
		txt_cnt_art.setBounds(22, 365, 350, 28);
		getContentPane().add(txt_cnt_art);
		
		JTextField txt_pre_ven = new JTextField();
		txt_pre_ven.setEditable(false);
		txt_pre_ven.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_ven.setBackground(Color.WHITE);
		txt_pre_ven.setForeground(Color.BLACK);
		txt_pre_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_ven.setColumns(10);
		txt_pre_ven.setBounds(395, 159, 350, 28);
		getContentPane().add(txt_pre_ven);
		
		JTextField txt_fec_ven = new JTextField();
		txt_fec_ven.setEditable(false);
		txt_fec_ven.setForeground(Color.BLACK);
		txt_fec_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_fec_ven.setColumns(10);
		txt_fec_ven.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_fec_ven.setBackground(Color.WHITE);
		txt_fec_ven.setBounds(23, 262, 350, 28);
		txt_fec_ven.setText(fecha.fecha());
		getContentPane().add(txt_fec_ven);
		
		JTextField txt_cat_ven = new JTextField();
		txt_cat_ven.setEditable(false);
		txt_cat_ven.setForeground(Color.BLACK);
		txt_cat_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cat_ven.setColumns(10);
		txt_cat_ven.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cat_ven.setBackground(Color.WHITE);
		txt_cat_ven.setBounds(396, 262, 350, 28);
		getContentPane().add(txt_cat_ven);
		
		JComboBox cb_art_ven = new JComboBox();
		cb_art_ven.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{		
				if(arg0.getStateChange() == ItemEvent.SELECTED)
				{
					CbRellenar sus = (CbRellenar) cb_art_ven.getSelectedItem();
					
					try 
					{
						Connection cn = Conexion.conectar();
						String sql = "select pre_art, cat_art from articulos where cve_art = " + sus.getId();
						PreparedStatement pst = cn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						
						while(rs.next()) 
						{
							//envio = rs2.getString("costo_envio");
							txt_pre_ven.setText(rs.getString("pre_art"));
							txt_cat_ven.setText(rs.getString("cat_art"));
						}
						cn.close();
					} 
					catch (SQLException e) 
					{
						System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
						JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
					}
				}
			}
		});
		cb_art_ven.setFont(new Font("Roboto", Font.PLAIN, 24));
		cb_art_ven.setForeground(Color.BLACK);
		cb_art_ven.setBackground(Color.WHITE);
		cb_art_ven.setBounds(23, 159, 350, 28);
		getContentPane().add(cb_art_ven);
		
		CbRellenar sc_art = new CbRellenar();
		DefaultComboBoxModel mArticulos = new DefaultComboBoxModel(
				sc_art.mostrarCbox("select cve_art, nom_art, cnd_art from articulos where cnd_art != '3'", "Seleccionar Artículo", "cve_art", "nom_art"));
		cb_art_ven.setModel(mArticulos);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CbRellenar index_art = (CbRellenar) cb_art_ven.getSelectedItem();
				if (!new Funcionalidades().validadorAcep(txt_cnt_art, txt_pre_ven, txt_fec_ven, txt_cat_ven, index_art.getId()))
				{
					SentenciasSQL c = new SentenciasSQL();
					String statement = "insert into ventas values (?,?,?,?)";
					String[] reg = {"0", Login.cve_user+"", txt_pre_ven.getText(), deco.fecha()};
					int[] tipo = {1,1,3,2};
					c.createSQL(statement, reg, tipo);
					
					
					int cve_ven = c.cveDetalles("select max(cve_ven) as cve_ven from ventas", "cve_ven");					
					String statement_2 = "insert into detalle_ventas values (?,?,?)";
					String[] reg_2 = {cve_ven+"", index_art.getId()+"", txt_cnt_art.getText()};
					int[] tipo_2 = {1,1,1};
					c.createSQL(statement_2, reg_2, tipo_2);
					
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
						
						cob_cor += Double.parseDouble(txt_pre_ven.getText());
						
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
				switch (new Funcionalidades().validadorReg(txt_cnt_art))
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
		
		JLabel lbl_mgn = new JLabel("");
		lbl_mgn.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_mgn.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_mgn);
	}
}
