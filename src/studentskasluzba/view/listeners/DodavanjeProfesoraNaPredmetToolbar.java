package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.DodavanjeProfesoraNaPredmet;

public class DodavanjeProfesoraNaPredmetToolbar implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int row = GlavniProzor.getInstance().getSelektovanuTorku();
		if(row == -1)
		{
			JOptionPane.showMessageDialog(null, "Odaberite predmet!","Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		DodavanjeProfesoraNaPredmet view = new DodavanjeProfesoraNaPredmet();
		view.setVisible(true);
	}

}
