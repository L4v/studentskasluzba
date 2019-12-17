package studentskasluzba;

import java.util.ArrayList;

public class BazaProfesor {
	private static BazaProfesor instance = null;
	
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
		
		
		Obelezja.add("BR_LICNE_KARTE");
		Obelezja.add("IME");
		Obelezja.add("PREZIME");
		Obelezja.add("TITULA");
		Obelezja.add("ZVANJE");
		Obelezja.add("DATUM_RODJENJA");
		Obelezja.add("ADRESA_ST.");
		Obelezja.add("TELEFON");
		Obelezja.add("EMAIL");
		Obelezja.add("ADRESA_K");
		
		Profesor tmp = new Profesor("Savo", "Oroz", "01.01.1901", "Balzakova 69", "0607671370",
				"savo.oroz@savoandco.com", "Savin Trg 5", "123456789", "Nzm", "Nempojma");
		Profesor tmp2 =new Profesor("Petar", "Peric", "11.01.1901", "Aalzakova 69", "0607671370",
				"petar.per@savoandco.com", "Savin Trg 5", "435456789", "Ne znam", "Nemam pojma");
		Torke.add(tmp);
		Torke.add(tmp2);
	}
	
	public void addProfesor(Profesor p)
	{
		// TODO(Jovan): Provera da li vec postoji?
		this.Torke.add(p);
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	public void removeProfesor(int row)
	{
		this.Torke.remove(row);
		GlavniProzor.getInstance().azurirajPrikaz();
	}
	
	public ArrayList<Profesor> getProfesore()
	{
		return this.Torke;
	}
	
	public Profesor getProfesor(int row) {
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
	}
	
}
