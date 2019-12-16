package studentskasluzba;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {
	private static final long serialVersionUID = -963371116330390736L;
	private String sifra;
	private String naziv;
	private int semestar;
	private int godina;
	private Profesor profesor;
	private ArrayList<Student> studenti;
	public Predmet(String sifra, String naziv, int semestar, int godina, Profesor profesor) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.profesor = profesor;
	}
	
	public Predmet()
	{
		studenti = new ArrayList<Student>();
	}

	public void addStudent(Student s)
	{
		studenti.add(s);
	}
	
	public Student getStudent(int i)
	{
		return studenti.get(i);
	}
	
	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
