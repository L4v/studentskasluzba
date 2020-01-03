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
		String text = view.getText();
		if(text.equalsIgnoreCase(view.getDefaultTekst()))
		{
			PredmetController.getInstance().pretraziPredmet("");
			return;
		}
		String[] tokens = text.split(";");
		String[] labels = {"sifra:", "naziv:"};
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(String token : tokens)
		{
			if(!token.equalsIgnoreCase("") && !token.equalsIgnoreCase(labels[i]))
			{
				sb.append(token.replace(labels[i], ""));
			}
			i++;
		}
		String regex = sb.toString();
		PredmetController.getInstance().pretraziPredmet(regex);
	}

}
