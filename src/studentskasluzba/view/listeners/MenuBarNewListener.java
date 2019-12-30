package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.DodavanjePredmeta;
import studentskasluzba.view.dijalog.DodavanjeProfesora;
import studentskasluzba.view.dijalog.DodavanjeStudenta;

public class MenuBarNewListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(GlavniProzor.getInstance().getSelektovanTab())
		{
		 case STUDENT:
		 {
			DodavanjeStudenta miNew = new DodavanjeStudenta();
			miNew.setVisible(true);
			break;
		 }
		 case PROFESOR:
		 {
			 DodavanjeProfesora miNew = new DodavanjeProfesora();
			 miNew.setVisible(true);
			 break;
		 }
		 case PREDMET:
		 {
			DodavanjePredmeta miNew = new DodavanjePredmeta();
			miNew.setVisible(true);
			break;
		 }
		 default:
		 {
			 return;
		 }
		}
		
	}

}
