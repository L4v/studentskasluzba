package studentskasluzba.view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import studentskasluzba.view.dijalog.DodavanjeStudentaNaPredmet;

public class DodStudNaPredFocus1 implements FocusListener{

private DodavanjeStudentaNaPredmet view;
	
	public DodStudNaPredFocus1(DodavanjeStudentaNaPredmet view)
	{
		this.view = view;
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		JTextField text =(JTextField) e.getComponent();
		text.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField text =(JTextField) e.getComponent();
		if(text.getText().isEmpty() || (text.getText().matches("[a-zA-Z]{2} \\d{1,3}\\/\\d{4}") == false))
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
