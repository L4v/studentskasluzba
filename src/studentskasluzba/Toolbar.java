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
		DodajDugme dodaj = new DodajDugme();
		IzmeniDugme izmeni = new IzmeniDugme();
		ObrisiDugme obrisi = new ObrisiDugme();
		this.add(dodaj);
		this.add(izmeni);
		this.add(obrisi);
		
		// NOTE(Jovan): Search polje i dugme
		PretragaPolje pretraga = new PretragaPolje();
		PretragaDugme pretrazi = new PretragaDugme();
		this.add(pretraga, BorderLayout.EAST);
		this.add(pretrazi);		
	}
}
