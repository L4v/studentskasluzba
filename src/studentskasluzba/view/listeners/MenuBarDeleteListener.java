package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.BrisanjePredmeta;
import studentskasluzba.view.dijalog.BrisanjeProfesora;
import studentskasluzba.view.dijalog.BrisanjeStudenta;

public class MenuBarDeleteListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(GlavniProzor.getInstance().getSelektovanTab())
		{
			case STUDENT:
			{
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali studenta!");
					return;
				}
				BrisanjeStudenta brStud = new BrisanjeStudenta();
				brStud.setVisible(true);
				break;
			}
			case PROFESOR:
			{
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
					return;
				}
				BrisanjeProfesora brProf = new BrisanjeProfesora();
				brProf.setVisible(true);
				break;
			}
			case PREDMET:
			{
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
					return;
				}
				BrisanjePredmeta brPred = new BrisanjePredmeta();
				brPred.setVisible(true);
				break;
			}
		}
		
	}
	

}
