package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.controller.StudentController;
import studentskasluzba.view.PretragaPolje;

public class PretragaStudentaListener implements ActionListener{

	private PretragaPolje view;
	
	public PretragaStudentaListener(PretragaPolje view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String unos = view.getText(); //.toLowerCase
		if(unos.equals(view.getDefaultTekst())) {
			StudentController.getInstance().pretragaStudenta("");
			return;
		}
		
		String[] tokens = unos.split(";");
		for(String token : tokens) {
			StudentController.getInstance().pretragaStudenta(token);
		}
		
	}

}
