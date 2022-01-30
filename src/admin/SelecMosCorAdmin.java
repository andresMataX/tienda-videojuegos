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
public class SelecMosCorAdmin extends JFrame
{
	static int cve_cor;
	
	public SelecMosCorAdmin()
	{
		Decoracion deco = new Decoracion();
		DefaultTableModel model = new DefaultTableModel();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Mostrar Cortes de Caja - |");
		
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
		
		JTable tb_cor = new JTable();
		tb_cor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cve_cor = new Funcionalidades().selecTabla(model, 0, tb_cor, e);
				new MosCorAdmin().setVisible(true);
				dispose();
			}
		});
		tb_cor.setGridColor(new Color(95, 204, 153));
		tb_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_cor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tb_cor.setBackground(new Color(95, 204, 153));
		tb_cor.setForeground(Color.BLACK);
		tb_cor.setFont(new Font("Roboto", Font.PLAIN, 16));
		tb_cor.setModel(model);
		sc_prov.setViewportView(tb_cor);
		
		JLabel lbl_tit = new JLabel("SELECCIONAR - CORTES");
		lbl_tit.setBounds(179, 75, 420, 45);
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
		
		JLabel lbl_fal_cor = new JLabel("FALTANTE");
		lbl_fal_cor.setBounds(131, 131, 184, 35);
		lbl_fal_cor.setBackground(new Color(95, 204, 153));
		lbl_fal_cor.setForeground(Color.BLACK);
		lbl_fal_cor.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_fal_cor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fal_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(lbl_fal_cor);
		
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
				// Validador();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JLabel lbl_cie_cam = new JLabel("FECHA");
		lbl_cie_cam.setBounds(315, 131, 210, 35);
		lbl_cie_cam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cie_cam.setForeground(Color.BLACK);
		lbl_cie_cam.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_cie_cam.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_cie_cam.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_cie_cam);
		
		JLabel lbl_usr_cor = new JLabel("USUARIO");
		lbl_usr_cor.setBounds(525, 131, 159, 35);
		lbl_usr_cor.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_usr_cor.setForeground(Color.BLACK);
		lbl_usr_cor.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_usr_cor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_usr_cor.setBackground(new Color(95, 204, 153));
		getContentPane().add(lbl_usr_cor);
		
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
				tb_cor.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
			}
			
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
				"select cve_cor, fal_cor, cie_cor, usr_cor from corte_caja");
			
			Object dato[] = new Object[4];
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				dato[0] = rs.getInt(1);
				dato[1] = rs.getInt(2);
				dato[2] = rs.getString(3);
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
