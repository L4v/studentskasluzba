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

public class BazaPredmet {
	private static BazaPredmet instance = null;
	private static final String NAME_DB = "PredmetiDB.sdb";
	
	private ArrayList<String> Obelezja;
	private ArrayList<Predmet> Torke;
	
	public static BazaPredmet getInstance()
	{
		if(instance == null)
		{
			instance = new BazaPredmet();
		}
		return instance;
	}
	
	private BazaPredmet()
	{
		this.Obelezja = new ArrayList<String>();
		this.Torke = new ArrayList<Predmet>();
		
		Obelezja.add("\u0160ifra");
		Obelezja.add("Naziv");
		Obelezja.add("Semestar");
		Obelezja.add("Godina");
		Obelezja.add("Profesor");
		Profesor savo = new Profesor("Savo", "Oroz", "01.01.1901", "Balzakova 69", "0607671370",
				"savo.oroz@savoandco.com", "Savin Trg 5", "123456789", "Nzm", "Nempojma");
		Predmet tmp = new Predmet("OOP-1", "Objektno", 2, 1, savo);
		
		Torke.add(tmp);
	}
	public void loadDB()
	{
		try {
			// NOTE(Jovan): Ako ne postoji fajl, napravi
			File dbFile = new File(NAME_DB);
			dbFile.createNewFile();
			FileInputStream fi = new FileInputStream(new File(NAME_DB));
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
				// NOTE(Jovan): Ne pozivamo addPredmet metodu jer moze doci do kruznog
				// pozivanja koda, pa do stack overflowa kada se popuni backtrace
			Predmet p;
			do 
			{
				try {
					p = (Predmet)oi.readObject();
					this.Torke.add(p);
				}
				catch(EOFException e)
				{
					// NOTE(Jovan): Kada dodje do kraja file-a, izbacice EOF exception,
					// pa ga ovde hvatamo i prekidamo petlju
					break;
				}
			}while(p != null);
			
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

				for (Predmet p : this.Torke)
				{
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
	
	public boolean addPredmet(Predmet p)
	{
		for(Predmet predmet : Torke) {
			if (predmet.getSifra().equals(p.getSifra())) {
				return false;
			}
		}
		this.Torke.add(p);
		this.saveDB();
		GlavniProzor.getInstance().azurirajPrikaz();
		return true;
	}
	
	public void removePredmet(int row)
	{
		this.Torke.remove(row);
		this.saveDB();
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	public ArrayList<Predmet> getPredmete()
	{
		return this.Torke;
	}
	
	public Predmet getPredmet(int row)
	{
		return this.Torke.get(row);
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
		Predmet Result = Torke.get(row);
		
		switch(column)
		{
			case 0:
			{
				return Result.getSifra();
			}
			case 1:
			{
				return Result.getNaziv();
			}
			case 2:
			{
				return Integer.toString(Result.getSemestar());
			}
			case 3:
			{
				return Integer.toString(Result.getGodina());
			}
			case 4:
			{
				return Result.getProfesor().getIme() + " " + Result.getProfesor().getPrezime();
			}
			default:
			{
				return null;
			}
		}
	}
	
	public String getColumnName(int col)
	{
		return Obelezja.get(col);
	}
	
}
