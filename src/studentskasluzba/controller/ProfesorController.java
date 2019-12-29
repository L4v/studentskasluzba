package studentskasluzba.controller;

import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.Profesor;

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
	}
	
	public void removeProfesor(int row)
	{
		BazaProfesor.getInstance().removeProfesor(row);
	}
	
	public void editProfesor(Profesor p)
	{
		
	}
}
