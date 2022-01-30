package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import clases.Decoracion;
import clases.Funcionalidades;
import clases.SentenciasSQL;
import compartido.Login;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class RegCorte1Admin extends JFrame
{
	public RegCorte1Admin()
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
		
		JLabel lbl_arqi_cor = new JLabel("ARQUEO INICIAL");
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
		
		JLabel lbl_ape_cor = new JLabel("APERTURA DE CAJA");
		lbl_ape_cor.setForeground(Color.BLACK);
		lbl_ape_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		lbl_ape_cor.setBounds(397, 129, 230, 28);
		getContentPane().add(lbl_ape_cor);
		
		JButton btn_sig = new JButton("SIGUIENTE");
		JCheckBox chb_ape_cor = new JCheckBox("");		
		chb_ape_cor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (chb_ape_cor.isSelected())
				{
					btn_sig.setEnabled(true);
				} 
				else
				{
					btn_sig.setEnabled(false);
				}
			}
		});
		chb_ape_cor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chb_ape_cor.setHorizontalAlignment(SwingConstants.CENTER);
		chb_ape_cor.setBackground(Color.WHITE);
		chb_ape_cor.setForeground(Color.BLACK);
		chb_ape_cor.setFont(new Font("Roboto", Font.PLAIN, 24));
		chb_ape_cor.setBounds(493, 166, 25, 25);
		getContentPane().add(chb_ape_cor);
		
		btn_sig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegCorte2Admin().setVisible(true);
				dispose();
			}
		});
		btn_sig.setEnabled(false);
		btn_sig.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_sig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_sig.setForeground(Color.BLACK);
		btn_sig.setBackground(new Color(60,199,134));
		btn_sig.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_sig.setBounds(407, 415, 150, 50);
		getContentPane().add(btn_sig);
		
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
				switch (new Funcionalidades().validadorReg(txt_bq, txt_bd, txt_bc, txt_bcq, txt_bv, txt_md, txt_mc, txt_mds, txt_mu))
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
		
		JButton btn_reg = new JButton("REGISTRAR");
		btn_reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new Funcionalidades().validadorAcep(txt_bq, txt_bd, txt_bc, txt_bcq, txt_bv, txt_md, txt_mc, txt_mds, txt_mu, chb_ape_cor))
				{
					int b_quinientos = Integer.parseInt(txt_bq.getText())*500;
					int b_doscientos = Integer.parseInt(txt_bd.getText())*200;
					int b_cien = Integer.parseInt(txt_bc.getText())*100;
					int b_cincuenta = Integer.parseInt(txt_bcq.getText())*50;
					int b_veinte = Integer.parseInt(txt_bv.getText())*20;
					int m_diez = Integer.parseInt(txt_md.getText())*10;
					int m_cinco = Integer.parseInt(txt_mc.getText())*5;
					int m_dos = Integer.parseInt(txt_mds.getText())*2;
					int m_uno = Integer.parseInt(txt_mu.getText());
					
					int arq_f_i = b_quinientos + b_doscientos + b_cien + b_cincuenta + b_veinte + m_diez + m_cinco + m_dos + m_uno;
					
					SentenciasSQL c = new SentenciasSQL();					
					String statement_com = "insert into corte_caja values (?,?,?,?,?,?,?,?,?,?)";
					String[] reg_com = {"0", Login.cve_user+"", "0.00", "0.00", arq_f_i+"", deco.fechaDetallada(), deco.fechaDetallada(), "0.00", "0.00", "0.00"};
					int[] tipo_com = {1,1,3,3,3,2,2,3,3,3};
					c.createSQL(statement_com, reg_com, tipo_com);					
				}
			}
		});
		btn_reg.setForeground(Color.BLACK);
		btn_reg.setFont(new Font("Roboto", Font.PLAIN, 30));
		btn_reg.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn_reg.setBackground(new Color(60, 199, 134));
		btn_reg.setBounds(582, 350, 160, 50);
		getContentPane().add(btn_reg);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lbl_margen.setBounds(10, 54, 748, 433);
		getContentPane().add(lbl_margen);
	}
}
