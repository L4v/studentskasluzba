package studentskasluzba;

import java.util.ArrayList;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;

	private ArrayList<String> atributi;
	private ArrayList<Student> torke;
	
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
		atributi = new ArrayList<String>();
		torke = new ArrayList<Student>();
		
		atributi.add("Broj indeksa");
		atributi.add("Ime");
		atributi.add("Prezime");
		atributi.add("Godina studija");
		atributi.add("Status");
		atributi.add("Prosek");
		atributi.add("Datum upisa");
		atributi.add("Kontakt telefon");
		atributi.add("Email");
		atributi.add("Adresa");
		atributi.add("Datum ro\u0111enja");
		
		Student st1 = new Student("Petar", "Petrovi\u0107", "09.01.1998","Njego\u0161eva 50","0609988776","petar.petrovic@mail.com","RA350/17","05.07.2017","3",StatusStudent.B,9.12);
		Student st2 = new Student("Marko", "Markovi\u0107","20.06.1999","Tolstojeva 33","0610011223","marko.markovic99@mail.com","RA333/18","04.07.2018","2",StatusStudent.S,8.69);
		Student st3 = new Student("Jovana", "Jovanovi\u0107", "07.10.2000","\u0160ekspirova 10","0621234567","jovana.jovanovic123@mail.com","RA367/19","06.07.2019","1",StatusStudent.B,9.50);
		torke.add(st1);
		torke.add(st2);
		torke.add(st3);
	}
	
	public void addStudent(Student s)
	{
		this.torke.add(s);
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	public void removeStudent(int row)
	{
		this.torke.remove(row);
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	public ArrayList<Student> getStudente()
	{
		return this.torke;
	}
	
	public Student getStudent(int row) {
		return this.torke.get(row);
	}
	
	public int getBrojAtributa()
	{
		return this.atributi.size();
	}
	
	public int getBrojTorki()
	{
		return this.torke.size();
	}
	
	public String getValueAt(int row, int column)
	{
		Student Result = torke.get(row);
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
				if (Result.getStatusStudenta()==StatusStudent.B)
					return "B";
				else
					return "S";
			}
			case 5:
			{
				return Double.toString(Result.getProsecnaOcena());
			}
			case 6:
			{
				return Result.getDatumUpisa();
			}
			case 7:
			{
				return Result.getKontaktTelefon();
			}
			case 8:
			{
				return Result.getEmail();
			}
			case 9:
			{
				return Result.getAdresaStanovanja();
			}
			case 10:
			{
				return Result.getDatumRodjenja();
			}
			default:
				return null;
		
		}
	}

	public String getColumnName(int column) {
		return atributi.get(column);
	}
	
}
