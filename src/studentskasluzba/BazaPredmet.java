package studentskasluzba;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BazaPredmet {
	private static BazaPredmet instance = null;
	
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
		
		Obelezja.add("SIFRA");
		Obelezja.add("NAZIV");
		Obelezja.add("SEMESTAR");
		Obelezja.add("GODINA");
		Obelezja.add("PROFESOR");
		Profesor savo = new Profesor("Savo", "Oroz", "01.01.1901", "Balzakova 69", "0607671370",
				"savo.oroz@savoandco.com", "Savin Trg 5", "123456789", "Nzm", "Nempojma");
		Predmet tmp = new Predmet("OOP-1", "Objektno", 2, 1, savo);
		
		Torke.add(tmp);
		loadDB();
	}
	
	public void loadDB()
	{
		FileInputStream fi;
		try {
			fi = new FileInputStream(new File("PredmetiDB.sdb"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			Predmet p = (Predmet)oi.readObject();
			addPredmet(p);
			fi.close();
			oi.close();
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
		for (Predmet p : this.Torke)
		{
			try {
				FileOutputStream f = new FileOutputStream(new File("PredmetiDB.sdb"));
				ObjectOutputStream o = new ObjectOutputStream(f);
				
				o.writeObject(p);
				f.close();
				o.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addPredmet(Predmet p)
	{
		// TODO(Jovan): Provera postojanja?
		this.Torke.add(p);
		//this.saveDB();
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	public void removePredmet(int row)
	{
		this.Torke.remove(row);
		//this.saveDB();
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	public ArrayList<Predmet> getPredmete()
	{
		return this.Torke;
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
