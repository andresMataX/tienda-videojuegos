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

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Conexion;
import clases.Decoracion;
import clases.Funcionalidades;
import clases.SentenciasSQL;
import compartido.Login;

@SuppressWarnings("serial")
public class RegCorte2Admin extends JFrame
{
	public RegCorte2Admin()
	{
		Decoracion deco = new Decoracion();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setBounds(0, 0, 785, 540);
		getContentPane().setBackground(new Color(150,251,204));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);	
		setTitle("| - Registrar Corte de Caja - |");
		
		JLabel lbl_usuario = new JLabel("\u00A1HOLA " + deco.Nombre(Login.user) + "!");
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setBounds(10, 9, 480, 45);
		getContentPane().add(lbl_usuario);
		
		JLabel lbl_tit = new JLabel("REGISTRAR CORTE");
		lbl_tit.setFont(new Font("Roboto", Font.PLAIN, 38));
		lbl_tit.setBounds(209, 75, 326, 45);
		lbl_tit.setForeground(Color.BLACK);
		getContentPane().add(lbl_tit);
		
		Decoracion fecha = new Decoracion();
		JLabel lbl_fecha = new JLabel(fecha.fecha());
		lbl_fecha.setForeground(Color.BLACK);
		lbl_fecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_fecha.setFont(new Font("Roboto Medium", Font.BOLD, 30));
		lbl_fecha.setBounds(565, 9, 193, 35);
		getContentPane().add(lbl_fecha);
		
		JLabel lbl_cie_cor = new JLabel("CIERRE DE CAJA");
		lbl_cie_cor.setForeground(Color.BLACK);
		lbl_cie_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_cie_cor.setBounds(454, 127, 185, 28);
		getContentPane().add(lbl_cie_cor);
		
		JLabel lbl_arqi_cor = new JLabel("FONDO FINAL");
		lbl_arqi_cor.setForeground(Color.BLACK);
		lbl_arqi_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_arqi_cor.setBounds(28, 129, 185, 28);
		getContentPane().add(lbl_arqi_cor);
		
		JLabel lbl_bq = new JLabel("BILLETE        $500"); // 8 Espacios
		lbl_bq.setForeground(Color.BLACK);
		lbl_bq.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_bq.setBounds(28, 168, 190, 21);
		getContentPane().add(lbl_bq);
		
		JLabel lbl_bd = new JLabel("BILLETE        $200");
		lbl_bd.setForeground(Color.BLACK);
		lbl_bd.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_bd.setBounds(28, 196, 190, 21);
		getContentPane().add(lbl_bd);
		
		JLabel lbl_bc = new JLabel("BILLETE        $100");
		lbl_bc.setForeground(Color.BLACK);
		lbl_bc.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_bc.setBounds(28, 226, 190, 21);
		getContentPane().add(lbl_bc);
		
		JLabel lbl_bcq = new JLabel("BILLETE        $50");
		lbl_bcq.setForeground(Color.BLACK);
		lbl_bcq.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_bcq.setBounds(28, 256, 190, 21);
		getContentPane().add(lbl_bcq);
		
		JLabel lbl_bv = new JLabel("BILLETE        $20");
		lbl_bv.setForeground(Color.BLACK);
		lbl_bv.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_bv.setBounds(28, 286, 190, 21);
		getContentPane().add(lbl_bv);
		
		JLabel lbl_md = new JLabel("MONEDA      $10");
		lbl_md.setForeground(Color.BLACK);
		lbl_md.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_md.setBounds(28, 316, 190, 21);
		getContentPane().add(lbl_md);
		
		JLabel lbl_mc = new JLabel("MONEDA      $5");
		lbl_mc.setForeground(Color.BLACK);
		lbl_mc.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_mc.setBounds(28, 346, 190, 21);
		getContentPane().add(lbl_mc);
		
		JLabel lbl_mds = new JLabel("MONEDA      $2");
		lbl_mds.setForeground(Color.BLACK);
		lbl_mds.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_mds.setBounds(28, 376, 190, 21);
		getContentPane().add(lbl_mds);
		
		JLabel lbl_mu = new JLabel("MONEDA      $1");
		lbl_mu.setForeground(Color.BLACK);
		lbl_mu.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_mu.setBounds(28, 406, 190, 21);
		getContentPane().add(lbl_mu);
		
		JTextField txt_bq = new JTextField();
		txt_bq.setHorizontalAlignment(SwingConstants.CENTER);
		txt_bq.setForeground(Color.BLACK);
		txt_bq.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_bq.setColumns(10);
		txt_bq.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_bq.setBackground(Color.WHITE);
		txt_bq.setBounds(245, 164, 33, 25);
		getContentPane().add(txt_bq);
		
		JTextField txt_bd = new JTextField();
		txt_bd.setHorizontalAlignment(SwingConstants.CENTER);
		txt_bd.setForeground(Color.BLACK);
		txt_bd.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_bd.setColumns(10);
		txt_bd.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_bd.setBackground(Color.WHITE);
		txt_bd.setBounds(245, 194, 33, 25);
		getContentPane().add(txt_bd);
		
		JTextField txt_bc = new JTextField();
		txt_bc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_bc.setForeground(Color.BLACK);
		txt_bc.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_bc.setColumns(10);
		txt_bc.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_bc.setBackground(Color.WHITE);
		txt_bc.setBounds(245, 224, 33, 25);
		getContentPane().add(txt_bc);
		
		JTextField txt_bcq = new JTextField();
		txt_bcq.setHorizontalAlignment(SwingConstants.CENTER);
		txt_bcq.setForeground(Color.BLACK);
		txt_bcq.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_bcq.setColumns(10);
		txt_bcq.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_bcq.setBackground(Color.WHITE);
		txt_bcq.setBounds(245, 254, 33, 25);
		getContentPane().add(txt_bcq);
		
		JTextField txt_bv = new JTextField();
		txt_bv.setHorizontalAlignment(SwingConstants.CENTER);
		txt_bv.setForeground(Color.BLACK);
		txt_bv.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_bv.setColumns(10);
		txt_bv.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_bv.setBackground(Color.WHITE);
		txt_bv.setBounds(245, 284, 33, 25);
		getContentPane().add(txt_bv);
		
		JTextField txt_md = new JTextField();
		txt_md.setHorizontalAlignment(SwingConstants.CENTER);
		txt_md.setForeground(Color.BLACK);
		txt_md.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_md.setColumns(10);
		txt_md.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_md.setBackground(Color.WHITE);
		txt_md.setBounds(245, 314, 33, 25);
		getContentPane().add(txt_md);
		
		JTextField txt_mc = new JTextField();
		txt_mc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mc.setForeground(Color.BLACK);
		txt_mc.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_mc.setColumns(10);
		txt_mc.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_mc.setBackground(Color.WHITE);
		txt_mc.setBounds(245, 344, 33, 25);
		getContentPane().add(txt_mc);
		
		JTextField txt_mds = new JTextField();
		txt_mds.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mds.setForeground(Color.BLACK);
		txt_mds.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_mds.setColumns(10);
		txt_mds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_mds.setBackground(Color.WHITE);
		txt_mds.setBounds(245, 374, 33, 25);
		getContentPane().add(txt_mds);
		
		JTextField txt_mu = new JTextField();
		txt_mu.setHorizontalAlignment(SwingConstants.CENTER);
		txt_mu.setForeground(Color.BLACK);
		txt_mu.setFont(new Font("Roboto", Font.PLAIN, 24));
		txt_mu.setColumns(10);
		txt_mu.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_mu.setBackground(Color.WHITE);
		txt_mu.setBounds(245, 404, 33, 25);
		getContentPane().add(txt_mu);
		
		JCheckBox chb_cie_cor = new JCheckBox("");
		chb_cie_cor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chb_cie_cor.setHorizontalAlignment(SwingConstants.CENTER);
		chb_cie_cor.setBackground(Color.WHITE);
		chb_cie_cor.setForeground(Color.BLACK);
		chb_cie_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		chb_cie_cor.setBounds(532, 155, 25, 25);
		getContentPane().add(chb_cie_cor);
		
		JButton btn_acep = new JButton("ACEPTAR");
		btn_acep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(chb_cie_cor))
				{
					try 
					{
						SentenciasSQL c_cor = new SentenciasSQL();
						int cve_cor = c_cor.cveDetalles("select max(cve_cor) as cve_cor from corte_caja", "cve_cor");
						double cob_cor = 0.00;
						double ret_cor = 0.00;
						int arq_f_i = 0;
												
						Connection cn3 = Conexion.conectar();
						String sql3 = "select cob_cor, ret_cor, arqfi_cor from corte_caja where cve_cor = '"+ cve_cor+"'";
						PreparedStatement pst3 = cn3.prepareStatement(sql3);
						ResultSet rs3 = pst3.executeQuery();
						
						while(rs3.next()) 
						{
							cob_cor = rs3.getDouble("cob_cor");
							ret_cor = rs3.getDouble("ret_cor");
							arq_f_i = rs3.getInt("arqfi_cor");
						}
						
						int b_quinientos = Integer.parseInt(txt_bq.getText())*500;
						int b_doscientos = Integer.parseInt(txt_bd.getText())*200;
						int b_cien = Integer.parseInt(txt_bc.getText())*100;
						int b_cincuenta = Integer.parseInt(txt_bcq.getText())*50;
						int b_veinte = Integer.parseInt(txt_bv.getText())*20;
						int m_diez = Integer.parseInt(txt_md.getText())*10;
						int m_cinco = Integer.parseInt(txt_mc.getText())*5;
						int m_dos = Integer.parseInt(txt_mds.getText())*2;
						int m_uno = Integer.parseInt(txt_mu.getText());
						
						double fondo = arq_f_i - b_quinientos - b_doscientos - b_cien - b_cincuenta - b_veinte - m_diez - m_cinco - m_dos - m_uno;
						double arqf = cob_cor - ret_cor;
						double fal = fondo - arqf;
						
						String statement_cor = "update corte_caja set cie_cor = ?, fnf_cor = ?, arqf_cor = ?, fal_cor = ? where cve_cor = '"+cve_cor+"'";
						String[] mod_cor = {deco.fechaDetallada(), fondo+"", arqf+"",fal+""};
						int[] tipo_cor = {2,3,3,3};
						c_cor.updateSQL(statement_cor, mod_cor, tipo_cor);	
						
						JOptionPane.showMessageDialog(null, "¡Modificación Realizada!");
					} 
					catch (SQLException e1) 
					{
						System.err.print("¡ERROR EN CORTE DE CAJA! " + e1);
						JOptionPane.showMessageDialog(null, "¡ERROR EN CORTE DE CAJA! Contactar con el Desarrollador.");
					}
				}
			}
		});
		btn_acep.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_acep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_acep.setForeground(Color.BLACK);
		btn_acep.setBackground(new Color(60,199,134));
		btn_acep.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_acep.setBounds(407, 415, 150, 50);
		getContentPane().add(btn_acep);
		
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
		btn_regresar.setForeground(Color.BLACK);
		btn_regresar.setBorder(null);
		btn_regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegCorte1Admin().setVisible(true);
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
	}

}
