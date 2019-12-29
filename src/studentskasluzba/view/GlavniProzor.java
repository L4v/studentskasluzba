package studentskasluzba.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.BazaStudenata;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame implements ChangeListener{
	
	public static GlavniProzor instance = null;
	
	private JTabbedPane tabbedPane;
	private ProfesorTab profesorTab;
	private PredmetTab predmetTab;
	
	private Toolbar glavniToolbar;
	
	private StudentTab studentTab;
	// NOTE(Jovan): Sluzi za Dodaj i slicne operacije koje zavise
	// od toga koji je tab selektovan
	private SelektovanTab selektovanTab;
	public static GlavniProzor getInstance()
	{
		if(instance == null)
		{
			instance = new GlavniProzor();
		}
		return instance;
	}
	private GlavniProzor()
	{
		super();
		// NOTE(Jovan): Podesavanja prozora
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width * 3/4, screenSize.height * 3/4);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Studentska slu\u017eba");
		
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			// NOTE(Jovan): Prilikom gasenja aplikacije sacuvaj baze
			@Override
			public void windowClosing(WindowEvent arg0) {
				saveAllDBs();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		// NOTE(Jovan): Inicijalizacija ostalih komponenti
		glavniToolbar = new Toolbar(); 
		this.add(glavniToolbar, BorderLayout.NORTH);
		
		MojMenuBar menu = new MojMenuBar();
		this.setJMenuBar(menu);
		
		StatusBar st_bar=new StatusBar();
		this.add(st_bar, BorderLayout.SOUTH);
		
		// TODO(Jovan): Srediti izgled
				
		tabbedPane = new JTabbedPane();
		tabbedPane.addChangeListener(this);
		profesorTab = new ProfesorTab();
		predmetTab = new PredmetTab();
		studentTab = new StudentTab();
		tabbedPane.addTab("Student", studentTab);
		tabbedPane.addTab("Profesori", profesorTab);
		tabbedPane.addTab("Predmeti", predmetTab);
		this.add(tabbedPane, BorderLayout.CENTER);
		this.selektovanTab = SelektovanTab.STUDENT;
	}
	
	// NOTE(Jovan): Sacuva stanje svih baze podataka
	public void saveAllDBs()
	{
		BazaStudenata.getInstance().saveDB();
		BazaProfesor.getInstance().saveDB();
		BazaPredmet.getInstance().saveDB();
	}
	
	public int getSelektovanuTorku()
	{
		int Result = -1;
		switch(getSelektovanTab())
		{
			case STUDENT:
			{
				Result = studentTab.getSelektovanuTorku();
				break;
			}
			case PROFESOR:
			{
				Result = profesorTab.getSelektovanuTorku();
				break;
			}
			case PREDMET:
			{
				Result = predmetTab.getSelektovanuTorku();
				break;
			}
		}
		return Result;
	}
	
	public SelektovanTab getSelektovanTab()
	{
		return this.selektovanTab;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane tabbedPane = (JTabbedPane)e.getSource();
		int selectedIndex = tabbedPane.getSelectedIndex();
		switch(selectedIndex)
		{
			case 0:
			{
				this.selektovanTab = SelektovanTab.STUDENT;
				glavniToolbar.azuriraj(SelektovanTab.STUDENT);
				break;
			}
			case 1:
			{
				this.selektovanTab = SelektovanTab.PROFESOR;
				glavniToolbar.azuriraj(SelektovanTab.PROFESOR);
				break;
			}
			case 2:
			{
				this.selektovanTab = SelektovanTab.PREDMET;
				glavniToolbar.azuriraj(SelektovanTab.PREDMET);
				break;
			}
			default:
			{
				return;
			}
		}
	}
	public void azurirajPrikaz() {
		AbstractTableModelStudent modelStudenta = studentTab.getModel();
		AbstractTableModelPredmet modelPredmeta = predmetTab.getModel();
		AbstractTableModelProfesor modelProfesora = profesorTab.getModel();
		
		modelStudenta.fireTableDataChanged();
		modelPredmeta.fireTableDataChanged();
		modelProfesora.fireTableDataChanged();
		
	}
}
