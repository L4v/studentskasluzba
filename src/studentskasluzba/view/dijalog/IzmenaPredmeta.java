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

import studentskasluzba.controller.PredmetController;
import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.listeners.IzmenaPredmetaComboListener;
import studentskasluzba.view.listeners.IzmenaPredmetaFocusTxt;
import studentskasluzba.view.listeners.IzmenaPredmetaListener;


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
		Predmet selektovanPredmet = PredmetController.getInstance().getSelektovan();
		sifra = new JTextField();
		sifra.setText(selektovanPredmet.getSifra());
		sifra.setEnabled(false);
		sifra.addFocusListener(new IzmenaPredmetaFocusTxt(this));
		naziv = new JTextField();
		naziv.setText(selektovanPredmet.getNaziv());
		naziv.addFocusListener(new IzmenaPredmetaFocusTxt(this));
		
		profesori = new JComboBox<Profesor>();
		for(Profesor p : ProfesorController.getInstance().getProfesore())
		{
			profesori.addItem(p);
		}
		// NOTE(Jovan): Placeholder
		profesori.addItem(new Profesor("", "", "", "", "", "", "", "null", "", ""));
		profesori.setSelectedItem(selektovanPredmet.getProfesor());
		
		// TODO(Jovan): Ograniciti semestar na osnovu godine
		godina = new JComboBox<Integer>();
		semestar = new JComboBox<Integer>();
		for(int i = 1; i <= 4; ++i)
		{
			godina.addItem(i);
		}
		godina.setSelectedItem(selektovanPredmet.getGodina());
		int god = selektovanPredmet.getGodina();
		semestar.addItem(god*2 - 1);
		semestar.addItem(god*2);
		
		godina.addActionListener(new IzmenaPredmetaComboListener(this));
		
		
		fieldsPanel = new JPanel(new GridLayout(5, 2));
		fieldsPanel.add(new JLabel("\u0160ifra*"));
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
		potvrdiButton = new JButton("Potvrdi");
		potvrdiButton.setEnabled(false);
		otkaziButton = new JButton("Otka\u017ei");
		buttonsPanel.add(potvrdiButton);
		buttonsPanel.add(otkaziButton);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		potvrdiButton.addActionListener(new IzmenaPredmetaListener(this));
		JRootPane root = SwingUtilities.getRootPane(potvrdiButton);
		root.setDefaultButton(potvrdiButton);
		
		otkaziButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getFieldsPanel() {
		return fieldsPanel;
	}

	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public JButton getPotvrdiButton() {
		return potvrdiButton;
	}

	public JButton getOtkaziButton() {
		return otkaziButton;
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
