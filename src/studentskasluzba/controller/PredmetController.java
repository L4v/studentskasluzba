package studentskasluzba.controller;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.BazaStudenata;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Profesor;
import studentskasluzba.model.Student;
import studentskasluzba.view.GlavniProzor;

public class PredmetController {
	private static PredmetController instance = null;
	
	private PredmetController()
	{
		
	}
	
	public PredmetController getInstance()
	{
		if(instance == null)
		{
			instance = new PredmetController();
		}
		
		return instance;
	}
	
	public void addPredmet(Predmet p)
	{
		BazaPredmet.getInstance().addPredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
	
	public void removePredmet(int row)
	{
		// NOTE(Jovan): Uzimamo predmet koji cemo ukloniti
		// kako bismo mogli azurirati ostale baze
		Predmet p = BazaPredmet.getInstance().getPredmet(row);
		
		// NOTE(Jovan): Uklanjamo predmet kod svakog studenta
		for(Student s : BazaStudenata.getInstance().getStudente())
		{
			if(s.getPredmeti().contains(p))
			{
				s.removePredmet(p);
			}
		}
		
		// NOTE(Jovan): Uklanjamo predmet kod svakog profesora
		for(Profesor prof : BazaProfesor.getInstance().getProfesore())
		{
			if(prof.getPredmet(p.getSifra())!= null)
			{
				prof.removePredmet(p);
			}
		}
		
		// NOTE(Jovan): Konacno uklanjamo predmet
		BazaPredmet.getInstance().removePredmet(row);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
	
	public void editPredmet(Predmet p)
	{
		BazaPredmet.getInstance().editPredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
}
