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
	
	public void pretraziProfesor(String pairs)
	{
		if(pairs.equalsIgnoreCase(""))
		{
			GlavniProzor.getInstance().getProfesorTable().clearFilter();
			GlavniProzor.getInstance().azurirajPrikaz();	
		}
		String[] pair = pairs.split(":");
		if(pair.length < 2)
		{
			return;
		}
		switch(pair[0])
		{
			case "ime":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[1], 1);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "prezime":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[1], 2);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "licna karta":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[1], 0);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "titula":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[1], 3);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "zvanje":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[1], 4);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "datum rodjenja":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[1], 5);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "adresa stanovanja":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[1], 6);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "telefon":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[7], 0);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "email":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[8], 0);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			case "adresa kancelarije":
			{
				GlavniProzor.getInstance().getProfesorTable().setFilter(pair[9], 0);
				GlavniProzor.getInstance().azurirajPrikaz();
			}break;
			default: return;
		}
	}
	
	public Iterable<Profesor> getProfesore()
	{
		return BazaProfesor.getInstance().getProfesore();
	}
	
	public Profesor getProfesor(int selectedRow) {
		return BazaProfesor.getInstance().getProfesor(selectedRow);
	}
}
