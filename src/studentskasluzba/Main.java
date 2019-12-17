package studentskasluzba;

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
