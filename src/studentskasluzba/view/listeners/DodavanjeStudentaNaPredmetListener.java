package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.StudentController;
import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.DodavanjeStudentaNaPredmet;

public class DodavanjeStudentaNaPredmetListener implements ActionListener{

	private DodavanjeStudentaNaPredmet view;
	
	public DodavanjeStudentaNaPredmetListener(DodavanjeStudentaNaPredmet view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int ret = StudentController.getInstance().addStudentNaPredmet(view.getUnos().getText(), GlavniProzor.getInstance().getSelektovanuTorku());
		
		if(ret == 1) {
			this.view.getPotvrda().setEnabled(false);
		} else if(ret == 2) {
			this.view.getPotvrda().setEnabled(false);
		} else if(ret == 3){
			JOptionPane.showMessageDialog(null, "Student ve\u0107 poha\u0111a ovaj predmet.");
		} else {
			this.view.dispose();
		}
		
	}

	
}
