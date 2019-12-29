package studentskasluzba.view.dijalog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import studentskasluzba.model.BazaProfesor;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.FocusListenerObaveznoBroj;
import studentskasluzba.view.FocusListenerObaveznoTxt;
import studentskasluzba.view.GlavniProzor;

public class DodavanjeProfesora extends JDialog{
	private static final long serialVersionUID = -7033252007876580812L;

	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	private JButton dodajButton, otkaziButton;
	private JTextField ime, prezime, datum, adrStanovanja,
	telefon, email, adrKancelarije, brLicneKarte, titula, zvanje;
	
	public DodavanjeProfesora()
	{
		super();
		this.setSize(450, 250);
		this.setMinimumSize(new Dimension(450, 250));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setModal(true);
		this.setTitle("Dodavanje profesora");
		
		ime = new JTextField();
		ime.addFocusListener(new FocusListenerObaveznoTxt(0));
		prezime = new JTextField();
		prezime.addFocusListener(new FocusListenerObaveznoTxt(0));
		datum = new JTextField();
		datum.addFocusListener(new FocusListenerObaveznoTxt(-2));
		adrStanovanja = new JTextField();
		adrStanovanja.addFocusListener(new FocusListenerObaveznoTxt(0));
		telefon = new JTextField();
		telefon.addFocusListener(new FocusListenerObaveznoBroj(-1));
		email = new JTextField();
		email.addFocusListener(new FocusListenerObaveznoTxt(-3));
		adrKancelarije = new JTextField();
		adrKancelarije.addFocusListener(new FocusListenerObaveznoTxt(0));
		brLicneKarte = new JTextField();
		brLicneKarte.addFocusListener(new FocusListenerObaveznoBroj(9));
		titula = new JTextField();
		titula.addFocusListener(new FocusListenerObaveznoTxt(0));
		zvanje = new JTextField();
		zvanje.addFocusListener(new FocusListenerObaveznoTxt(0));
		
		fieldsPanel = new JPanel(new GridLayout(10, 2));
		fieldsPanel.add(new JLabel("Ime*"));
		fieldsPanel.add(ime);
		fieldsPanel.add(new JLabel("Prezime*"));
		fieldsPanel.add(prezime);
		fieldsPanel.add(new JLabel("Datum rodjenja*"));
		fieldsPanel.add(datum);
		fieldsPanel.add(new JLabel("Adresa stanovanja*"));
		fieldsPanel.add(adrStanovanja);
		fieldsPanel.add(new JLabel("Broj telefona*"));
		fieldsPanel.add(telefon);
		fieldsPanel.add(new JLabel("E-Mail*"));
		fieldsPanel.add(email);
		fieldsPanel.add(new JLabel("Adresa kancelarije*"));
		fieldsPanel.add(adrKancelarije);
		fieldsPanel.add(new JLabel("Broj li\u010Dne karte*"));
		fieldsPanel.add(brLicneKarte);
		fieldsPanel.add(new JLabel("Titula*"));
		fieldsPanel.add(titula);
		fieldsPanel.add(new JLabel("Zvanje*"));
		fieldsPanel.add(zvanje);
		this.add(fieldsPanel, BorderLayout.CENTER);
		
		buttonsPanel = new JPanel(new GridLayout(1, 2));
		dodajButton = new JButton("Potvrda");
		otkaziButton = new JButton("Odustanak");
		buttonsPanel.add(dodajButton);
		buttonsPanel.add(otkaziButton);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		dodajButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO(Jovan): Custom jtext za proveru da li je prazan
				if(ime.getText().isEmpty() ||
						prezime.getText().isEmpty() ||
						datum.getText().isEmpty() ||
						adrStanovanja.getText().isEmpty() ||
						telefon.getText().isEmpty() ||
						email.getText().isEmpty() ||
						adrKancelarije.getText().isEmpty() ||
						brLicneKarte.getText().isEmpty() ||
						titula.getText().isEmpty() ||
						zvanje.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Morate popuniti sva obavezna polja, ozna\u010Dena sa (*)!","Warning", JOptionPane.WARNING_MESSAGE);	
				}
				else
				{
					Profesor p = new Profesor(ime.getText(), prezime.getText(), datum.getText(),
							adrStanovanja.getText(), telefon.getText(), email.getText(), adrKancelarije.getText(),
							brLicneKarte.getText(), titula.getText(), zvanje.getText());
					
					// NOTE(Jovan): Dodavanje profesora u bazu uz proveru da li vec postoji
					if (!BazaProfesor.getInstance().addProfesor(p)) {
						JOptionPane.showMessageDialog(null, "Profesor sa tim brojem li\u010D karte ve\u0107 postoji!","Warning", JOptionPane.WARNING_MESSAGE);	
					}
					
					GlavniProzor.getInstance().saveAllDBs();
					dispose();
				}
				
			}
		});
		// NOTE(Jovan): Default enter opcija
		JRootPane root = SwingUtilities.getRootPane(dodajButton);
		root.setDefaultButton(dodajButton);
		
		
		otkaziButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
}
