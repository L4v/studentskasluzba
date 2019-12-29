package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.listeners.DodavanjePredmetaFocusTxt;
import studentskasluzba.view.listeners.DodavanjePredmetaListener;

@SuppressWarnings("serial")
public class DodavanjePredmeta extends JDialog{

	private JPanel fieldsPanel;
	
	private JPanel buttonsPanel;
	private JButton dodajButton, otkaziButton;
	private JTextField sifra, naziv;
	private JComboBox<Profesor> profesori;
	private JComboBox<Integer> godina, semestar;

	public DodavanjePredmeta()
	{
		super();
		this.setSize(450, 250);
		this.setMinimumSize(new Dimension(450, 250));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setModal(true);
		this.setTitle("Dodavanje predmeta");
		sifra = new JTextField();
		sifra.addFocusListener(new DodavanjePredmetaFocusTxt(this, 0));
		
		naziv = new JTextField();
		naziv.addFocusListener(new DodavanjePredmetaFocusTxt(this, 0));
		
		godina = new JComboBox<Integer>();
		semestar = new JComboBox<Integer>();
		for(int i = 1; i <= 8; ++i)
		{
			semestar.addItem(i);
			if(i <= 4)
			{
				godina.addItem(i);
			}
		}
		
		
		profesori = new JComboBox<Profesor>();
		for (Profesor p : ProfesorController.getInstance().getProfesore())
		{
			profesori.addItem(p);
		}
		// NOTE(Jovan): Dodajemo "nema" kako bi imali mogucnost
		// da ne odaberemo jos profesora za predmet
		Profesor nema = new Profesor("NEMA", "", "", "", "", "", "", "", "", "");
		profesori.addItem(nema);
		
		fieldsPanel = new JPanel(new GridLayout(5, 2));
		fieldsPanel.add(new JLabel("\u0161ifra predmeta*"));
		fieldsPanel.add(sifra);
		fieldsPanel.add(new JLabel("Naziv predmeta*"));
		fieldsPanel.add(naziv);
		fieldsPanel.add(new JLabel("Godina*"));
		fieldsPanel.add(godina);
		fieldsPanel.add(new JLabel("Semestar*"));
		fieldsPanel.add(semestar);
		fieldsPanel.add(new JLabel("Profesor*"));
		fieldsPanel.add(profesori);
		this.add(fieldsPanel, BorderLayout.CENTER);
		buttonsPanel = new JPanel(new GridLayout(1, 2));
		dodajButton = new JButton("Dodaj");
		otkaziButton = new JButton("Otka\017ei");
		buttonsPanel.add(dodajButton);
		buttonsPanel.add(otkaziButton);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		
		dodajButton.addActionListener(new DodavanjePredmetaListener(this));
		// NOTE(Jovan): Default opcija za enter
		JRootPane root = SwingUtilities.getRootPane(dodajButton);
		root.setDefaultButton(dodajButton);
		
		otkaziButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
	public JButton getDodajButton()
	{
		return dodajButton;
	}
	
	public JTextField getSifra() {
		return sifra;
	}
	public JTextField getNaziv() {
		return naziv;
	}
	public JComboBox<Profesor> getProfesori() {
		return profesori;
	}
	public JComboBox<Integer> getGodina() {
		return godina;
	}
	public JComboBox<Integer> getSemestar() {
		return semestar;
	}
}
