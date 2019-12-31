package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.PredmetController;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.dijalog.IzmenaPredmeta;

public class IzmenaPredmetaListener implements ActionListener{
	private IzmenaPredmeta view;
	
	public IzmenaPredmetaListener(IzmenaPredmeta view)
	{
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(view.getPotvrdiButton().isEnabled())
		{
			Profesor prof = (Profesor)view.getProfesori().getSelectedItem();
			Predmet p = new Predmet(view.getSifra().getText(), view.getNaziv().getText(),
					(int)view.getSemestar().getSelectedItem(), (int)view.getGodina().getSelectedItem(),
					prof);
			if(!PredmetController.getInstance().editPredmet(p))
			{
				JOptionPane.showMessageDialog(null, "Nije uspela izmena predmeta!","Warning", JOptionPane.WARNING_MESSAGE);
			}
			view.dispose();
		}
	}
}
