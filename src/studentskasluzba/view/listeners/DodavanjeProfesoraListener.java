package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.dijalog.DodavanjeProfesora;

public class DodavanjeProfesoraListener implements ActionListener{

	private DodavanjeProfesora dodProf;
	
	public DodavanjeProfesoraListener(DodavanjeProfesora dodProf) {
		this.dodProf = dodProf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(dodProf.getDodajButton().isEnabled())
		{
			Profesor p = new Profesor(dodProf.getIme().getText(), dodProf.getPrezime().getText(), dodProf.getDatum().getText(),
					dodProf.getAdrStanovanja().getText(), dodProf.getTelefon().getText(), dodProf.getEmail().getText(), dodProf.getAdrKancelarije().getText(),
					dodProf.getBrLicneKarte().getText(), dodProf.getTitula().getText(), dodProf.getZvanje().getText());
			
			if (!ProfesorController.getInstance().addProfesor(p)) {
				JOptionPane.showMessageDialog(null, "Profesor sa tim brojem li\u010Dne karte ve\u0107 postoji!","Warning", JOptionPane.WARNING_MESSAGE);	
			}
			dodProf.dispose();
		}

	}

}
