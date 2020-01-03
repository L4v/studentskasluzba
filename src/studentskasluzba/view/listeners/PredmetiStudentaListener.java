package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.StudentController;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Student;
import studentskasluzba.view.dijalog.PredmetiStudenta;

public class PredmetiStudentaListener implements ActionListener{

	private PredmetiStudenta view;
	
	public PredmetiStudentaListener(PredmetiStudenta view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int i = view.getList().getSelectedIndex();
		if (i==-1) {
			JOptionPane.showMessageDialog(null, "Niste selektovali predmet!","Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int choise = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da \u017Eelite da obri\u0161ete predmet?","Brisanje predmeta studenta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (choise==JOptionPane.YES_OPTION) {
			Predmet p = StudentController.getInstance().getStudent(view.getRow()).getPredmet(i);
			Student s = StudentController.getInstance().getStudent(view.getRow());
			s.removePredmet(i);
			p.removeStudent(s);
			
			this.view.dispose();
		}
		
	}

}
