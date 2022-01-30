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
import clases.SentenciasSQL;
import compartido.Login;

@SuppressWarnings("serial")
public class EliProvAdmin extends JFrame
{
	public EliProvAdmin()
	{
		Decoracion deco = new Decoracion();
		DefaultTableModel model = new DefaultTableModel();
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("| - Eliminar Usuario - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("ELIMINAR - PROVEEDORES");
		lbl_tit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(155, 75, 460, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		JLabel lbl_cve_prov = new JLabel("ID");
		lbl_cve_prov.setBackground(new Color(95, 204, 153));
		lbl_cve_prov.setForeground(Color.BLACK);
		lbl_cve_prov.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cve_prov.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_cve_prov.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_cve_prov.setBounds(106, 137, 47, 35);
		getContentPane().add(lbl_cve_prov);
		
		JLabel lbl_nom_prov = new JLabel("NOMBRE DEL PROVEEDOR");
		lbl_nom_prov.setBackground(new Color(95, 204, 153));
		lbl_nom_prov.setForeground(Color.BLACK);
		lbl_nom_prov.setFont(new Font("Roboto", Font.BOLD, 28));
		lbl_nom_prov.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_nom_prov.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_nom_prov.setBounds(152, 137, 493, 35);
		getContentPane().add(lbl_nom_prov);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JButton btn_regresar = new JButton("");
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_regresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_regresar.setBounds(22, 425, 49, 49);
		btn_regresar.setBackground(new Color(150,251,204));
		Icon icono_mostrar = deco.icono("regreso.png", 49, 49);
		btn_regresar.setIcon(icono_mostrar);
		getContentPane().add(btn_regresar);
		
		JScrollPane sc_prov = new JScrollPane();
		sc_prov.setBorder(new LineBorder(new Color(130, 135, 144)));
		sc_prov.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sc_prov.setBounds(106, 172, 557, 272);
		sc_prov.setBackground(new Color(95, 204, 153));
		getContentPane().add(sc_prov);
		
		JTable tb_prov = new JTable();
		tb_prov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cve_prov = new Funcionalidades().selecTabla(model, 0, tb_prov, e);
				int seleccion = JOptionPane.showConfirmDialog(null, "�Est�s seguro de eliminar " + cve_prov + "?", "Confirmar Eliminar Art�culo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (seleccion == 0)
				{
					SentenciasSQL eli = new SentenciasSQL();
					eli.deleteSQL("delete from proveedores where cve_prov = '" + cve_prov + "'");
					model.setRowCount(0);
					mostrarTabla(model, tb_prov);
				}
			}
		});
		tb_prov.setGridColor(new Color(95, 204, 153));
		tb_prov.setBorder(new LineBorder(new Color(0, 0, 0)));
		tb_prov.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tb_prov.setBackground(new Color(95, 204, 153));
		tb_prov.setForeground(Color.BLACK);
		tb_prov.setFont(new Font("Roboto", Font.PLAIN, 16));
		model.addColumn(" ");
		model.addColumn(" ");
		tb_prov.setModel(model);
		mostrarTabla(model, tb_prov);
		sc_prov.setViewportView(tb_prov);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
	}
	
	private void mostrarTabla(DefaultTableModel model, JTable tb_usr)
	{
		try 
		{	
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
				"select cve_prov, nom_prov from proveedores");
			
			int ancho [] = {47, 510};
			
			for(int x = 0; x < 2; x++)
			{
				tb_usr.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
			}
			
			Object dato[] = new Object[2];
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				dato[0] = rs.getInt(1);
				dato[1] = rs.getString(2);
				model.addRow(dato);
			}
			cn.close();
		} 
		catch (SQLException err) 
		{
			System.err.println("�ERROR EN LLENAR TABLA! " + err);
			JOptionPane.showMessageDialog(null, "�ERROR AL MOSTRAR INFORMACI�N! Contacta con el Administrador.");
		}
	}

}
