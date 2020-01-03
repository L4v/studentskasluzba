package studentskasluzba.model;

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
		this.studenti = new ArrayList<Student>();
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

	public ArrayList<Student> getStudenti()
	{
		return this.studenti;
	}
	
	public boolean addStudent(Student s)
	{
		for(Student st : this.studenti)
		{
			if(st.getIndeks().equalsIgnoreCase(s.getIndeks()))
			{
				return false;
			}
		}
		studenti.add(s);
		return true;
	}
	
	public void removeStudent(int i) {
		studenti.remove(i);
	}
	
	public void removeStudent(Student s)
	{
		this.studenti.remove(s);
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
	
	public void removeProfesor()
	{
		this.profesor = new Profesor("NEMA", "", "", "", "", "", "", "NEMA", "", "");
	}

	// NOTE(Jovan): Sluzi za .remove() metodu
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
		{
			return true;
		}
		if(!(obj instanceof Predmet))
		{
			return false;
		}
		
		Predmet p = (Predmet)obj;
		if(p.getSifra().equalsIgnoreCase(this.sifra))
		{
			return true;
		}
		return false;
	}
	
	
}
