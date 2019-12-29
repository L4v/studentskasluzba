package studentskasluzba.controller;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.model.BazaStudenata;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Student;
import studentskasluzba.view.GlavniProzor;

public class StudentController {

private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public boolean addStudent(Student s) {
		
		if(BazaStudenata.getInstance().addStudent(s)) {
			GlavniProzor.getInstance().azurirajPrikaz();
			GlavniProzor.getInstance().saveAllDBs();
			return true;
		} else {
			return false;
		}
		
	}
	
	public void editStudent(Student s) {
		
		BazaStudenata.getInstance().izmeniStudenta(s.getIme(), s.getPrezime(), s.getDatumRodjenja(), s.getAdresaStanovanja(), s.getKontaktTelefon(), s.getEmail(), s.getIndeks(), s.getDatumUpisa(), s.getTrenutnaGodina(), s.getStatusStudenta(), s.getProsecnaOcena());
		
		/*for(Predmet p : BazaStudenata.getInstance().getStudent(s.getIndeks()).getPredmeti()) {
			if(p.getGodina() != Integer.parseInt(s.getTrenutnaGodina())) {
				BazaStudenata.getInstance().getStudent(s.getIndeks()).removePredmet(p);
				p.removeStudent(s);
			}
		}*/
		
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
		
	}
	
	public void removeStudent(int selectedRow) {
		
		if(selectedRow < 0) {
			return;
		}
		
		Student s = BazaStudenata.getInstance().getStudent(selectedRow);
		
		// treba da uklonimo studenta i sa predmeta
		for(Predmet p : BazaPredmet.getInstance().getPredmete()) {
			if(p.getStudenti().contains(s)) {
				p.removeStudent(s);
			}
		}
		
		BazaStudenata.getInstance().removeStudent(selectedRow);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
		
	}
	
	public void addStudentNaPredmet(String brIndeksa, int selectedRow) {
		
		Student s = BazaStudenata.getInstance().getStudent(brIndeksa);
		Predmet p = BazaPredmet.getInstance().getPredmet(selectedRow);
		
		p.addStudent(s);
		BazaStudenata.getInstance().getStudent(brIndeksa).addPredmet(p);
		GlavniProzor.getInstance().saveAllDBs();
		
		
		
	}
	
	public void removeStudentSaPredmeta(int selectedRowPredmet, int selectedRowStudent) {
		
		Student s = BazaPredmet.getInstance().getPredmet(selectedRowPredmet).getStudent(selectedRowStudent);
		Predmet p = BazaPredmet.getInstance().getPredmet(selectedRowPredmet);
		s.removePredmet(p);
		p.removeStudent(selectedRowStudent);
		
		
		
	}

	
	public Student getStudent(int selectedRow) {
		
		return BazaStudenata.getInstance().getStudent(selectedRow);
	}
}
