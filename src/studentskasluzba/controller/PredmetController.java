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
	
	public static PredmetController getInstance()
	{
		if(instance == null)
		{
			instance = new PredmetController();
		}
		
		return instance;
	}
	
	public boolean addPredmet(Predmet p)
	{
		// NOTE(Jovan): Dodajemo predmet i cuvamo podatke
		if(BazaPredmet.getInstance().addPredmet(p))
		{
			// NOTE(Jovan): Provera da li je profesor vec postavljen
			// na predmet
			if(!p.getProfesor().getIme().equalsIgnoreCase("NEMA"))
			{
				for(Profesor prof : BazaProfesor.getInstance().getProfesore())
				{
					if(prof.getBrLicneKarte().equalsIgnoreCase(p.getProfesor().getBrLicneKarte()))
					{
						prof.addPredmet(p);
						break;
					}
				}
			}
			
			// NOTE(Jovan): Azuriranje prikaza i cuvanje podataka
			GlavniProzor.getInstance().azurirajPrikaz();
			GlavniProzor.getInstance().saveAllDBs();
			return true;
		}
		else
		{
			return false;
		}
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
		
		// NOTE(Jovan): Konacno uklanjamo predmet i cuvamo podatke
		BazaPredmet.getInstance().removePredmet(row);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
	
	public boolean editPredmet(Predmet p)
	{
		boolean Result = false;
		Result = BazaPredmet.getInstance().editPredmet(p);
		if(Result)
		{
			// NOTE(Jovan): Ako je izmena primljena azuriraj profesore i studente
			for(Profesor prof : BazaProfesor.getInstance().getProfesore())
			{
				if(prof.getPredmet(p.getSifra()).equals(p))
				{
					// NOTE(Jovan): Ako profesor vise nije na predmetu, 
					// azuriraj profesora
					if(!p.getProfesor().equals(prof))
					{
						prof.removePredmet(p);
					}
				}
			}
			
			// NOTE(Jovan): Provera ogranicenja sa studentima i azuriranje
			for(Student s : BazaStudenata.getInstance().getStudente())
			{
				if(s.getTrenutnaGodina() != p.getGodina())
				{
					
				}
			}
			// NOTE(Jovan): I konacno azuriraj prikaz i sacuvaj sve podatke
			GlavniProzor.getInstance().azurirajPrikaz();
			GlavniProzor.getInstance().saveAllDBs();
		}
		return Result;
	}
	
	// NOTE(Jovan): Uklanjanje profesora sa predmeta
	public void removeProfesor(int row)
	{
		// NOTE(Jovan): Uklanjamo predmet kod profesora
		Predmet p = BazaPredmet.getInstance().getPredmet(row);
		Profesor prof = p.getProfesor();
		prof.removePredmet(p);
		
		// NOTE(Jovan): Konacno uklanjamo profesora sa predmeta
		// i cuvamo podatke
		BazaPredmet.getInstance().getPredmet(row).removeProfesor();
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
}
