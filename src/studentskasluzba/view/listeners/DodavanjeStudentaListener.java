package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.StudentController;
import studentskasluzba.model.Student;
import studentskasluzba.view.StatusStudent;
import studentskasluzba.view.dijalog.DodavanjeStudenta;

public class DodavanjeStudentaListener implements ActionListener{

	private DodavanjeStudenta dodStud;
	
	public DodavanjeStudentaListener(DodavanjeStudenta dodStud) {
		this.dodStud = dodStud;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.dodStud.getPotvrdi().isEnabled())
		{
			String ime = dodStud.getImeT().getText();
			String prezime = dodStud.getPrezimeT().getText();
			String datRodj = dodStud.getDatRodjT().getText();
			String adresa = dodStud.getAdresaT().getText();
			String brTelefona = dodStud.getBrTelefonaT().getText();
			String brIndeksa = dodStud.getBrIndeksaT().getText();
			String email = dodStud.getEmailT().getText();
			String datumUpisa = dodStud.getDatumUpisaT().getText();
			double prosek = Double.parseDouble(dodStud.getProsekT().getText());
			String trenutnaGod  = String.valueOf(dodStud.getTrenGod().getSelectedIndex()+1);
			
			StatusStudent statusStud;
			
			if (dodStud.getRadBtnS().isSelected()) {
				 statusStud = StatusStudent.S;
			} else {
				 statusStud = StatusStudent.B;
			}
			
			Student s = new Student(ime, prezime, datRodj, adresa, brTelefona, email, brIndeksa, datumUpisa, trenutnaGod, statusStud, prosek);
			
			if (!StudentController.getInstance().addStudent(s)) {
				JOptionPane.showMessageDialog(null, "Student sa tim brojem indeksa ve\u0107 postoji!","Warning", JOptionPane.WARNING_MESSAGE);	
			}
			
			dodStud.dispose();
		}
	}
		

}

