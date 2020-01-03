package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.IzmenaPredmeta;
import studentskasluzba.view.dijalog.IzmenaProfesora;
import studentskasluzba.view.dijalog.IzmenaStudenta;

public class IzmenaToolbarListener implements ActionListener{
	
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
					IzmenaStudenta view = new IzmenaStudenta();
					view.setVisible(true);
					break;
				}
				case PROFESOR:
				{
					if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
						JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
						return;
					}
					IzmenaProfesora view = new IzmenaProfesora();
					view.setVisible(true);
					break;
				}
				case PREDMET:
				{
					if(GlavniProzor.getInstance().getSelektovanuTorku()==-1)
					{
						JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
						return;
					}
					IzmenaPredmeta view = new IzmenaPredmeta();
					view.setVisible(true);
					break;
				}
			}
		}
	}

