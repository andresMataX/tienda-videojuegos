package cajero;

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
public class SelecMosArtCajero extends JFrame
{
	static int cve_art;
	
	public SelecMosArtCajero()
	{
		Decoracion deco = new Decoracion();
		DefaultTableModel model = new DefaultTableModel();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Mostrar Artículos - |");
		
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
		
		JTable tb_art = new JTable();
		tb_art.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cve_art = new Funcionalidades().selecTabla(model, 0, tb_art, e);
				new MosArtCajero().setVisible(true);
				dispose();
			}
		});
		tb_art.setGridColor(new Color(95, 204, 153));
		tb_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_art.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tb_art.setBackground(new Color(95, 204, 153));
		tb_art.setForeground(Color.BLACK);
		tb_art.setFont(new Font("Roboto", Font.PLAIN, 16));
		tb_art.setModel(model);
		sc_prov.setViewportView(tb_art);
		
		JLabel lbl_tit = new JLabel("ART\u00CDCULOS");
		lbl_tit.setBounds(277, 75, 200, 45);
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
		
		JLabel lbl_nom_art = new JLabel("NOMBRE");
		lbl_nom_art.setBounds(131, 131, 201, 35);
		lbl_nom_art.setBackground(new Color(95, 204, 153));
		lbl_nom_art.setForeground(Color.BLACK);
		lbl_nom_art.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_nom_art.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nom_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_nom_art);
		
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
		
		JLabel lbl_prov_art = new JLabel("PROVEEDOR");
		lbl_prov_art.setBounds(332, 131, 193, 35);
		lbl_prov_art.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_prov_art.setForeground(Color.BLACK);
		lbl_prov_art.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_prov_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_prov_art.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_prov_art);
		
		JLabel lbl_cat_art = new JLabel("CATEGOR\u00CDA");
		lbl_cat_art.setBounds(525, 131, 159, 35);
		lbl_cat_art.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cat_art.setForeground(Color.BLACK);
		lbl_cat_art.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_cat_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_cat_art.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_cat_art);
		
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
			
			int ancho [] = {65, 201, 193, 159};
			
			for(int x = 0; x < 4; x++)
			{
				tb_art.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
			}
			
			Object dato[] = new Object[4];
			
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
				"select cve_art, nom_art, prov_art, cat_art from articulos");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				dato[0] = rs.getInt(1);
				dato[1] = rs.getString(2);
				dato[2] = rs.getInt(3);
				dato[3] = rs.getInt(4);
				model.addRow(dato);
			}
			cn.close();
		} 
		catch (SQLException err) 
		{
			System.err.println("¡ERROR EN LLENAR TABLA! " + err);
			JOptionPane.showMessageDialog(null, "¡ERROR AL MOSTRAR INFORMACIÓN! Contacta con el Administrador.");
		}
	}

}
