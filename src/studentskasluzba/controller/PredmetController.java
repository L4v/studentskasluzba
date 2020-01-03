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
				// Uklanjanje ako treba
				if(prof.getPredmeti().contains(p))
				{
					if(!p.getProfesor().getBrLicneKarte().equalsIgnoreCase(prof.getBrLicneKarte()))
					{
						prof.removePredmet(p);
					}
				}
				else
				{
					// NOTE(Jovan): Ako prof ne sadrzi jos predmet, a treba dodati
					if(p.getProfesor().getBrLicneKarte().equalsIgnoreCase(prof.getBrLicneKarte()))
					{
						prof.addPredmet(p);
					}
				}
			}
			// NOTE(Jovan): Provera ogranicenja sa studentima i azuriranje
			for(Student s : BazaStudenata.getInstance().getStudente())
			{
				// NOTE(Jovan): Ako sadrzi predmet, a ne ispunjava vise zahtev, ukloni
				if(s.getPredmeti().contains(p))
				{
					if(s.getTrenutnaGodina() != p.getGodina())
					{
						BazaPredmet.getInstance().getPredmet(p).removeStudent(s);
						s.removePredmet(p);
					}
				}
			}
			// NOTE(Jovan): I konacno azuriraj prikaz i sacuvaj sve podatke
			GlavniProzor.getInstance().azurirajPrikaz();
			GlavniProzor.getInstance().saveAllDBs();
		}
		return Result;
	}
	
	public Predmet getSelektovan()
	{
		Predmet Result = BazaPredmet.getInstance().getPredmet(GlavniProzor.getInstance().getSelektovanuTorku());
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
	
	/* NOTE(Jovan): Error kodovi:
	 * 0  - Proslo kako treba
	 * -1 - Postoji vec profesor na predmetu
	 * -2 - Zeljeni profesor ne postoji 
	 */
	public int addProfesor(int row, String lk)
	{
		int Result = 0;
		boolean Found = false;
		Predmet predmet = BazaPredmet.getInstance().getPredmet(row);
		if(predmet.getProfesor().getBrLicneKarte().equalsIgnoreCase("NEMA"))
		{
			for(Profesor p : BazaProfesor.getInstance().getProfesore())
			{
				if(p.getBrLicneKarte().equalsIgnoreCase(lk))
				{
					Found = true;
					// NOTE(Jovan): Dodavanje predmeta kod profesora
					BazaProfesor.getInstance().getProfesor(p.getBrLicneKarte()).addPredmet(BazaPredmet.getInstance().getPredmet(row));
					
					// NOTE(Jovan): Dodavanje profesora na predmet i azuriranje
					BazaPredmet.getInstance().getPredmet(row).setProfesor(p);
					GlavniProzor.getInstance().azurirajPrikaz();
					GlavniProzor.getInstance().saveAllDBs();
					break;
				}
			}
			if(!Found)
			{
				Result = -2;
			}
		}
		else
		{
			Result = -1;
		}
		return Result;
	}
	
	public void pretraziPredmet(String regex)
	{
		GlavniProzor.getInstance().getPredmetTable().setFilter(regex);
		GlavniProzor.getInstance().azurirajPrikaz();
	}
}
