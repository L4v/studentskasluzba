package studentskasluzba;

import java.awt.BorderLayout;
import javax.swing.JToolBar;

import dugmici.DodajDugme;
import dugmici.IzmeniDugme;
import dugmici.ObrisiDugme;
import dugmici.PretragaDugme;

@SuppressWarnings("serial")
public class Toolbar extends JToolBar{
	public Toolbar()
	{
		super();
		
		// NOTE(Jovan): Onesposobljava pomeranje
		this.setFloatable(false);
		
		// NOTE(Jovan): Dugmici za Add, Edit, Delete
		DodajDugme Dodaj = new DodajDugme();
		IzmeniDugme Izmeni = new IzmeniDugme();
		ObrisiDugme Obrisi = new ObrisiDugme();
		this.add(Dodaj);
		this.add(Izmeni);
		this.add(Obrisi);
		
		// NOTE(Jovan): Search polje i dugme
		PretragaPolje Pretraga = new PretragaPolje();
		PretragaDugme Pretrazi = new PretragaDugme();
		this.add(Pretraga, BorderLayout.EAST);
		this.add(Pretrazi);		
	}
}
