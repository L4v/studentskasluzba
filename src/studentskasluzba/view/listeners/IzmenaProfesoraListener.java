package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.dijalog.IzmenaProfesora;

public class IzmenaProfesoraListener implements ActionListener{

	private IzmenaProfesora view;
	
	public IzmenaProfesoraListener(IzmenaProfesora view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.view.getIzmeniButton().isEnabled())
		{
			Profesor p = new Profesor(view.getIme().getText(), view.getPrezime().getText(), view.getDatum().getText(),
					view.getAdrStanovanja().getText(), view.getTelefon().getText(), view.getEmail().getText(), view.getAdrKancelarije().getText(),
					view.getBrLicneKarte().getText(), view.getTitula().getText(), view.getZvanje().getText());

			ProfesorController.getInstance().editProfesor(p);
			
			this.view.dispose();
		}

	}
}
