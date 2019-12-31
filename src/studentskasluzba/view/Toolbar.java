package studentskasluzba.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.view.dijalog.BrisanjePredmeta;
import studentskasluzba.view.dijalog.BrisanjeProfesora;
import studentskasluzba.view.dijalog.BrisanjeStudenta;
import studentskasluzba.view.dijalog.DodavanjePredmeta;
import studentskasluzba.view.dijalog.DodavanjeProfesora;
import studentskasluzba.view.dijalog.DodavanjeProfesoraNaPredmet;
import studentskasluzba.view.dijalog.DodavanjeStudenta;
import studentskasluzba.view.dijalog.DodavanjeStudentaNaPredmet;
import studentskasluzba.view.dijalog.IzmenaPredmeta;
import studentskasluzba.view.dijalog.IzmenaProfesora;
import studentskasluzba.view.dijalog.IzmenaStudenta;
import studentskasluzba.view.dugmici.DodajDugme;
import studentskasluzba.view.dugmici.IzmeniDugme;
import studentskasluzba.view.dugmici.ObrisiDugme;
import studentskasluzba.view.dugmici.PretragaDugme;

public class Toolbar extends JToolBar{
	private static final long serialVersionUID = -4611960868780210810L;
	DodajDugme dodaj;
	IzmeniDugme izmeni;
	ObrisiDugme obrisi;
	private DodajDugme profNaPredmet;
	private DodajDugme studentNaPredmet;
	private ObrisiDugme profSaPredmeta;
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
		obrisi = new ObrisiDugme("Obrisi");
		this.add(dodaj);
		this.add(izmeni);
		this.add(obrisi);
		profNaPredmet = new DodajDugme("Dodaj profesora na predmet");
		profNaPredmet.setIcon(new ImageIcon(getClass().getResource("/icons/add-prof.png")));
		profSaPredmeta = new ObrisiDugme("Ukloni profesora sa predmeta");
		profSaPredmeta.setIcon(new ImageIcon(getClass().getResource("/icons/remove-prof.png")));
		studentNaPredmet = new DodajDugme("Dodaj studenta na predmet");
		this.add(profNaPredmet);
		this.add(profSaPredmeta);
		this.add(studentNaPredmet);
		
		// NOTE(Jovan): Dodavanje studenta/predmeta/profesora u zavisnosti
		// od selektovanog taba
		// TODO(Jovan): Action listener
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
		profNaPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = GlavniProzor.getInstance().getSelektovanuTorku();
				if (row == -1)
				{
					JOptionPane.showMessageDialog(null, "Potrebno je selektovati predmet!", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				DodavanjeProfesoraNaPredmet dodaj = 
						new DodavanjeProfesoraNaPredmet();
				dodaj.setVisible(true);
			}
			
		});
		
		// NOTE(Jovan): Uklanjanje profesora sa predmeta
		profSaPredmeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = GlavniProzor.getInstance().getSelektovanuTorku();
				if(row == -1)
				{
					JOptionPane.showMessageDialog(null, "Odaberite predmet!","Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				BazaPredmet.getInstance().getPredmet(row).removeProfesor();
				GlavniProzor.getInstance().azurirajPrikaz();
			}
			
		});
		
		// NOTE(Jovan): Dodavanje studenta na predmet
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
						if(GlavniProzor.getInstance().getSelektovanuTorku()==-1)
						{
							JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
							return;
						}
						IzmenaPredmeta izmeni = new IzmenaPredmeta();
						izmeni.setVisible(true);
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
				obrisi.setToolTipText("Obrisi studenta");
				profNaPredmet.setVisible(false);
				profSaPredmeta.setVisible(false);
				studentNaPredmet.setVisible(false);
				break;
			}
			case PROFESOR:
			{
				dodaj.updateIcon(s);
				dodaj.setToolTipText("Dodaj profesora");
				obrisi.setToolTipText("Obrisi profesora");
				profNaPredmet.setVisible(false);
				profSaPredmeta.setVisible(false);
				studentNaPredmet.setVisible(false);
				break;
			}
			case PREDMET:
			{
				dodaj.updateIcon(s);
				dodaj.setToolTipText("Dodaj predmet");
				obrisi.setToolTipText("Obrisi predmet");
				profNaPredmet.setVisible(true);
				profSaPredmeta.setVisible(true);
				studentNaPredmet.setVisible(true);
				break;
			}
		default:
			break;
		}
	}
}
