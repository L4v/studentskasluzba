package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import dijalog.BrisanjePredmeta;
import dijalog.BrisanjeProfesora;
import dijalog.BrisanjeStudenta;
import dijalog.DodavanjePredmeta;
import dijalog.DodavanjeProfesora;
import dijalog.DodavanjeProfesoraNaPredmet;
import dijalog.DodavanjeStudenta;
import dijalog.DodavanjeStudentaNaPredmet;
import dijalog.IzmenaProfesora;
import dijalog.IzmenaStudenta;
import dugmici.DodajDugme;
import dugmici.IzmeniDugme;
import dugmici.ObrisiDugme;
import dugmici.PretragaDugme;

public class Toolbar extends JToolBar{
	private static final long serialVersionUID = -4611960868780210810L;
	DodajDugme dodaj;
	IzmeniDugme izmeni;
	ObrisiDugme obrisi;
	private DodajDugme profNaPredmet;
	private DodajDugme studentNaPredmet;
	// NOTE(Jovan): Sluzi za odredjivanje dugmica koji
	// ce se prikazati
	
	public Toolbar()
	{
		super();
		// NOTE(Jovan): Onesposobljava pomeranje
		this.setFloatable(false);
		
		// NOTE(Jovan): Default dugmici za Add, Edit, Delete
		dodaj = new DodajDugme("Dodaj");
		izmeni = new IzmeniDugme();
		obrisi = new ObrisiDugme();
		this.add(dodaj);
		this.add(izmeni);
		this.add(obrisi);
		profNaPredmet = new DodajDugme("Dodaj profesora na predmet");
		profNaPredmet.setIcon(new ImageIcon(getClass().getResource("/icons/add-prof.png")));
		studentNaPredmet = new DodajDugme("Dodaj studenta na predmet");
		this.add(profNaPredmet);
		this.add(studentNaPredmet);
		
		// NOTE(Jovan): Dodavanje studenta/predmeta/profesora u zavisnosti
		// od selektovanog taba
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
		
		
		// NOTE(Jovan): Dodavanje profesora na predmet
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
				
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
					return;
				}
				DodavanjeStudentaNaPredmet dodaj = new DodavanjeStudentaNaPredmet();
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
		
		//NOTE(Kristian) : izmena studenta,profesora,predmeta
		izmeni.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				switch(GlavniProzor.getInstance().getSelektovanTab())
				{
					case STUDENT:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali studenta!");
							return;
						}
						IzmenaStudenta izmeni = new IzmenaStudenta();
						izmeni.setVisible(true);
						break;
					}
					case PROFESOR:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
							return;
						}
						IzmenaProfesora izmeni = new IzmenaProfesora();
						izmeni.setVisible(true);
						break;
					}
					case PREDMET:
					{
						// TODO(Jovan): Dodati
						break;
					}
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		// NOTE(Kristian): izmena studenta,profesora,predmeta
		// od selektovanog taba
		obrisi.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				switch(GlavniProzor.getInstance().getSelektovanTab())
				{
					case STUDENT:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali studenta!");
							return;
						}
						BrisanjeStudenta obrisi = new BrisanjeStudenta();
						obrisi.setVisible(true);
						break;
					}
					case PROFESOR:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali profesora!");
							return;
						}
						BrisanjeProfesora obrisi = new BrisanjeProfesora();
						obrisi.setVisible(true);
						break;
					}
					case PREDMET:
					{
						if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
							JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
							return;
						}
						BrisanjePredmeta obrisi = new BrisanjePredmeta();
						obrisi.setVisible(true);
						break;
					}
				}
				
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
		
	}

	
	// NOTE(Jovan): Vrsi azuriranje toolbara prilikom promene
	// selektovanog taba
	public void azuriraj(SelektovanTab s)
	{
		switch(s)
		{
			case STUDENT:
			{
				dodaj.updateIcon(s);
				dodaj.setToolTipText("Dodaj studenta");
				profNaPredmet.setVisible(false);
				studentNaPredmet.setVisible(false);
				break;
			}
			case PROFESOR:
			{
				dodaj.updateIcon(s);
				dodaj.setToolTipText("Dodaj profesora");
				profNaPredmet.setVisible(false);
				studentNaPredmet.setVisible(false);
				break;
			}
			case PREDMET:
			{
				dodaj.updateIcon(s);
				dodaj.setToolTipText("Dodaj predmet");
				profNaPredmet.setVisible(true);
				studentNaPredmet.setVisible(true);
				break;
			}
		default:
			break;
		}
	}
}
