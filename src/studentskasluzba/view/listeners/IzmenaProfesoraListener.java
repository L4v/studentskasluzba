package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.dijalog.IzmenaProfesora;

public class IzmenaProfesoraListener implements ActionListener{

	private IzmenaProfesora izmProf;
	
	public IzmenaProfesoraListener(IzmenaProfesora izmProf) {
		this.izmProf = izmProf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.izmProf.getDodajButton().isEnabled())
		{
			Profesor p = new Profesor(izmProf.getIme().getText(), izmProf.getPrezime().getText(), izmProf.getDatum().getText(),
					izmProf.getAdrStanovanja().getText(), izmProf.getTelefon().getText(), izmProf.getEmail().getText(), izmProf.getAdrKancelarije().getText(),
					izmProf.getBrLicneKarte().getText(), izmProf.getTitula().getText(), izmProf.getZvanje().getText());

			ProfesorController.getInstance().editProfesor(p);
			
			this.izmProf.dispose();
		}

	}
}
