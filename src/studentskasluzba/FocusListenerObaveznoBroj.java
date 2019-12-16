package studentskasluzba;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

// NOTE(Jovan): Proverava da li je popunjeno polje samo
// brojevima, ako nije osenci ga
public class FocusListenerObaveznoBroj implements FocusListener{

	// NOTE(Jovan): Koje duzine treba biti broj
	// U slucaju da je duzina = -1, ne proverava se
	private int duzina;
	public FocusListenerObaveznoBroj(int d) {
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
		if(text.getText().matches("[0-9]+") == false
				|| ((duzina != -1) && (text.getText().length() != duzina)))
		{
			text.setBackground(new Color(171, 171, 171));
		}
	}

}