package studentskasluzba;

import java.awt.BorderLayout;

import javax.swing.JTextField;
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
		this.add(new DodajDugme());
		this.add(new IzmeniDugme());
		this.add(new ObrisiDugme());
		
		// NOTE(Jovan): Search polje i dugme
		this.add(new JTextField(), BorderLayout.EAST);
		this.add(new PretragaDugme());
	}
}
