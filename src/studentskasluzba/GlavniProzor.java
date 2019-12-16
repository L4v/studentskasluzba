package studentskasluzba;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

enum Selektovan
{
	STUDENT,
	PROFESOR,
	PREDMET
}

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
	private Selektovan selektovanTab;
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
		this.selektovanTab = Selektovan.STUDENT;
	}
	
	public Selektovan getSelektovanTab()
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
				this.selektovanTab = Selektovan.STUDENT;
				break;
			}
			case 1:
			{
				this.selektovanTab = Selektovan.PROFESOR;
				break;
			}
			case 2:
			{
				this.selektovanTab = Selektovan.PREDMET;
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
