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

public class BazaProfesor {
	private static BazaProfesor instance = null;
	private static final String NAME_DB = "ProfesoriDB.sdb";
	
	private ArrayList<String> Obelezja;
	private ArrayList<Profesor> Torke;
	
	public static BazaProfesor getInstance()
	{
		if(instance == null)
		{
			instance = new BazaProfesor();
		}
		return instance;
	}
	
	private BazaProfesor()
	{
		Obelezja = new ArrayList<String>();
		Torke = new ArrayList<Profesor>();
		
		
		Obelezja.add("Broj li\u010dne karte");
		Obelezja.add("Ime");
		Obelezja.add("Prezime");
		Obelezja.add("Titula");
		Obelezja.add("Zvanje");
		Obelezja.add("Datum ro\u0111enja");
		Obelezja.add("Adresa stanovanja");
		Obelezja.add("Telefon");
		Obelezja.add("Email");
		Obelezja.add("Adresa kancelarije");
	}
	

	public void loadDB()
	{
		FileInputStream fi;
			try {
				// NOTE(Jovan): Ako ne postoji datoteka, napravice je
				File dbFile = new File(NAME_DB);
				dbFile.createNewFile();
				fi = new FileInputStream(new File(NAME_DB));
				ObjectInputStream oi = null;
				try 
				{
					oi = new ObjectInputStream(fi);
				}catch(EOFException e)
				{
					// NOTE(Jovan): Ovo ce se okinuti u slucaju da je kreiran prazan fajl,
					// pa izlazimo iz metode
					fi.close();
					return;
				}
			
			// NOTE(Jovan): Drop bazu kako bi ucitali novu
			dropDB();
				// NOTE(Jovan): Ne pozivamo addProfesor metodu jer moze doci do kruznog
				// pozivanja koda, pa do stack overflowa kada se popuni backtrace
			Profesor p;
			do
			{
				try {
					p = (Profesor)oi.readObject();
					this.Torke.add(p);
				}
				catch(EOFException e)
				{
					// NOTE(Jovan): Kada dodje do kraja file-a, izbacice EOF exception,
					// pa ga ovde hvatamo i prekidamo petlju
					break;
				}
			}while(p != null);
			
			oi.close();
			fi.close();
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
		FileOutputStream f = null;
		ObjectOutputStream o = null;
			try {
				f = new FileOutputStream(new File(NAME_DB));
				o = new ObjectOutputStream(f);
				
				for (Profesor p : this.Torke)
				{
					if(f == null || o == null)
					{
						// NOTE(Jovan): Ako nije nasao fajl, nista
						break;
					}
					o.writeObject(p);
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
	
	// NOTE(Jovan): Prilikom loadovanja da dropuje celu bazu
	private void dropDB()
	{
		this.Torke.clear();
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	
	public boolean addProfesor(Profesor p)
	{
		for(Profesor profesor : Torke) {
			if(profesor.getBrLicneKarte().equals(p.getBrLicneKarte())) {
				return false;
			}
		}
		this.Torke.add(p);
		return true;
	}
	
	public void removeProfesor(int row)
	{
		this.Torke.remove(row);
		GlavniProzor.getInstance().azurirajPrikaz();
		saveDB();
	}
	
	public void editProfesor(Profesor p)
	{
		for(Profesor profesor : this.Torke)
		{
			if(profesor.getBrLicneKarte().equalsIgnoreCase(p.getBrLicneKarte()))
			{
				profesor.setIme(p.getIme());
				profesor.setPrezime(p.getPrezime());
				profesor.setDatumRodjenja(p.getDatumRodjenja());
				profesor.setAdresaStanovanja(p.getAdresaStanovanja());
				profesor.setKontaktTelefon(p.getKontaktTelefon());
				profesor.setEmail(p.getEmail());
				profesor.setAdresaKancelarije(p.getAdresaKancelarije());
				profesor.setTitula(p.getTitula());
				profesor.setZvanje(p.getZvanje());
				return;
			}
		}
	}
	
	public ArrayList<Profesor> getProfesore()
	{
		return this.Torke;
	}
	
	public Profesor getProfesor(int row) {
		return this.Torke.get(row);
	}
	
	public Profesor getProfesor(String lk)
	{
		Profesor Result = null;
		for(Profesor p : this.Torke)
		{
			if(p.getBrLicneKarte().equalsIgnoreCase(lk))
			{
				Result = p;
				// NOTE(Jovan): Nema duplikata
				break;
			}
		}
		return Result;
	}
	
	public int getBrojObelezja()
	{
		return this.Obelezja.size();
	}
	
	public int getBrojTorki()
	{
		return this.Torke.size();
	}
	
	public String getValueAt(int row, int column)
	{
		Profesor Result = Torke.get(row);
		switch(column)
		{
			case 0:
			{
				return Result.getBrLicneKarte();
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
				return Result.getTitula();
			}
			case 4:
			{
				return Result.getZvanje();
			}
			case 5:
			{
				return Result.getDatumRodjenja();
			}
			case 6:
			{
				return Result.getAdresaStanovanja();
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
				return Result.getAdresaKancelarije();
			}
			default:
				return null;
		
		}
	}

	public String getColumnName(int column) {
		return Obelezja.get(column);
	}
	
	public void izmeniProfesora(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		for(Profesor p : Torke) {
			if(p.getBrLicneKarte().equals(brLicneKarte)) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setDatumRodjenja(datumRodjenja);
				p.setAdresaStanovanja(adresaStanovanja);
				p.setKontaktTelefon(kontaktTelefon);
				p.setEmail(email);
				p.setAdresaKancelarije(adresaKancelarije);
				p.setBrLicneKarte(brLicneKarte);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
		GlavniProzor.getInstance().azurirajPrikaz();
		saveDB();
	}
	
}
