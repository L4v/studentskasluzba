package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.IzmenaProfesora;
import studentskasluzba.view.dijalog.IzmenaStudenta;

public class MenuBarEditListener implements ActionListener{

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
				IzmenaStudenta izmStud = new IzmenaStudenta();
				izmStud.setVisible(true);
				break;
			}
			case PROFESOR:
			{
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
					return;
				}
				IzmenaProfesora izmProf = new IzmenaProfesora();
				izmProf.setVisible(true);
				break;
			}
			case PREDMET:
			{
				//(TODO) dodati!!
				break;
			}
		}
		
	}
	
}
