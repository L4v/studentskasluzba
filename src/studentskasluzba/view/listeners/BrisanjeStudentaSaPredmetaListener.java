package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.StudentController;
import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.StudentiNaPredmetu;

public class BrisanjeStudentaSaPredmetaListener implements ActionListener{

	private StudentiNaPredmetu view;
	
	public BrisanjeStudentaSaPredmetaListener(StudentiNaPredmetu view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(view.getList().getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Niste selektovali studenta!","Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int choise = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da \u017Eelite da obri\u0161ete studenta?","Brisanje studenta sa predmeta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (choise==JOptionPane.YES_OPTION) {
			StudentController.getInstance().removeStudentSaPredmeta(GlavniProzor.getInstance().getSelektovanuTorku(), view.getList().getSelectedIndex());
		}
		
		this.view.dispose();
	}

}
