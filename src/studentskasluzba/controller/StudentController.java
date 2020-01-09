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
			return true; // uspesno dodavanje
		} else {
			return false;
		}
		
	}
	
	public void editStudent(Student s) {
		
		BazaStudenata.getInstance().izmeniStudenta(s.getIme(), s.getPrezime(), s.getDatumRodjenja(), s.getAdresaStanovanja(), s.getKontaktTelefon(), s.getEmail(), s.getIndeks(), s.getDatumUpisa(), s.getTrenutnaGodina(), s.getStatusStudenta(), s.getProsecnaOcena());
		
		for(Predmet p : BazaStudenata.getInstance().getStudent(s.getIndeks()).getPredmeti()) { //ukoliko se promeni godina studija proveri predmete i ukloni one koji ne ispunjavaju uslov da je ista godina u pitanju
			if(p.getGodina() != s.getTrenutnaGodina()) {
				p.removeStudent(s);
				BazaStudenata.getInstance().getStudent(s.getIndeks()).removePredmet(p);
				
				//proveri da li ima jos predmeta
				if(BazaStudenata.getInstance().getStudent(s.getIndeks()).getPredmeti().size()==0)
					break;
			}
		}
		
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
	
	public int addStudentNaPredmet(String brIndeksa, int selectedRow) {
		
		Student s = BazaStudenata.getInstance().getStudent(brIndeksa);
		if(s == null) {  // ako student ne postoji u bazi
			return 1;
		}
		Predmet p = BazaPredmet.getInstance().getPredmet(selectedRow);
		
		if (s.getTrenutnaGodina()!=p.getGodina()) {
			return 2;   //ako tren god studenta nije ista sa predmetom
		}
		if(!p.addStudent(s)) {
			return 3;   //ako student vec pohadja predmet
		}
		BazaStudenata.getInstance().getStudent(brIndeksa).addPredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
		
		return 0;
	}
	
	public void removeStudentSaPredmeta(int selectedRowPredmet, int selectedRowStudent) {
		
		Predmet p = BazaPredmet.getInstance().getPredmet(selectedRowPredmet);
		p.removeStudent(selectedRowStudent);
		BazaPredmet.getInstance().getPredmet(selectedRowPredmet).getStudent(selectedRowStudent).removePredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
		
	}
	
	public Student getStudent(int selectedRow) {
		return BazaStudenata.getInstance().getStudent(selectedRow);
	}
	
	public void pretragaStudenta(String tokens) {
		if(tokens.equalsIgnoreCase("")) {    // da se vrati u prvobitan polozaj iz filtriranja u normalno stanje
			GlavniProzor.getInstance().getStudentTable().clearFilter();
			GlavniProzor.getInstance().azurirajPrikaz();
		}
		
		String[] token = tokens.split(":");
		
		if(token.length < 2) { // ukoliko nesto nije navedeno 
			return;
		}
		
		switch(token[0]){
			case "ime" : {
				GlavniProzor.getInstance().getStudentTable().setFilter(token[1], 1);
				GlavniProzor.getInstance().azurirajPrikaz();
			} break;
			case "prezime" : {
				GlavniProzor.getInstance().getStudentTable().setFilter(token[1], 2);
				GlavniProzor.getInstance().azurirajPrikaz();
			} break;
			case "indeks" : {
				GlavniProzor.getInstance().getStudentTable().setFilter(token[1], 0);
				GlavniProzor.getInstance().azurirajPrikaz();
			} break;
			default: return;
		}
	}
	
	
	
}
