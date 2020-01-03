package studentskasluzba.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.view.dijalog.BrisanjePredmeta;
import studentskasluzba.view.dijalog.BrisanjeProfesora;
import studentskasluzba.view.dijalog.BrisanjeStudenta;
import studentskasluzba.view.dijalog.DodavanjePredmeta;
import studentskasluzba.view.dijalog.DodavanjeProfesora;
import studentskasluzba.view.dijalog.DodavanjeStudenta;
import studentskasluzba.view.dijalog.DodavanjeStudentaNaPredmet;
import studentskasluzba.view.dijalog.IzmenaPredmeta;
import studentskasluzba.view.dijalog.IzmenaProfesora;
import studentskasluzba.view.dijalog.IzmenaStudenta;
import studentskasluzba.view.dugmici.DodajDugme;
import studentskasluzba.view.dugmici.IzmeniDugme;
import studentskasluzba.view.dugmici.ObrisiDugme;
import studentskasluzba.view.dugmici.PretraziDugme;
import studentskasluzba.view.listeners.PretragaPredmetaListener;

public class Toolbar extends JToolBar{
	private static final long serialVersionUID = -4611960868780210810L;
	DodajDugme dodaj;
	IzmeniDugme izmeni;
	ObrisiDugme obrisi;
	PretragaPolje pretraga;
	PretraziDugme pretrazi;
	private DodajDugme profNaPredmet;
	private DodajDugme studentNaPredmet;
	private ObrisiDugme profSaPredmeta;
	// TODO(Jovan): Mozda da bude lista?
	private PretragaPredmetaListener pretragaPredmetaListener;
	// NOTE(Jovan): Sluzi za odredjivanje dugmica koji
	// ce se prikazati
	
	public Toolbar()
	{
		super();
		// NOTE(Jovan): Onesposobljava pomeranje
		this.setFloatable(false);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
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
		
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		studentNaPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (GlavniProzor.getInstance().getSelektovanuTorku()==-1) {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet!");
					return;
				}
				DodavanjeStudentaNaPredmet dodaj = new DodavanjeStudentaNaPredmet();
				dodaj.setVisible(true);
			}
			
		});
		
		//NOTE(Kristian) : izmena studenta,profesora,predmeta
		izmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
			
		});
		
		
		
		// NOTE(Kristian): izmena studenta,profesora,predmeta
		// od selektovanog taba
		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
			
		});
		
		// NOTE(Jovan): Search polje i dugme
		pretraga = new PretragaPolje();
		pretrazi = new PretraziDugme("Pretra\u017ei");
		pretragaPredmetaListener = new PretragaPredmetaListener(pretraga);
		this.add(pretraga);
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
				pretraga.setDefaultText("indeks:<XX-YY/ZZZZ>;ime:<ime>;prezime:<prezime>");
				
				pretrazi.removeActionListener(pretragaPredmetaListener);
				pretraga.removeActionListener(pretragaPredmetaListener);
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
				pretraga.setDefaultText("licna_karta:<xxxxxxxxx>;ime:<ime>;prezime:<prezime>");
				
				pretrazi.removeActionListener(pretragaPredmetaListener);
				pretraga.removeActionListener(pretragaPredmetaListener);
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
				pretraga.setDefaultText("sifra:<sifra>;naziv:<naziv>");
				
				pretrazi.addActionListener(pretragaPredmetaListener);
				pretraga.addActionListener(pretragaPredmetaListener);
				break;
			}
		default:
			break;
		}
	}
}
