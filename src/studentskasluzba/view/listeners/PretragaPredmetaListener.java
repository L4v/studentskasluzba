package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.controller.PredmetController;
import studentskasluzba.view.PretragaPolje;

public class PretragaPredmetaListener implements ActionListener{

	private PretragaPolje view;
	
	public PretragaPredmetaListener(PretragaPolje view)
	{
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = view.getText().toUpperCase();
		if(text.equalsIgnoreCase(view.getDefaultTekst()))
		{
			PredmetController.getInstance().pretraziPredmet("");
			return;
		}
		String[] tokens = text.split(";");
		for(String token : tokens)
		{
			PredmetController.getInstance().pretraziPredmet(token);
		}
	}

}
