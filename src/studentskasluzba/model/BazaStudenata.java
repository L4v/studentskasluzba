package studentskasluzba.model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.StatusStudent;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	private static final String NAME_DB = "StudentiDB.sdb";

	private ArrayList<String> atributi;
	private ArrayList<Student> studenti;
	
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
		studenti = new ArrayList<Student>();
		
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
	}
	
	public void loadDB()
	{
		FileInputStream fi;
			try {
				// Ukoliko fajl ne postoji, napravi
				File dbFile = new File(NAME_DB);
				dbFile.createNewFile();
				fi = new FileInputStream(new File(NAME_DB));
				ObjectInputStream oi = null;
				try 
				{
					oi = new ObjectInputStream(fi);
				}catch(EOFException e)
				{
					// Ovo ce se okinuti u slucaju da je kreiran prazan fajl,
					// pa izlazimo iz metode
					fi.close();
					return;
				}

				// obrisi bazu kako bi ucitali novu
				dropDB();
					// Ne pozivamo addStudent metodu jer moze doci do kruznog
					// pozivanja koda, pa do stack overflowa kada se popuni backtrace

				Student s;
				do 
				{
					try {
						s = (Student)oi.readObject();
						this.studenti.add(s);
					}
					catch(EOFException e)
					{
						// Kada dodje do kraja file-a, izbacice EOF exception,
						// pa ga ovde hvatamo i prekidamo petlju
						break;
					}
				}while(s != null);
				
				fi.close();
				oi.close();
			GlavniProzor.getInstance().azurirajPrikaz();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void saveDB()
	{
			try {
				FileOutputStream f = new FileOutputStream(new File(NAME_DB));
				ObjectOutputStream o = new ObjectOutputStream(f);

				for (Student s : this.studenti)
				{
					o.writeObject(s);
				}
				f.close();
				o.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	// Prilikom loadovanja da obrise celu bazu
	private void dropDB()
	{
		this.studenti.clear();
		GlavniProzor.getInstance().azurirajPrikaz();
	}

	
	public boolean addStudent(Student s)
	{
		for(Student student : studenti) {
			if (student.getIndeks().equals(s.getIndeks())) {
				return false;
			}
		}
		this.studenti.add(s);
		return true;
	}
	
	public void removeStudent(int row)
	{
		this.studenti.remove(row);
	}
	
	public ArrayList<Student> getStudente()
	{
		return this.studenti;
	}
	
	public Student getStudent(int row) {
		return this.studenti.get(row);
	}
	
	public Student getStudent(String brIndeksa) {
		for(Student s : studenti) {
			if(s.getIndeks().equalsIgnoreCase(brIndeksa)) {
				return s;
			}
		}
		return null;
	}
	
	public int getBrojAtributa()
	{
		return this.atributi.size();
	}
	
	public int getBrojTorki()
	{
		return this.studenti.size();
	}
	
	public String getValueAt(int row, int column)
	{
		Student Result = studenti.get(row);
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
				return Integer.toString(Result.getTrenutnaGodina());
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
	
	public void izmeniStudenta(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String email, String brojIndeksa, String datumUpisa, int trenutnaGodStudija, StatusStudent statusStudenta, double prosecnaOcena) {
		for (Student s : studenti) {
			if (s.getIndeks().equals(brojIndeksa)) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresaStanovanja(adresaStanovanja);
				s.setKontaktTelefon(kontaktTelefon);
				s.setEmail(email);
				s.setIndeks(brojIndeksa);
				s.setDatumUpisa(datumUpisa);
				s.setTrenutnaGodina(trenutnaGodStudija);
				s.setStatusStudenta(statusStudenta);
				s.setProsecnaOcena(prosecnaOcena);
			}
		}
	}
	
}
