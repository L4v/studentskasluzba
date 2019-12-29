package studentskasluzba.controller;

import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.GlavniProzor;

public class ProfesorController {
	private static ProfesorController instance = null;
	
	private ProfesorController()
	{
		
	}
	
	public ProfesorController getInstance()
	{
		if(instance == null)
		{
			instance = new ProfesorController();
		}
		return instance;
	}
	
	public void addProfesor(Profesor p)
	{
		BazaProfesor.getInstance().addProfesor(p);
		GlavniProzor.getInstance().azurirajPrikaz();
		GlavniProzor.getInstance().saveAllDBs();
	}
	
	public void removeProfesor(int row)
	{
		BazaProfesor.getInstance().removeProfesor(row);
	}
	
	public void editProfesor(Profesor p)
	{
		
	}
}
