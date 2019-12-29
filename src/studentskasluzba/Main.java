package studentskasluzba;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.BazaStudenata;
import studentskasluzba.view.GlavniProzor;

public class Main {
	public static void main(String args[])
	{
		// NOTE(Jovan): Instanciranje i ucitavanje
		BazaProfesor.getInstance();
		BazaPredmet.getInstance();
		BazaStudenata.getInstance();
		
		// TODO(Jovan->Kristian): Dodati ovo pls
		BazaStudenata.getInstance().loadDB();
		BazaProfesor.getInstance().loadDB();
		BazaPredmet.getInstance().loadDB();
		GlavniProzor prozor = GlavniProzor.getInstance();
		prozor.setVisible(true);
		
	}
}
