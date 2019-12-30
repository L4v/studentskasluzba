package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.controller.StudentController;
import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.dijalog.BrisanjeStudenta;

public class BrisanjeStudentaListener implements ActionListener{

	private BrisanjeStudenta view;
	
	public BrisanjeStudentaListener(BrisanjeStudenta view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int row = GlavniProzor.getInstance().getSelektovanuTorku();
		StudentController.getInstance().removeStudent(row);
		
		this.view.dispose();
		
	}

}
