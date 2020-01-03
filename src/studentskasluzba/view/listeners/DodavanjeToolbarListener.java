package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.DodavanjePredmeta;
import studentskasluzba.view.dijalog.DodavanjeProfesora;
import studentskasluzba.view.dijalog.DodavanjeStudenta;

public class DodavanjeToolbarListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(GlavniProzor.getInstance().getSelektovanTab())
		{
		case STUDENT:
			 {
				DodavanjeStudenta dodaj = new DodavanjeStudenta();
				dodaj.setVisible(true);
				break;
			 }
			 case PROFESOR:
			 {
				 DodavanjeProfesora dodaj = new DodavanjeProfesora();
				 dodaj.setVisible(true);
				 break;
			 }
			 case PREDMET:
			 {
				DodavanjePredmeta dodaj = new DodavanjePredmeta();
				dodaj.setVisible(true);
				break;
			 }
			 default:
			 {
				 return;
			 }
		}
	}
	
}
