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
public class SelecModManCajero extends JFrame
{
	static int cve_man;
	
	public SelecModManCajero()
	{
		Decoracion deco = new Decoracion();
		DefaultTableModel model = new DefaultTableModel();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("| - Modificar Mantenimiento - |");
		
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
		
		JTable tb_man = new JTable();
		tb_man.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cve_man = new Funcionalidades().selecTabla(model, 0, tb_man, e);
				new ModManCajero().setVisible(true);
				dispose();
			}
		});
		tb_man.setGridColor(new Color(95, 204, 153));
		tb_man.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_man.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tb_man.setBackground(new Color(95, 204, 153));
		tb_man.setForeground(Color.BLACK);
		tb_man.setFont(new Font("Roboto", Font.PLAIN, 16));
		tb_man.setModel(model);
		sc_prov.setViewportView(tb_man);
		
		JLabel lbl_tit = new JLabel("MANTENIMIENTO");
		lbl_tit.setBounds(233, 75, 310, 45);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_cve_prov = new JLabel("ID");
		lbl_cve_prov.setBounds(66, 131, 55, 35);
		lbl_cve_prov.setBackground(new Color(95, 204, 153));
		lbl_cve_prov.setForeground(Color.BLACK);
		lbl_cve_prov.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cve_prov.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_cve_prov.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_cve_prov);
		
		JLabel lbl_art_com = new JLabel("CATEGOR\u00CDA");
		lbl_art_com.setBounds(121, 131, 162, 35);
		lbl_art_com.setBackground(new Color(95, 204, 153));
		lbl_art_com.setForeground(Color.BLACK);
		lbl_art_com.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_art_com.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_art_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_art_com);
		
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
		
		JLabel lbl_prov_art = new JLabel("F. ENTRADA");
		lbl_prov_art.setBounds(282, 131, 201, 35);
		lbl_prov_art.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_prov_art.setForeground(Color.BLACK);
		lbl_prov_art.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_prov_art.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_prov_art.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_prov_art);
		
		JLabel lbl_fch_com = new JLabel("F. SALIDA");
		lbl_fch_com.setBounds(483, 131, 201, 35);
		lbl_fch_com.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fch_com.setForeground(Color.BLACK);
		lbl_fch_com.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_fch_com.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_fch_com.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_fch_com);
		
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
			
			int ancho [] = {55, 161, 201, 201};
			
			for(int x = 0; x < 4; x++)
			{
				tb_man.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
			}
			
			Object dato[] = new Object[4];
			
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
				"select cve_man, cat_man, ent_man, sal_man from mantenimiento");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				dato[0] = rs.getInt(1);
				dato[1] = rs.getString(2);
				dato[2] = rs.getString(3);
				dato[3] = rs.getString(4);
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
