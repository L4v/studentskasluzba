package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.model.BazaProfesor;
import studentskasluzba.view.dijalog.PredmetiProfesora;

public class PredmetiProfesoraListener implements ActionListener{
	private PredmetiProfesora view;
	
	public PredmetiProfesoraListener(PredmetiProfesora view)
	{
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int index = view.getList().getSelectedIndex();
		if(index == -1)
		{
			JOptionPane.showMessageDialog(null, "Niste selektovali predmet");
			return;
		}
		int choice = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da \u017Eelite da obri\u0161ete predmet?","Brisanje predmeta profesora",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(choice == JOptionPane.YES_OPTION)
		{
			BazaProfesor.getInstance().removePredmet(view.getRow(), index);
			view.dispose();
		}
	}

}
