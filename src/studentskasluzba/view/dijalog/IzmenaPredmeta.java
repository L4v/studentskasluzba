package studentskasluzba.view.dijalog;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.listeners.IzmenaPredmetaFocusTxt;


public class IzmenaPredmeta extends JDialog{
	private static final long serialVersionUID = -4788939002361046494L;

	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	private JButton potvrdiButton, otkaziButton;
	private JTextField sifra, naziv;
	private JComboBox<Profesor> profesori;
	private JComboBox<Integer> godina, semestar;
	
	public IzmenaPredmeta()
	{
		super();
		this.setSize(450, 250);
		this.setMinimumSize(new Dimension(450, 250));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setModal(true);
		this.setTitle("Izmena predmeta");
		sifra = new JTextField();
		sifra.addFocusListener(new IzmenaPredmetaFocusTxt(this));
		naziv = new JTextField();
		naziv.addFocusListener(new IzmenaPredmetaFocusTxt(this));
		
		profesori = new JComboBox<Profesor>();
		for(Profesor p : ProfesorController.getInstance().getProfesore())
		{
			profesori.addItem(p);
		}
		// NOTE(Jovan): Placeholder
		profesori.addItem(new Profesor("NEMA", "", "", "", "", "", "", "", "", ""));
		
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
		
		fieldsPanel = new JPanel(new GridLayout(5, 2));
		fieldsPanel.add(new JLabel("\u0160ifra*"));
		fieldsPanel.add(sifra);
		fieldsPanel.add(new JLabel("Naziv"));
		fieldsPanel.add(naziv);
		// TODO(Jovan): Zavrsiti
	}
}
