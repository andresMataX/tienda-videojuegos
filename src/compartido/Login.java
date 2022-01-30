package compartido;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import admin.Administrador;
import cajero.Cajero;
import clases.Conexion;
import clases.Decoracion;
import java.awt.Cursor;
import javax.swing.Icon;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Login extends JFrame
{
	public static String user = "";
	public static int cve_user = 0;
	static int intentos = 4;
	
	/**
	 * Lanzar la apliación
	 */
	public static void main(String[] args)
	{
		Login l = new Login();
		l.setVisible(true);
	}

	public Login()
	{
		Decoracion iconos = new Decoracion();	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tienda-de-juegos (1).png")));
		setRootPaneCheckingEnabled(false);
		setResizable(false);
		setBounds(new Rectangle(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 865, 540);
		setTitle("| - LOGIN - |");
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(150,251,204)); // Color: 96FBCC
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("Tiendo do zapatos");
		lbl_titulo.setFont(new Font("Roboto", Font.BOLD, 26));
		lbl_titulo.setForeground(new Color(0,0,0));
		lbl_titulo.setBounds(234, 17, 394, 33);
		contentPane.add(lbl_titulo);
		
		JLabel lbl_usuario = new JLabel("USUARIO");
		lbl_usuario.setForeground(Color.BLACK);
		lbl_usuario.setFont(new Font("Roboto", Font.PLAIN, 26));
		lbl_usuario.setBounds(348, 261, 116, 33);
		lbl_titulo.setForeground(new Color(0,0,0));
		contentPane.add(lbl_usuario);
		
		JLabel lbl_password = new JLabel("CONTRASE\u00D1A");
		lbl_password.setFont(new Font("Roboto", Font.PLAIN, 26));
		lbl_password.setBounds(334, 362, 181, 33);
		lbl_password.setForeground(Color.BLACK);
		contentPane.add(lbl_password);
		
		JTextField txt_user = new JTextField();
		txt_user.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_user.setBackground(Color.WHITE);
		txt_user.setHorizontalAlignment(SwingConstants.CENTER);
		txt_user.setForeground(Color.BLACK);
		txt_user.setFont(new Font("Roboto", Font.PLAIN, 22));
		txt_user.setBounds(250, 297, 350, 28);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		JPasswordField txt_pass = new JPasswordField();
		txt_pass.setBorder(new LineBorder(Color.BLACK));
		txt_pass.setForeground(Color.BLACK);
		txt_pass.setBackground(Color.WHITE);
		txt_pass.setHorizontalAlignment(SwingConstants.CENTER);
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txt_pass.setForeground(Color.BLACK);
		txt_pass.setBounds(250, 395, 350, 28);
		contentPane.add(txt_pass);
		
		JButton btn_ingresar = new JButton("INGRESAR");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = txt_user.getText().trim();
				
				@SuppressWarnings("deprecation")
				String pass = txt_pass.getText().trim();
				if (!user.equals("") && !pass.equals(""))
				{	
					try
					{	
						// Se hace la conexión a la base de datos
						Connection cn = Conexion.conectar();
						//  Sentencia para validar que exista un usuario con esa contraseña
						PreparedStatement pst = cn.prepareStatement(
								"select niv_usr, cve_usr from usuarios where usr_usr = '" + user + "' and pass_usr = '" + pass + "'");
						ResultSet rs = pst.executeQuery();
						// Revisa si hay o no alguna coincidencia
						if (rs.next())
						{
							cve_user = rs.getInt("cve_usr");
							int tipo_nivel = rs.getInt("niv_usr");
							if (tipo_nivel == 1)
							{
								new Cajero().setVisible(true);
								dispose();
							} 
							else
							{
								new Administrador().setVisible(true);
								dispose();
							}
						} 
						else
						{
							// Te elimina un intento, tienes 3
							intentos--;
							if (intentos == 0)
							{
								JOptionPane.showMessageDialog(null, "Demasiados intentos fallidos.\nApagando aplicación. . .");
								System.exit(0);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Datos de Acceso Incorrectos | Intentos restantes: " + intentos);
							}
							txt_user.setText("");
							txt_pass.setText("");
						}
						cn.close();
					} 
					catch (Exception e2)
					{
						System.err.print("ERROR EN EL BOTÓN ACCEDER. " + e2);
						JOptionPane.showMessageDialog(null, "¡ERROR AL INICIAR SESIÓN! Contactar con el Desarrollador.");
					}
				} 
				else
				{
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}
		});
		btn_ingresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_ingresar.setBorder(new LineBorder(Color.BLACK));
		btn_ingresar.setBackground(new Color(73,122,100));
		btn_ingresar.setFont(new Font("Roboto Thin", Font.BOLD, 28));
		btn_ingresar.setForeground(Color.WHITE);
		btn_ingresar.setBounds(348, 437, 150, 50);
		btn_ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btn_ingresar);
		
		JButton btn_apagar = new JButton("");
		btn_apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cerrar la aplicación
				System.exit(0);
			}
		});
		btn_apagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_apagar.setBorder(null);
		btn_apagar.setBackground(new Color(150,251,204));
		btn_apagar.setBounds(781, 17, 50, 50);
		Icon icono_apagar = iconos.icono("apagar.png", 50, 50);
		btn_apagar.setIcon(icono_apagar);
		contentPane.add(btn_apagar);
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setBounds(325, 50, 200, 200);
		Icon icono_logo = iconos.icono("tienda-de-juegos.png", 200, 200);
		lbl_logo.setIcon(icono_logo);
		contentPane.add(lbl_logo);
		
		JLabel lbl_admin = new JLabel("");
		lbl_admin.setBounds(44, 281, 150, 150);
		Icon icono_admin = iconos.icono("administrador.png", 150, 150);
		lbl_admin.setIcon(icono_admin);
		contentPane.add(lbl_admin);
		
		JLabel lbl_cajero = new JLabel("");
		lbl_cajero.setBounds(656, 281, 150, 150);
		Icon icono_cajero = iconos.icono("cajero.png", 150, 150);
		lbl_cajero.setIcon(icono_cajero);
		contentPane.add(lbl_cajero);
		
		JLabel lbl_margen = new JLabel("");
		lbl_margen.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		lbl_margen.setBounds(0, 0, 849, 501);
		contentPane.add(lbl_margen);
	}
}
