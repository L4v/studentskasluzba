package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.StudentController;
import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.DodavanjeStudentaNaPredmet;

public class DodavanjeStudentaNaPredmetListener implements ActionListener{

	private DodavanjeStudentaNaPredmet dodStudPred;
	
	public DodavanjeStudentaNaPredmetListener(DodavanjeStudentaNaPredmet dodStudPred) {
		this.dodStudPred = dodStudPred;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int ret = StudentController.getInstance().addStudentNaPredmet(dodStudPred.getUnos().getText(), GlavniProzor.getInstance().getSelektovanuTorku());
		
		if(ret == 1) {
			JOptionPane.showMessageDialog(null, "Student ne postoji u bazi podataka!","Warning", JOptionPane.WARNING_MESSAGE);
			this.dodStudPred.dispose();
		} else if(ret == 2) {
			JOptionPane.showMessageDialog(null, "Trenutna godina studija studenta nije ista sa predmetom!","Warning", JOptionPane.WARNING_MESSAGE);
			this.dodStudPred.dispose();
		} else if(ret == 3){
			JOptionPane.showMessageDialog(null, "Student ve\u0107 poha\u0111a ovaj predmet.");
			this.dodStudPred.dispose();
		} else {
			this.dodStudPred.dispose();
		}
	}
	
	
}
