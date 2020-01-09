package studentskasluzba.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import studentskasluzba.view.dijalog.DodavanjeStudentaNaPredmet;
import studentskasluzba.view.dugmici.DodajDugme;
import studentskasluzba.view.dugmici.IzmeniDugme;
import studentskasluzba.view.dugmici.ObrisiDugme;
import studentskasluzba.view.dugmici.PretraziDugme;
import studentskasluzba.view.listeners.BrisanjeProfesoraSaPredmetaToolbar;
import studentskasluzba.view.listeners.BrisanjeToolbarListener;
import studentskasluzba.view.listeners.DodavanjeProfesoraNaPredmetToolbar;
import studentskasluzba.view.listeners.DodavanjeToolbarListener;
import studentskasluzba.view.listeners.IzmenaToolbarListener;
import studentskasluzba.view.listeners.PretragaPredmetaListener;
import studentskasluzba.view.listeners.PretragaProfesoraListener;
import studentskasluzba.view.listeners.PretragaStudentaListener;

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
	private JPanel buttonsPanel;
	private JPanel searchPanel;
	private PretragaPredmetaListener pretragaPredmetaListener;
	private PretragaStudentaListener pretragaStudentaListener;
	private PretragaProfesoraListener pretragaProfesoraListener;
	
	private ArrayList<ActionListener> listeners;
	// NOTE(Jovan): Sluzi za odredjivanje dugmica koji
	// ce se prikazati
	
	public Toolbar()
	{
		super();
		// NOTE(Jovan): Onesposobljava pomeranje
		this.setFloatable(false);
		//this.setLayout(new FlowLayout(FlowLayout.LEFT));
		// NOTE(Jovan): Default dugmici za Add, Edit, Delete
		this.setLayout(new BorderLayout());
		dodaj = new DodajDugme("Dodaj");
		izmeni = new IzmeniDugme();
		obrisi = new ObrisiDugme("Obrisi");
		buttonsPanel = new JPanel();
		searchPanel = new JPanel();
		buttonsPanel.add(dodaj);
		buttonsPanel.add(izmeni);
		buttonsPanel.add(obrisi);
		profNaPredmet = new DodajDugme("Dodaj profesora na predmet");
		profNaPredmet.setIcon(new ImageIcon(getClass().getResource("/icons/add-prof.png")));
		profSaPredmeta = new ObrisiDugme("Ukloni profesora sa predmeta");
		profSaPredmeta.setIcon(new ImageIcon(getClass().getResource("/icons/remove-prof.png")));
		studentNaPredmet = new DodajDugme("Dodaj studenta na predmet");
		buttonsPanel.add(profNaPredmet);
		buttonsPanel.add(profSaPredmeta);
		buttonsPanel.add(studentNaPredmet);
		this.add(buttonsPanel, BorderLayout.WEST);
		// NOTE(Jovan): Dodavanje studenta/predmeta/profesora u zavisnosti
		// od selektovanog taba
		
		dodaj.addActionListener(new DodavanjeToolbarListener());
		
		// NOTE(Jovan): Uklanjanje profesora sa predmeta
		profSaPredmeta.addActionListener(new BrisanjeProfesoraSaPredmetaToolbar());
		
		// NOTE(Jovan): Dodavanje profesora na predmet
		profNaPredmet.addActionListener(new DodavanjeProfesoraNaPredmetToolbar());
		
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
		izmeni.addActionListener(new IzmenaToolbarListener());
		
		// NOTE(Kristian): brisanje studenta,profesora,predmeta
		// od selektovanog taba
		obrisi.addActionListener(new BrisanjeToolbarListener());
		
		// NOTE(Jovan): Lista listenera
		listeners = new ArrayList<ActionListener>();
		
		// NOTE(Jovan): Search polje i dugme
		pretraga = new PretragaPolje();
		pretrazi = new PretraziDugme("Pretra\u017ei");
		pretragaPredmetaListener = new PretragaPredmetaListener(pretraga);
		pretragaStudentaListener = new PretragaStudentaListener(pretraga);
		pretragaProfesoraListener = new PretragaProfesoraListener(pretraga);
		
		// NOTE(Jovan): Dodavanje u listu listenera
		listeners.add(pretragaPredmetaListener);
		listeners.add(pretragaStudentaListener);
		listeners.add(pretragaProfesoraListener);
		searchPanel.add(pretraga);
		searchPanel.add(pretrazi);
		this.add(searchPanel, BorderLayout.EAST);
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
				pretraga.setDefaultText("ime:<ime>;prezime:<prezime>;indeks:<XX YYY/ZZZZ>");
				
				// NOTE(Jovan): uklanjanje svih listenera
				for(ActionListener l : listeners)
				{
					pretrazi.removeActionListener(l);
					pretraga.removeActionListener(l);
				}
				pretrazi.addActionListener(pretragaStudentaListener);
				pretraga.addActionListener(pretragaStudentaListener);
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
				pretraga.setDefaultText("ime:<ime>;prezime:<prezime>;lk:<xxxxxxxxx>");
				
				// NOTE(Jovan): Uklanjanje svih listenera
				for(ActionListener l : listeners)
				{
					pretrazi.removeActionListener(l);
					pretraga.removeActionListener(l);
				}
				pretrazi.addActionListener(pretragaProfesoraListener);
				pretraga.addActionListener(pretragaProfesoraListener);
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
				pretraga.setDefaultText("naziv:<naziv>;\u0161ifra:<\u0161ifra>");
				
				// NOTE(Jovan): Uklanjanje svih listenera
				for(ActionListener l : listeners)
				{
					pretrazi.removeActionListener(l);
					pretraga.removeActionListener(l);
				}
				// NOTE(Jovan): Postavljanje listenera za pretragu predmeta
				pretrazi.addActionListener(pretragaPredmetaListener);
				pretraga.addActionListener(pretragaPredmetaListener);
				break;
			}
		default:
			break;
		}
	}
}
