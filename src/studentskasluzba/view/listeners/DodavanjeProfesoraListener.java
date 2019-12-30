package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.dijalog.DodavanjeProfesora;

public class DodavanjeProfesoraListener implements ActionListener{

	private DodavanjeProfesora view;
	
	public DodavanjeProfesoraListener(DodavanjeProfesora view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.view.getDodajButton().isEnabled())
		{
			Profesor p = new Profesor(view.getIme().getText(), view.getPrezime().getText(), view.getDatum().getText(),
					view.getAdrStanovanja().getText(), view.getTelefon().getText(), view.getEmail().getText(), view.getAdrKancelarije().getText(),
					view.getBrLicneKarte().getText(), view.getTitula().getText(), view.getZvanje().getText());
			
			if (!ProfesorController.getInstance().addProfesor(p)) {
				JOptionPane.showMessageDialog(null, "Profesor sa tim brojem li\u010Dne karte ve\u0107 postoji!","Warning", JOptionPane.WARNING_MESSAGE);	
			}
			this.view.dispose();
		}

	}

}
