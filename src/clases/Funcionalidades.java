package clases;

import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Funcionalidades
{
	private int jOptionReg()
	{
		return JOptionPane.showConfirmDialog(null, "Tienes datos que no se guardarán, ¿Deseas continuar?", "Confirmar Salida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	}
	
	private void jOptionAcep()
	{
		JOptionPane.showMessageDialog(null, "Debes todos los campos.", "Información incompleta", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * switch ()
				{
				case 0:
					
					dispose();
					break;
				case 3:
					
					dispose();
					break;
				}
	 * */
	
	// Regresar
	//-----------------------------------------------------------------------------------------------------
	
	/**
	 * 1 JTextFiedl 
	 * */
	public int validadorReg(JTextField txt1)
	{
		if (!txt1.getText().equals(""))
		{
			return jOptionReg();
		}
		return 3;
	}	
	
	/**
	 * 3 JTextField y 1 JTextArea
	 * */
	public int validadorReg(JTextField txt1, JTextField txt2, JTextField txt3, JTextArea ta1) 
	{
		if (!txt1.getText().equals("") || !txt2.getText().equals("") || !txt3.getText().equals("") || !ta1.getText().equals(""))
		{
			return jOptionReg();
		}
		return 3;
	}
	
	/**
	 * 3 JTextField y 3 JComboBox
	 * */
	@SuppressWarnings("rawtypes")
	public int validadorReg(JTextField txt1, JTextField txt2, JTextField txt3, JComboBox cb1, JComboBox cb2, JComboBox cb3) 
	{
		if (!txt1.getText().equals("") || !txt2.getText().equals("") || !txt3.getText().equals("") || cb1.getSelectedIndex() == 0 || cb2.getSelectedIndex() == 0 || cb3.getSelectedIndex() == 0)
		{
			return jOptionReg();
		}
		return 3;
	}
	
	/**
	 * 4 JTextField
	 * */
	public int validadorReg(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4) 
	{
		if (!txt1.getText().equals("") || !txt2.getText().equals("") || !txt3.getText().equals("") || !txt4.getText().equals(""))
		{
			return jOptionReg();
		}
		return 3;
	}
	
	/**
	 * 5 JTextField
	 * */
	public int validadorReg(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5) 
	{
		if (!txt1.getText().equals("") || !txt2.getText().equals("") || !txt3.getText().equals("") || !txt4.getText().equals("") || !txt5.getText().equals(""))
		{
			return jOptionReg();
		}
		return 3;
	}
	
	/**
	 * 6 JTextField
	 * */
	public int validadorReg(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6) 
	{
		if (!txt1.getText().equals("") || !txt2.getText().equals("") || !txt3.getText().equals("") || !txt4.getText().equals("") || !txt5.getText().equals("") || !txt6.getText().equals(""))
		{
			return jOptionReg();
		}
		return 3;
	}
	
	/**
	 * 8 JTextField
	 * */
	public int validadorReg(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6, JTextField txt7, JTextField txt8) 
	{
		if (!txt1.getText().equals("") || !txt2.getText().equals("") || !txt3.getText().equals("") || !txt4.getText().equals("") || !txt5.getText().equals("") || !txt6.getText().equals("") || !txt7.getText().equals("") || !txt8.getText().equals(""))
		{
			return jOptionReg();
		}
		return 3;
	}

	
	/**
	 * 9 JTextField
	 * */
	public int validadorReg(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6, JTextField txt7, JTextField txt8, JTextField txt9) 
	{
		if (!txt1.getText().equals("") || !txt2.getText().equals("") || !txt3.getText().equals("") || !txt4.getText().equals("") || !txt5.getText().equals("") || !txt6.getText().equals("") || !txt7.getText().equals("") || !txt8.getText().equals("") || !txt9.getText().equals(""))
		{
			return jOptionReg();
		}
		return 3;
	}
	
	// Aceptar
	/**
	 * if (!new Funcionalidades())
				{
					JOptionPane.showMessageDialog(null, "Smn");
				}
	 * */
	//-----------------------------------------------------------------------------------------------------
	
	/**
	 * 1 JCheckBox
	 * */
	public boolean validadorAcep(JCheckBox chb1) 
	{
		if (!chb1.isSelected())
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 2 JTextField
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals(""))
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 1 JTextField
	 * */
	public boolean validadorAcep(JTextField txt1) 
	{
		if (txt1.getText().equals(""))
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 1 JTextField y 1 JComboBox
	 * */
	@SuppressWarnings("rawtypes")
	public boolean validadorAcep(JTextField txt1, JComboBox cb1) 
	{
		if (txt1.getText().equals("") || cb1.getSelectedIndex() != 0)
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 3 JTextField y 1 JTextArea
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextArea ta1) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || ta1.getText().equals(""))
		{
			jOptionAcep();
			return true;
		}
		return false;
	}

	/**
	 * 3 JTextField y 3 JComboBox
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, int cb1, int cb2, int cb3) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || cb1 == 0 || cb2 == 0 || cb3 == 0)
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 4 JTextField
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals(""))
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 4 JTextField y 1 JComboBox
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, int cb1) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || cb1 == 0)
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 5 JTextField y 1 JComboBox
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, int cb1) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || cb1 == 0)
		{
			JOptionPane.showMessageDialog(null, "Debes todos los campos.", "Información incompleta", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		return false;
	}
	
	/**
	 * 5 JTextField y 2 JComboBox
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, int cb1, int cb2) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || cb1 == 0 || cb2 == 0)
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 6 JTextField
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || txt6.getText().equals(""))
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 8 JTextField y 1 JComboBox
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6, JTextField txt7, JTextField txt8, int cb1) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || txt6.getText().equals("") || txt7.getText().equals("") || txt8.getText().equals("") || cb1 == 0)
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 9 JTextField
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6, JTextField txt7, JTextField txt8, JTextField txt9) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || txt6.getText().equals("") || txt7.getText().equals("") || txt8.getText().equals("") || txt9.getText().equals(""))
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	/**
	 * 9 JTextField y 1 JCheckBox
	 * */
	public boolean validadorAcep(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6, JTextField txt7, JTextField txt8, JTextField txt9, JCheckBox chb1) 
	{
		if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || txt6.getText().equals("") || txt7.getText().equals("") || txt8.getText().equals("") || txt9.getText().equals("") || !chb1.isSelected())
		{
			jOptionAcep();
			return true;
		}
		return false;
	}
	
	// Tablas
	//-----------------------------------------------------------------------------------------------------
	
	public int selecTabla(DefaultTableModel model, int colu_point, JTable tb, MouseEvent e)
	{
		int cve = 0;		
		int fila_point = tb.rowAtPoint(e.getPoint());
		
		if(fila_point > -1)
		{
			cve = (int) model.getValueAt(fila_point, colu_point);
		}
		return cve;
	}
}
