package studentskasluzba;

import java.util.ArrayList;

public class BazaStudenata {
	private static BazaStudenata instance = null;
	
	private ArrayList<String> Obelezja;
	private ArrayList<Student> Torke;
	
	public static BazaStudenata getInstance()
	{
		if(instance == null)
		{
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private BazaStudenata()
	{
		Obelezja = new ArrayList<String>();
		Torke = new ArrayList<Student>();
		
		Obelezja.add("Indeks");
		Obelezja.add("Ime");
		Obelezja.add("Prezime");
		Obelezja.add("Godina studija");
		Obelezja.add("Status");
		Obelezja.add("Prosek");
		ArrayList<Predmet> p = new ArrayList<Predmet>();
		
		Student tmp = new Student("Savo", "Oroz", "01.01.1901", "Balzakova 69", "0607671370",
			"savo.oroz@savoandco.com", "RA1-98", "10.10.1998", "Beskonacno", Status.S,
			10.0, p);
		Torke.add(tmp);
	}
	
	public ArrayList<Student> getStudents()
	{
		return this.Torke;
	}
	
	public String getValueAt(int row, int column)
	{
		Student Result = Torke.get(row);
		switch(column)
		{
			case 0:
			{
				return Result.getIndeks();
			}
			case 1:
			{
				return Result.getIme();
			}
			case 2:
			{
				return Result.getPrezime();
			}
			case 3:
			{
				return Result.getTrenutnaGodina();
			}
			case 4:
			{
				return Result.getStatusStudenta().toString();
			}
			case 5:
			{
				return String.valueOf(Result.getProsecnaOcena());
			}
			default:
				return null;
		
		}
	}

	public String getColumnName(int column) {
		return Obelezja.get(column);
	}
	
}
