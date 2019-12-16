package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JToolBar;

import dijalog.DodavanjePredmeta;
import dijalog.DodavanjeProfesora;
import dijalog.DodavanjeStudenta;
import dugmici.DodajDugme;
import dugmici.IzmeniDugme;
import dugmici.ObrisiDugme;
import dugmici.PretragaDugme;

enum Rezim{
	STUDENTI,
	PREDMETI,
	PROFESORI
}

@SuppressWarnings("serial")
public class Toolbar extends JToolBar{
	private DodajDugme profNaPredmet;
	private DodajDugme studentNaPredmet;
	// NOTE(Jovan): Sluzi za odredjivanje dugmica koji
	// ce se prikazati
	private Rezim rezim;
	private ArrayList<JButton> dodatni;
	
	public Toolbar()
	{
		super();
		rezim = Rezim.STUDENTI;
		// NOTE(Jovan): Onesposobljava pomeranje
		this.setFloatable(false);
		
		// NOTE(Jovan): Default dugmici za Add, Edit, Delete
		DodajDugme dodaj = new DodajDugme("Dodaj");
		IzmeniDugme izmeni = new IzmeniDugme();
		ObrisiDugme obrisi = new ObrisiDugme();
		this.add(dodaj);
		this.add(izmeni);
		this.add(obrisi);
		dodatni = new ArrayList<JButton>();
		profNaPredmet = new DodajDugme("Dodaj profesora na predmet");
		studentNaPredmet = new DodajDugme("Dodaj studenta na predmet");
		dodaj.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch(GlavniProzor.getInstance().getSelektovanTab())
				{
				 case STUDENT:
				 {
					DodavanjeStudenta dodaj = new DodavanjeStudenta();
					dodaj.setVisible(true);
					break;
				 }
				 case PROFESOR:
				 {
					 DodavanjeProfesora dodaj = new DodavanjeProfesora();
					 dodaj.setVisible(true);
					 break;
				 }
				 case PREDMET:
				 {
					DodavanjePredmeta dodaj = new DodavanjePredmeta();
					dodaj.setVisible(true);
					break;
				 }
				 default:
				 {
					 return;
				 }
				}
				
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
		profNaPredmet.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO(Jovan): Dialog za profNaPredmet
				DodavanjeProfesoraNaPredmet dodaj = 
						new DodavanjeProfesoraNaPredmet();
				dodaj.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		studentNaPredmet.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO(Jovan): Dodati dijalog za dodavanje studenta na predmet
				DodavanjeStudentaNaPredmet dodaj = 
						new DodavanjeStudentaNaPredmet();
				dodaj.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// NOTE(Jovan): Search polje i dugme
		PretragaPolje pretraga = new PretragaPolje();
		PretragaDugme pretrazi = new PretragaDugme();
		this.add(pretraga, BorderLayout.EAST);
		this.add(pretrazi);		
		
		//update();
	}
	// NOTE(Jovan): Vrsi azuriranje toolbara prilikom promene
	// selektovanog taba
	public void update()
	{
		switch(GlavniProzor.getInstance().getSelektovanTab())
		{
			case STUDENT:
			{
				break;
			}
			case PROFESOR:
			{
				
				break;
			}
			case PREDMET:
			{
				break;
			}
		default:
			break;
		}
	}
}
