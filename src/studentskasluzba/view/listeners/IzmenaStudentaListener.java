package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentskasluzba.controller.StudentController;
import studentskasluzba.model.Student;
import studentskasluzba.view.StatusStudent;
import studentskasluzba.view.dijalog.IzmenaStudenta;

public class IzmenaStudentaListener implements ActionListener{

	private IzmenaStudenta izmStud;
	
	public IzmenaStudentaListener(IzmenaStudenta izmStud) {
		this.izmStud = izmStud;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.izmStud.getPotvrdi().isEnabled())
		{
			String ime = izmStud.getImeT().getText();
			String prezime = izmStud.getPrezimeT().getText();
			String datRodj = izmStud.getDatRodjT().getText();
			String adresa = izmStud.getAdresaT().getText();
			String brTelefona = izmStud.getBrTelefonaT().getText();
			String brIndeksa = izmStud.getBrIndeksaT().getText();
			String email = izmStud.getEmailT().getText();
			String datumUpisa = izmStud.getDatumUpisaT().getText();
			double prosek = Double.parseDouble(izmStud.getProsekT().getText());
			String trenutnaGod  = String.valueOf(izmStud.getTrenGod().getSelectedIndex()+1);
			
			StatusStudent statusStud;
			
			if (izmStud.getRadBtnS().isSelected()) {
				 statusStud = StatusStudent.S;
			} else {
				 statusStud = StatusStudent.B;
			}
			
			Student s = new Student(ime, prezime, datRodj, adresa, brTelefona, email, brIndeksa, datumUpisa, trenutnaGod, statusStud, prosek);
			StudentController.getInstance().editStudent(s);
			
			
			izmStud.dispose();
		}
		
	}

}
