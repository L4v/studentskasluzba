package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.BrisanjePredmeta;
import studentskasluzba.view.dijalog.BrisanjeProfesora;
import studentskasluzba.view.dijalog.BrisanjeStudenta;

public class BrisanjeToolbarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(GlavniProzor.getInstance().getSelektovanTab())
		{
			case STUDENT:
			{
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali studenta!");
					return;
				}
				BrisanjeStudenta view = new BrisanjeStudenta();
				view.setVisible(true);
				break;
			}
			case PROFESOR:
			{
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
					return;
				}
				BrisanjeProfesora view = new BrisanjeProfesora();
				view.setVisible(true);
				break;
			}
			case PREDMET:
			{
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
					return;
				}
				BrisanjePredmeta view = new BrisanjePredmeta();
				view.setVisible(true);
				break;
			}
		}
	}

}
