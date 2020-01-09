package studentskasluzba.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {
	private static final long serialVersionUID = 6394180833275172534L;
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String adresaKancelarije;
	private String brLicneKarte;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> predmeti;
	
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor()
	{
		predmeti = new ArrayList<Predmet>();
	}
	
	public void addPredmet(Predmet p)
	{
		if(this.predmeti.contains(p))
		{
			return;
		}
		predmeti.add(p);
	}
	
	public Predmet getPredmet(String sifra)
	{
		Predmet Result = null;
		for(Predmet p : this.predmeti)
		{
			if(p.getSifra().equalsIgnoreCase(sifra))
			{
				Result = p;
				break;
			}
		}
		return Result;
	}

	public Predmet getPredmet(int i)
	{
		return this.predmeti.get(i);
	}
	
	public ArrayList<Predmet> getPredmeti(){
		return this.predmeti;
	}
	
	public void removePredmet(Predmet p) {
		this.predmeti.remove(p);
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrLicneKarte() {
		return brLicneKarte;
	}

	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	
	@Override
	public String toString()
	{
		String Result;
		if(this.brLicneKarte.equalsIgnoreCase("null"))
		{
			Result = this.brLicneKarte;
		}
		else	
		{
			Result = this.brLicneKarte + ", " + this.ime + " " + this.prezime;
		}
		return Result;
	}

	// NOTE(Jovan): Posto je broj licne karte unikatan, dovoljna je provera
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
		{
			return true;
		}
		if(!(obj instanceof Profesor))
		{
			return false;
		}
		Profesor p = (Profesor)obj;
		if(p.getBrLicneKarte().equalsIgnoreCase(this.brLicneKarte))
		{
			return true;
		}
		return false;
	}
	
}
