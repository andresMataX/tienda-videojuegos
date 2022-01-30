package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.Conexion;
import clases.Decoracion;
import clases.Funcionalidades;
import compartido.Login;

@SuppressWarnings("serial")
public class SelecRegCamAdmin extends JFrame
{
	static int cve_cam;
	
	public SelecRegCamAdmin()
	{
		Decoracion deco = new Decoracion();
		DefaultTableModel model = new DefaultTableModel();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		setLocationRelativeTo(null);
		setResizable(false);		
		setTitle("| - Registrar Cambio - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		getContentPane().setLayout(null);
		
		JScrollPane sc_prov = new JScrollPane();
		sc_prov.setBounds(66, 166, 637, 250);
		sc_prov.setBorder(new LineBorder(new Color(130, 135, 144)));
		sc_prov.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sc_prov.setBackground(new Color(95, 204, 153));	
		getContentPane().add(sc_prov);
		
		JLabel lbl_tit = new JLabel("SELECCIONAR ART\u00CDCULO A CAMBIAR");
		lbl_tit.setBounds(64, 75, 645, 45);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_cve_prov = new JLabel("ID");
		lbl_cve_prov.setBounds(66, 131, 65, 35);
		lbl_cve_prov.setBackground(new Color(95, 204, 153));
		lbl_cve_prov.setForeground(Color.BLACK);
		lbl_cve_prov.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cve_prov.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_cve_prov.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_cve_prov);
		
		JLabel lbl_art_cam = new JLabel("FECHA");
		lbl_art_cam.setBounds(131, 131, 184, 35);
		lbl_art_cam.setBackground(new Color(95, 204, 153));
		lbl_art_cam.setForeground(Color.BLACK);
		lbl_art_cam.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_art_cam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_art_cam.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_art_cam);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setBounds(565, 9, 193, 35);
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		getContentPane().add(lbl_fecha);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JLabel lbl_fch_cam = new JLabel("ART\u00CDCULO");
		lbl_fch_cam.setBounds(315, 131, 210, 35);
		lbl_fch_cam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fch_cam.setForeground(Color.BLACK);
		lbl_fch_cam.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_fch_cam.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_fch_cam.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_fch_cam);
		
		JLabel lbl_cat_cam = new JLabel("CATEGOR\u00CDA");
		lbl_cat_cam.setBounds(525, 131, 159, 35);
		lbl_cat_cam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cat_cam.setForeground(Color.BLACK);
		lbl_cat_cam.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_cat_cam.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_cat_cam.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_cat_cam);
		
		JTable tb_cam = new JTable();
		tb_cam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cve_cam = new Funcionalidades().selecTabla(model, 0, tb_cam, e);
				new RegCamAdmin().setVisible(true);
				dispose();
			}
		});	
		tb_cam.setGridColor(new Color(95, 204, 153));
		tb_cam.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_cam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tb_cam.setBackground(new Color(95, 204, 153));
		tb_cam.setForeground(Color.BLACK);
		tb_cam.setFont(new Font("Roboto", Font.PLAIN, 16));
		tb_cam.setModel(model);
		sc_prov.setViewportView(tb_cam);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBounds(10, 54, 748, 433);
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		getContentPane().add(lbl_margen);
		
		try 
		{	
			model.addColumn(" ");
			model.addColumn(" ");
			model.addColumn(" ");
			model.addColumn(" ");
			
			int ancho [] = {65, 184, 210, 159};
			
			for(int x = 0; x < 4; x++)
			{
				tb_cam.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
			}
			
			Object dato[] = new Object[4];			
			
			Connection cn_ven = Conexion.conectar();
			PreparedStatement pst_ven = cn_ven.prepareStatement(
				"select cve_ven, fec_ven from ventas");
			
			ResultSet rs_ven = pst_ven.executeQuery();
			
			while(rs_ven.next())
			{
				dato[0] = rs_ven.getInt(1);
				dato[1] = rs_ven.getString(2);
			}	
			
			Connection cn_d_ventas = Conexion.conectar();
			PreparedStatement pst_d_ventas = cn_d_ventas.prepareStatement(
				"select art_ven from detalle_ventas");
			
			ResultSet rs_d_ven = pst_d_ventas.executeQuery();
			
			while(rs_d_ven.next())
			{
				dato[2] = rs_d_ven.getString(1);
				model.addRow(dato);
			}
		} 
		catch (SQLException err) 
		{
			System.err.println("¡ERROR EN LLENAR TABLA! " + err);
			JOptionPane.showMessageDialog(null, "¡ERROR AL MOSTRAR INFORMACIÓN! Contacta con el Administrador.");
		}
	}
}
