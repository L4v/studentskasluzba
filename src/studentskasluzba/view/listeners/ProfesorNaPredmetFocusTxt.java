package studentskasluzba.view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import studentskasluzba.view.dijalog.DodavanjeProfesoraNaPredmet;

public class ProfesorNaPredmetFocusTxt implements FocusListener{

	private DodavanjeProfesoraNaPredmet view;
	
	public ProfesorNaPredmetFocusTxt(DodavanjeProfesoraNaPredmet view)
	{
		this.view = view;
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		JTextField text =(JTextField) arg0.getComponent();
		text.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField text =(JTextField) arg0.getComponent();
		if(text.getText().isEmpty() ||
				(text.getText().matches("\"\\d{9}\"") == false))
		{
			text.setBackground(new Color(231, 76, 60));
			this.view.getPotvrda().setEnabled(false);
		}
		else
		{
			this.view.getPotvrda().setEnabled(true);
		}
	}

}
