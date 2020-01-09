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
	
	private ArrayList<String> obelezja;
	private ArrayList<Predmet> torke;
	
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
		this.obelezja = new ArrayList<String>();
		this.torke = new ArrayList<Predmet>();
		
		obelezja.add("\u0160ifra");
		obelezja.add("Naziv");
		obelezja.add("Semestar");
		obelezja.add("Godina");
		obelezja.add("Profesor");
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
					this.torke.add(p);
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

				for (Predmet p : this.torke)
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
		this.torke.clear();
	}
	
	public boolean addPredmet(Predmet p)
	{
		for(Predmet predmet : torke) {
			if (predmet.getSifra().equals(p.getSifra())) {
				return false;
			}
		}
		this.torke.add(p);
		return true;
	}
	
	public void removePredmet(int row)
	{
		this.torke.remove(row);
	}
	
	public ArrayList<Predmet> getPredmete()
	{
		return this.torke;
	}
	
	public boolean editPredmet(Predmet p)
	{
		boolean Result = false;
		// NOTE(Jovan): Trazi predmet, ako postoji, azurira ga
		for(Predmet predmet : this.torke)
		{
			if(predmet.getSifra().equalsIgnoreCase(p.getSifra()))
			{
				predmet.setNaziv(p.getNaziv());
				predmet.setSemestar(p.getSemestar());
				predmet.setGodina(p.getGodina());
				predmet.setProfesor(p.getProfesor());
				
				Result = true;
				break;
			}
		}
		return Result;
	}
	
	public Predmet getPredmet(int row)
	{
		Predmet Result = null;
		if(row < this.torke.size())
		{
			Result = this.torke.get(row);
		}
		return Result;
	}
	
	public Predmet getPredmet(Predmet p)
	{
		Predmet Result = null;
		for(Predmet pr : this.torke)
		{
			if(pr.equals(p))
			{
				Result = pr;
				break;
			}
		}
		return Result;
	}
	
	public int getBrojObelezja()
	{
		return this.obelezja.size();
	}
	
	public int getBrojTorki()
	{
		return this.torke.size();
	}
	
	public String getValueAt(int row, int column)
	{
		Predmet Result = torke.get(row);
		
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
		return obelezja.get(col);
	}
	
}
