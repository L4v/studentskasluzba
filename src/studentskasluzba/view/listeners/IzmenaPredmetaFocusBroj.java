package studentskasluzba.view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

// NOTE(Jovan): Proverava da li je popunjeno polje samo
// brojevima, ako nije osenci ga
public class IzmenaPredmetaFocusBroj implements FocusListener{

	// NOTE(Jovan): Koje duzine treba biti broj
	// U slucaju da je duzina = -1, ne proverava se
	// NOTE(Kristian): Ako je -2 proverava prosek
	private int duzina;
	public IzmenaPredmetaFocusBroj(int d) {
		this.duzina = d;
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		JTextField text = (JTextField) arg0.getComponent();
		text.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField text = (JTextField)arg0.getComponent();
		if (duzina >= -1) {
			if(text.getText().matches("[0-9]+") == false
					|| ((duzina != -1) && (text.getText().length() != duzina)))
			{
				text.setBackground(new Color(231,76,60));
			}
		} else if (duzina==-2) { //NOTE(Kristian): prosek mora biti izmedju 6.00 i 10.00
			if(text.getText().matches("([6-9]|10)\\.[0-9]{1,2}") == false)
			{
				text.setBackground(new Color(231,76,60));
			}
		}
	}
	
	

}
