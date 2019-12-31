package studentskasluzba.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import studentskasluzba.controller.StudentController;
import studentskasluzba.model.Student;
import studentskasluzba.view.StatusStudent;
import studentskasluzba.view.dijalog.DodavanjeStudenta;

public class DodavanjeStudentaListener implements ActionListener{

	private DodavanjeStudenta view;
	
	public DodavanjeStudentaListener(DodavanjeStudenta view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.view.getPotvrdi().isEnabled())
		{
			String ime = view.getImeT().getText();
			String prezime = view.getPrezimeT().getText();
			String datRodj = view.getDatRodjT().getText();
			String adresa = view.getAdresaT().getText();
			String brTelefona = view.getBrTelefonaT().getText();
			String brIndeksa = view.getBrIndeksaT().getText();
			String email = view.getEmailT().getText();
			String datumUpisa = view.getDatumUpisaT().getText();
			double prosek = Double.parseDouble(view.getProsekT().getText());
			int trenutnaGod  = Integer.parseInt(String.valueOf(view.getTrenGod().getSelectedIndex()+1));
			
			StatusStudent statusStud;
			
			if (view.getRadBtnS().isSelected()) {
				 statusStud = StatusStudent.S;
			} else {
				 statusStud = StatusStudent.B;
			}
			
			Student s = new Student(ime, prezime, datRodj, adresa, brTelefona, email, brIndeksa, datumUpisa, trenutnaGod, statusStud, prosek);
			
			if (!StudentController.getInstance().addStudent(s)) {
				JOptionPane.showMessageDialog(null, "Student sa tim brojem indeksa ve\u0107 postoji!","Warning", JOptionPane.WARNING_MESSAGE);	
			}
			
			view.dispose();
		}
	}
		

}

