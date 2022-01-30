package admin;

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
import compartido.Login;

@SuppressWarnings("serial")
public class ModArtAdmin extends JFrame
{
	@SuppressWarnings("unchecked")
	public ModArtAdmin()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Modificar Artículo - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_titulo = new JLabel("MODIFICAR ART\u00CDCULO");
		lbl_titulo.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_titulo.setBounds(193, 75, 386, 45);
		lbl_titulo.setForeground(Color.BLACK);
		getContentPane().add(lbl_titulo);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_nom = new JLabel("NOMBRE DEL ART\u00CDCULO");
		lbl_nom.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_nom.setBounds(22, 131, 270, 28);
		getContentPane().add(lbl_nom);
		
		JLabel lbl_prov = new JLabel("PROVEEDOR DEL ART\u00CDCULO");
		lbl_prov.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_prov.setBounds(22, 234, 310, 28);
		getContentPane().add(lbl_prov);
		
		JLabel lbl_pre = new JLabel("PRECIO DEL ART\u00CDCULO");
		lbl_pre.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_pre.setBounds(395, 131, 255, 28);
		getContentPane().add(lbl_pre);
		
		JLabel lbl_cat = new JLabel("CATEGOR\u00CDA DEL ART\u00CDCULO");
		lbl_cat.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cat.setBounds(395, 234, 300, 28);
		getContentPane().add(lbl_cat);
		
		JLabel lbl_cant = new JLabel("CANTIDAD DEL ART\u00CDCULO");
		lbl_cant.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cant.setBounds(22, 337, 288, 28);
		getContentPane().add(lbl_cant);
		
		JLabel lbl_cond = new JLabel("CONDICI\u00D3N DEL ART\u00CDCULO");
		lbl_cond.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cond.setBounds(395, 337, 300, 28);
		getContentPane().add(lbl_cond);
		
		JTextField txt_nom_art = new JTextField();
		txt_nom_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_nom_art.setBackground(Color.WHITE);
		txt_nom_art.setForeground(Color.BLACK);
		txt_nom_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_nom_art.setBounds(22, 159, 350, 28);
		getContentPane().add(txt_nom_art);
		txt_nom_art.setColumns(10);
		
		JTextField txt_cnt_art = new JTextField();
		txt_cnt_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_cnt_art.setBackground(Color.WHITE);
		txt_cnt_art.setForeground(Color.BLACK);
		txt_cnt_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_cnt_art.setColumns(10);
		txt_cnt_art.setBounds(22, 365, 350, 28);
		getContentPane().add(txt_cnt_art);
		
		JTextField txt_pre_art = new JTextField();
		txt_pre_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_pre_art.setBackground(Color.WHITE);
		txt_pre_art.setForeground(Color.BLACK);
		txt_pre_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_pre_art.setColumns(10);
		txt_pre_art.setBounds(395, 159, 350, 28);
		getContentPane().add(txt_pre_art);
		
		@SuppressWarnings("rawtypes")
		JComboBox cbox_prov_art = new JComboBox();
		cbox_prov_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		cbox_prov_art.setBackground(Color.WHITE);
		cbox_prov_art.setForeground(Color.BLACK);
		cbox_prov_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		cbox_prov_art.setBounds(22, 262, 350, 28);
		getContentPane().add(cbox_prov_art);
		
		CbRellenar sc_prov = new CbRellenar();
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel mProveedor = new DefaultComboBoxModel(
				sc_prov.mostrarCbox("select * from proveedores", "Seleccionar Proveedor", "cve_prov", "nom_prov"));
		cbox_prov_art.setModel(mProveedor);
		cbox_prov_art.setSelectedIndex(SelecModArtAdmin.cve_prov);
		
		
		@SuppressWarnings("rawtypes")
		JComboBox cbox_cat_art = new JComboBox();
		cbox_cat_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		cbox_cat_art.setBackground(Color.WHITE);
		cbox_cat_art.setForeground(Color.BLACK);
		cbox_cat_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		cbox_cat_art.setBounds(395, 262, 350, 28);
		getContentPane().add(cbox_cat_art);
		
		CbRellenar sc_cat = new CbRellenar();
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel mCategoria = new DefaultComboBoxModel(
				sc_cat.mostrarCbox("select cve_cat, nom_cat from categoria", "Seleccionar Categoría", "cve_cat", "nom_cat"));
		cbox_cat_art.setModel(mCategoria);
		cbox_cat_art.setSelectedIndex(SelecModArtAdmin.cve_cat);
		
		@SuppressWarnings("rawtypes")
		JComboBox cbox_cnd_art = new JComboBox();
		cbox_cnd_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		cbox_cnd_art.setBackground(Color.WHITE);
		cbox_cnd_art.setForeground(Color.BLACK);
		cbox_cnd_art.setFont(new Font("Roboto", Font.PLAIN, 24));
		cbox_cnd_art.setBounds(395, 365, 350, 28);
		getContentPane().add(cbox_cnd_art);
		
		CbRellenar sc_cnd = new CbRellenar();
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel mCondicion = new DefaultComboBoxModel(
				sc_cnd.mostrarCbox("select cve_cnd, nom_cnd from condicion", "Seleccionar Condicion", "cve_cnd", "nom_cnd"));
		cbox_cnd_art.setModel(mCondicion);
		
		try 
		{
			Connection cn = Conexion.conectar();
			String sql = "select cve_art, cnd_art from articulos where cve_art = " + SelecModArtAdmin.cve_art;
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				cbox_cnd_art.setSelectedIndex(rs.getInt("cnd_art"));
				
			}
			cn.close();
		} 
		catch (SQLException e) 
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CbRellenar index_cat = (CbRellenar) cbox_cat_art.getSelectedItem();
				CbRellenar index_cnd = (CbRellenar) cbox_cnd_art.getSelectedItem();
				CbRellenar index_prov = (CbRellenar) cbox_prov_art.getSelectedItem();
				if(!new Funcionalidades().validadorAcep(txt_nom_art, txt_cnt_art, txt_pre_art, index_cat.getId(), index_cnd.getId(), index_prov.getId()))
				{
					SentenciasSQL c = new SentenciasSQL();					
					String statement_com = "update articulos set nom_art = ?, pre_art = ?, prov_art = ?, cat_art = ?, cnd_art = ?, cnt_art = ? where cve_art = " + SelecModArtAdmin.cve_art;
					String[] reg_com = {txt_nom_art.getText(), txt_pre_art.getText(), index_prov.getId()+"", index_cat.getId()+"", index_cnd.getId()+"", txt_cnt_art.getText()};
					int[] tipo_com = {2,3,1,1,1,1};
					c.createSQL(statement_com, reg_com, tipo_com);
					
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
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_cancelar.setForeground(Color.WHITE);
		btn_cancelar.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_cancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cancelar.setBackground(new Color(73,122,100)); // COLOR 497A64
		btn_cancelar.setBounds(582, 415, 160, 50);
		getContentPane().add(btn_cancelar);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelecModArtAdmin().setVisible(true);
				dispose();
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
		
		try
		{
			Connection cn = Conexion.conectar();
			String sql = "select nom_art, pre_art, cnt_art from articulos where cve_art = '"+ SelecModArtAdmin.cve_art +"'";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				txt_cnt_art.setText(rs.getString("cnt_art"));
				txt_nom_art.setText(rs.getString("nom_art"));
				txt_pre_art.setText(rs.getString("pre_art"));
			}
			cn.close();
		} 
		catch (Exception e)
		{
			System.err.print("¡ERROR EN MOSTRAR SUCURSAL! " + e);
			JOptionPane.showMessageDialog(null, "¡ERROR EN MOSTRAR SUCURSAL! Contactar con el Supervisor.");
		}
	}

}
