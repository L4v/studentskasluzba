package studentskasluzba.controller;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.GlavniProzor;

public class ProfesorController {
	private static ProfesorController instance = null;
	
	private ProfesorController()
	{
		
	}
	
	public static ProfesorController getInstance()
	{
		if(instance == null)
		{
			instance = new ProfesorController();
		}
		return instance;
	}
	
	public boolean addProfesor(Profesor p)
	{
		if(BazaProfesor.getInstance().addProfesor(p)) {
			GlavniProzor.getInstance().azurirajPrikaz();
			GlavniProzor.getInstance().saveAllDBs();
			return true;
		} else {
			return false;
		}
	}
	
	public void removeProfesor(int row)
	{
		// NOTE(Jovan): Uklanjamo profesora sa svakog predmeta
		Profesor prof = BazaProfesor.getInstance().getProfesor(row);
		for(Predmet p : BazaPredmet.getInstance().getPredmete())
		{
			if(p.getProfesor().equals(prof)) 
			{
				p.removeProfesor();
			}
		}
		
		// NOTE(Jovan): Uklanjanje profesora i cuvanje podatak
		BazaProfesor.getInstance().removeProfesor(row);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
	
	public void editProfesor(Profesor p)
	{
		BazaProfesor.getInstance().editProfesor(p);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
	
	public Iterable<Profesor> getProfesore()
	{
		return BazaProfesor.getInstance().getProfesore();
	}
	
	public Profesor getProfesor(int selectedRow) {
		return BazaProfesor.getInstance().getProfesor(selectedRow);
	}
}
