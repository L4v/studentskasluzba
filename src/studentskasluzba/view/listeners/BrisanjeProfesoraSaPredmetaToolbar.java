package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.PredmetController;
import studentskasluzba.view.GlavniProzor;

public class BrisanjeProfesoraSaPredmetaToolbar implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int row = GlavniProzor.getInstance().getSelektovanuTorku();
		if(row == -1)
		{
			JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
			return;
		}
		PredmetController.getInstance().removeProfesor(row);
	}

}
