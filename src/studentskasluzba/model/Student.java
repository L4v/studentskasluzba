package studentskasluzba.model;

import java.io.Serializable;
import java.util.ArrayList;

import studentskasluzba.view.StatusStudent;

public class Student implements Serializable{

	private static final long serialVersionUID = 237914519209480301L;
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String brojIndeksa;
	private String datumUpisa;
	private String trenutnaGodStudija;
	private StatusStudent statusStudenta;
	private double prosecnaOcena;
	private ArrayList<Predmet> predmeti;
	
	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, String datumUpisa, String trenutnaGodStudija, StatusStudent statusStudenta,
			double prosecnaOcena) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.datumUpisa = datumUpisa;
		this.trenutnaGodStudija = trenutnaGodStudija;
		this.statusStudenta = statusStudenta;
		this.prosecnaOcena = prosecnaOcena;
		predmeti = new ArrayList<Predmet>();
	}
	
	public Student()
	{
		predmeti = new ArrayList<Predmet>();
	}
	
	public void addPredmet(Predmet p)
	{
		predmeti.add(p);
	}
	
	public Predmet getPredmet(int i)
	{
		return predmeti.get(i);
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

	public String getIndeks() {
		return brojIndeksa;
	}

	public void setIndeks(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public String getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getTrenutnaGodina() {
		return trenutnaGodStudija;
	}

	public void setTrenutnaGodina(String trenutnaGodStudija) {
		this.trenutnaGodStudija = trenutnaGodStudija;
	}

	public StatusStudent getStatusStudenta() {
		return statusStudenta;
	}

	public void setStatusStudenta(StatusStudent statusStudenta) {
		this.statusStudenta = statusStudenta;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	// NOTE(Jovan -> Kris): Sluzi za uklanjanje pomocu .remove()
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
		{
			return true;
		}
		if(!(obj instanceof Student))
		{
			return false;
		}
		Student s = (Student)obj;
		if(s.getIndeks().equalsIgnoreCase(this.brojIndeksa))
		{
			return true;
		}
		return false;
	}
	
}
