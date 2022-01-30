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
public class RegComProv extends JFrame
{
	@SuppressWarnings("unchecked")
	public RegComProv()
	{	
		Decoracion deco = new Decoracion();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Registrar compra - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("REGISTRAR COMPRA - PROVEEDOR");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(81, 75, 607, 45);
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
		
		JLabel lbl_fch_com = new JLabel("FECHA DE COMPRA");
		lbl_fch_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_fch_com.setBounds(23, 234, 220, 28);
		getContentPane().add(lbl_fch_com);
		
		JLabel lbl_pre_com = new JLabel("PRECIO DEL ART\u00CDCULO");
		lbl_pre_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre_com.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_pre_com);
		
		JLabel lbl_cat_com = new JLabel("CATEGOR\u00CDA DEL ART\u00CDCULO");
		lbl_cat_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cat_com.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_cat_com);
		
		JLabel lbl_prov_com = new JLabel("PROVEEDOR");
		lbl_prov_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_prov_com.setBounds(23, 323, 140, 28);
		getContentPane().add(lbl_prov_com);
		
		JTextField txt_nom_com = new JTextField();
		txt_nom_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_com.setBackground(Color.WHITE);
		txt_nom_com.setForeground(Color.BLACK);
		txt_nom_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_com.setBounds(23, 159, 350, 28);
		getContentPane().add(txt_nom_com);
		txt_nom_com.setColumns(10);
		
		JTextField txt_prov_com = new JTextField();
		txt_prov_com.setEditable(false);
		txt_prov_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_prov_com.setBackground(Color.WHITE);
		txt_prov_com.setForeground(Color.BLACK);
		txt_prov_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_prov_com.setColumns(10);
		txt_prov_com.setBounds(22, 351, 350, 28);
		txt_prov_com.setText(""+SelecRegProv.prov_selec);
		getContentPane().add(txt_prov_com);
		
		try 
		{
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
				"select nom_prov from proveedores where cve_prov = '" + SelecRegProv.prov_selec + "'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				txt_prov_com.setText(rs.getString("nom_prov"));
			}
			cn.close();			
		} 
		catch (SQLException err2) 
		{
			System.err.print("¡ERROR EN CARGAR PROVEDOR! " +err2);
			JOptionPane.showMessageDialog(null, "¡ERROR AL CARGAR! Contactar con el Desarrollador.");
		}
		
		JTextField txt_pre_com = new JTextField();
		txt_pre_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_com.setBackground(Color.WHITE);
		txt_pre_com.setForeground(Color.BLACK);
		txt_pre_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_com.setColumns(10);
		txt_pre_com.setBounds(395, 159, 350, 28);
		getContentPane().add(txt_pre_com);
		
		@SuppressWarnings("rawtypes")
		JComboBox cb_cat_com = new JComboBox();
		cb_cat_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		cb_cat_com.setBackground(Color.WHITE);
		cb_cat_com.setForeground(Color.BLACK);
		cb_cat_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		cb_cat_com.setBounds(395, 262, 350, 28);
		getContentPane().add(cb_cat_com);
		
		CbRellenar sc = new CbRellenar();
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel mCategoria = new DefaultComboBoxModel(
				sc.mostrarCbox("select cve_cat, nom_cat from categoria", "Seleccionar Categoría", "cve_cat", "nom_cat"));
		cb_cat_com.setModel(mCategoria);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecRegProv().setVisible(true);
				dispose();
			}
		});
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_cancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_cancelar.setBackground(new Color(73,122,100)); // COLOR 497A64
		btn_cancelar.setBounds(582, 415, 160, 50);
		getContentPane().add(btn_cancelar);
		
		JLabel lbl_dia = new JLabel("DIA");
		lbl_dia.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_dia.setBounds(23, 262, 40, 28);
		getContentPane().add(lbl_dia);
		
		JLabel lbl_mes = new JLabel("MES");
		lbl_mes.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_mes.setBounds(111, 262, 49, 28);
		getContentPane().add(lbl_mes);
		
		JLabel lbl_anio = new JLabel("A\u00D1O");
		lbl_anio.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_anio.setBounds(210, 262, 51, 28);
		getContentPane().add(lbl_anio);
		
		JTextField txt_dia_com = new JTextField();
		txt_dia_com.setHorizontalAlignment(SwingConstants.CENTER);
		txt_dia_com.setForeground(Color.BLACK);
		txt_dia_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_dia_com.setColumns(10);
		txt_dia_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_dia_com.setBackground(Color.WHITE);
		txt_dia_com.setBounds(66, 262, 40, 28);
		getContentPane().add(txt_dia_com);
		
		JTextField txt_mes_com = new JTextField();
		txt_mes_com.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mes_com.setForeground(Color.BLACK);
		txt_mes_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_mes_com.setColumns(10);
		txt_mes_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_mes_com.setBackground(Color.WHITE);
		txt_mes_com.setBounds(162, 262, 40, 28);
		getContentPane().add(txt_mes_com);
		
		JTextField txt_anio_com = new JTextField();
		txt_anio_com.setHorizontalAlignment(SwingConstants.CENTER);
		txt_anio_com.setForeground(Color.BLACK);
		txt_anio_com.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_anio_com.setColumns(10);
		txt_anio_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_anio_com.setBackground(Color.WHITE);
		txt_anio_com.setBounds(265, 262, 40, 28);
		getContentPane().add(txt_anio_com);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (new Funcionalidades().validadorReg(txt_nom_com, txt_pre_com, txt_dia_com, txt_mes_com, txt_anio_com))
				{
				case 0:
					new SelecRegProv().setVisible(true);
					dispose();
					break;
				case 3:
					new SelecRegProv().setVisible(true);
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
				CbRellenar index_cat = (CbRellenar) cb_cat_com.getSelectedItem();
				if (!new Funcionalidades().validadorAcep(txt_prov_com, txt_pre_com, txt_dia_com, txt_mes_com, txt_anio_com, index_cat.getId()))
				{			
					SentenciasSQL c = new SentenciasSQL();					
					String statement_com = "insert into compras values (?,?,?,?,?)";
					String[] reg_com = {"0", Login.cve_user+"", txt_pre_com.getText(), SelecRegProv.prov_selec+"", deco.fecha()};
					int[] tipo_com = {1,1,3,1,2};
					c.createSQL(statement_com, reg_com, tipo_com);	
					
					String statement_art = "insert into articulos values (?,?,?,?,?,?,?)";
					String[] reg_art = {"0", txt_nom_com.getText(), txt_pre_com.getText(), SelecRegProv.prov_selec+"", index_cat.getId()+"", "1", "1"};
					int[] tipo_art = {1,2,3,1,1,1,1};
					c.createSQL(statement_art, reg_art, tipo_art);
					
					int cve_com = c.cveDetalles("select max(cve_com) as cve_com from compras", "cve_com");
					int cve_art = c.cveDetalles("select max(cve_art) as cve_art from articulos", "cve_art");
					String statement_dcom = "insert into detalle_compras values (?,?,?)";
					String[] reg_dcom = {cve_com+"", cve_art+"", index_cat.getId()+""};
					int[] tipo_dcom = {1,1,1};
					c.createSQL(statement_dcom, reg_dcom, tipo_dcom);
					
					int cve_cor_act = c.cveDetalles("select max(cve_cor) as cve_cor from corte_caja", "cve_cor");
					double ret_cor = 0.00;
					try
					{
						Connection cn3 = Conexion.conectar();
						String sql3 = "select ret_cor from corte_caja where cve_cor = '"+ cve_cor_act+"'";
						PreparedStatement pst3 = cn3.prepareStatement(sql3);
						ResultSet rs3 = pst3.executeQuery();
						
						while(rs3.next()) 
						{
							ret_cor = rs3.getDouble("ret_cor");
						}
						
						ret_cor += Double.parseDouble(txt_pre_com.getText());
						
						String statement_cor = "update corte_caja set ret_cor = ? where cve_cor = '"+cve_cor_act+"'";
						String[] mod_cor = {ret_cor+""};
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
