package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.PredmetController;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.dijalog.DodavanjePredmeta;

public class DodavanjePredmetaListener implements ActionListener{

	private DodavanjePredmeta view;
	
	public DodavanjePredmetaListener(DodavanjePredmeta view)
	{
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!this.view.getDodajButton().isEnabled())
		{
			
		}
		else
		{
			String sifraPredmeta = this.view.getSifra().getText();
			String nazivPredmeta = this.view.getNaziv().getText();
			int semestarPredmeta = (int) this.view.getSemestar().getSelectedItem();
			int godinaPredmeta = (int) this.view.getGodina().getSelectedItem();
			Profesor profesorPredmeta = (Profesor)this.view.getProfesori().getSelectedItem();
			Predmet p = new Predmet(sifraPredmeta, nazivPredmeta, semestarPredmeta,
					godinaPredmeta, profesorPredmeta);
			
			// NOTE(Jovan): Pokusava da doda predmet, ako vec postoji, izbacuje gresku
			if(!PredmetController.getInstance().addPredmet(p)) {
				JOptionPane.showMessageDialog(null, "Predmet sa tom \u0161ifrom ve\u0107 postoji!","Warning", JOptionPane.WARNING_MESSAGE);
			}
			this.view.dispose();
		}
	}

}
