package studentskasluzba.view.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import studentskasluzba.view.dijalog.DodavanjeProfesora;

public class DodavanjeProfesoraFocus implements FocusListener{

	/*
	 * 0     - Ne proverava se duzina
	 * n > 0 - Proverava se duzina za n
	 * -1    - Proverava se da li je u formatu XX-YY(Y)/ZZZZ (indeks)
	 * -2    - Provera da li je u formatu dd.mm.yyyy. (datum)
	 * -3    - Provera da li je u formatu x@y.z
	 * -4    - Provera da li je u formatu "xxxxxxxxx"
	 */
	
	private int duzina;
	private DodavanjeProfesora view;
	public DodavanjeProfesoraFocus(DodavanjeProfesora view, int duzina)
	{
		this.view = view;
		this.duzina = duzina;
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		JTextField text = (JTextField) arg0.getComponent();
		text.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField text = (JTextField)arg0.getComponent();
		if(text.getText().isEmpty() ||
				((duzina == -1) && (text.getText().matches("[a-zA-Z]{2}-\\d{1,3}\\/\\d{4}") == false)) ||
				((duzina == -2) && (text.getText().matches("^([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}\\.$") == false)) ||
				((duzina == -3) && (text.getText().matches(".+@.+\\..+") == false)) ||
				((duzina == -4) && (text.getText().matches("\"\\d{9}\"") == false)) ||
				((duzina > 0) && (text.getText().length() != duzina)))
		{
			text.setBackground(new Color(231, 76, 60));
			this.view.getDodajButton().setEnabled(false);
		}
		else
		{
			this.view.getDodajButton().setEnabled(true);
		}
	}
}
