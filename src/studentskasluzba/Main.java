package studentskasluzba;

public class Main {
	public static void main(String args[])
	{
		// NOTE(Jovan): Instancira bazu studenata
		BazaStudenata.getInstance();
		GlavniProzor prozor = new GlavniProzor();
		prozor.setVisible(true);
		
	}
}
