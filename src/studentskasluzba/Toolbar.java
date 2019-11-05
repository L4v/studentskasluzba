package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JToolBar;

import dijalog.DodajPredmet;
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
		
		// TODO(Jovan): OVO SAMO TEST
		dodaj.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				DodajPredmet dodaj = new DodajPredmet();
				dodaj.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// NOTE(Jovan): Search polje i dugme
		PretragaPolje pretraga = new PretragaPolje();
		PretragaDugme pretrazi = new PretragaDugme();
		this.add(pretraga, BorderLayout.EAST);
		this.add(pretrazi);		
	}
}
