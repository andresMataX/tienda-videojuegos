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
public class SelecMosUsrAdmin extends JFrame
{
	static int cve_usr;
	public SelecMosUsrAdmin()
	{
		Decoracion deco = new Decoracion();
		DefaultTableModel model = new DefaultTableModel();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Mostrar Usuarios - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		getContentPane().setLayout(null);
		
		JScrollPane sc_prov = new JScrollPane();
		sc_prov.setBounds(163, 166, 443, 250);
		sc_prov.setBorder(new LineBorder(new Color(130, 135, 144)));
		sc_prov.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sc_prov.setBackground(new Color(95, 204, 153));	
		getContentPane().add(sc_prov);
		
		JTable tb_usr = new JTable();
		tb_usr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cve_usr = new Funcionalidades().selecTabla(model, 0, tb_usr, e);
				new MosUsrAdmin().setVisible(true);
				dispose();
			}
		});
		tb_usr.setGridColor(new Color(95, 204, 153));
		tb_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_usr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tb_usr.setBackground(new Color(95, 204, 153));
		tb_usr.setForeground(Color.BLACK);
		tb_usr.setFont(new Font("Roboto", Font.PLAIN, 16));
		tb_usr.setModel(model);
		sc_prov.setViewportView(tb_usr);
		
		JLabel lbl_tit = new JLabel("USUARIOS");
		lbl_tit.setBounds(295, 75, 190, 45);
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_cve_prov = new JLabel("ID");
		lbl_cve_prov.setBounds(163, 131, 49, 35);
		lbl_cve_prov.setBackground(new Color(95, 204, 153));
		lbl_cve_prov.setForeground(Color.BLACK);
		lbl_cve_prov.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cve_prov.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_cve_prov.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_cve_prov);
		
		JLabel lbl_nom_usr = new JLabel("NOMBRE");
		lbl_nom_usr.setBounds(212, 131, 206, 35);
		lbl_nom_usr.setBackground(new Color(95, 204, 153));
		lbl_nom_usr.setForeground(Color.BLACK);
		lbl_nom_usr.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_nom_usr.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nom_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_nom_usr);
		
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
		
		JLabel lbl_usr_usr = new JLabel("USUARIO");
		lbl_usr_usr.setBounds(416, 131, 174, 35);
		lbl_usr_usr.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_usr_usr.setForeground(Color.BLACK);
		lbl_usr_usr.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_usr_usr.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_usr_usr.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_usr_usr);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBounds(10, 54, 748, 433);
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		getContentPane().add(lbl_margen);
		
		try 
		{	
			model.addColumn(" ");
			model.addColumn(" ");
			model.addColumn(" ");
			
			int ancho [] = {49, 206, 174};
			
			for(int x = 0; x < 3; x++)
			{
				tb_usr.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
			}
			
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
				"select cve_usr, nom_usr, usr_usr from usuarios");
			
			Object dato[] = new Object[3];
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				dato[0] = rs.getInt(1);				
				dato[1] = rs.getString(2);
				dato[2] = rs.getString(3);
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
