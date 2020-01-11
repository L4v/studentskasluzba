package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.view.PretragaPolje;

public class PretragaProfesoraListener implements ActionListener{

	private PretragaPolje view;
	
	public PretragaProfesoraListener(PretragaPolje view)
	{
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = view.getText();
		if(text.equalsIgnoreCase(view.getDefaultTekst()))
		{
			ProfesorController.getInstance().pretraziProfesor(text);
			return;
		}
		String[] tokens = text.split(";");
		for(String token : tokens)
		{
			ProfesorController.getInstance().pretraziProfesor(token);
		}
	}

}
