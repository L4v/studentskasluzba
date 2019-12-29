package studentskasluzba.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

// NOTE(Jovan): Proverava da li je popunjeno polje, ako
// nije, osenci ga
public class FocusListenerObaveznoTxt implements FocusListener{

	@Override
	public void focusGained(FocusEvent arg0) {
		JTextField text = (JTextField) arg0.getComponent();
		text.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField text = (JTextField)arg0.getComponent();
		if(text.getText().isEmpty())
		{
			text.setBackground(new Color(171, 171, 171));
		}
	}

}
