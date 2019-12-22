package dijalog;

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

import studentskasluzba.BazaProfesor;
import studentskasluzba.FocusListenerObaveznoBroj;
import studentskasluzba.FocusListenerObaveznoTxt;
import studentskasluzba.GlavniProzor;
import studentskasluzba.Profesor;

public class IzmenaProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel fieldsPanel;
	private JPanel buttonsPanel;
	private JButton dodajButton, otkaziButton;
	private JTextField ime, prezime, datum, adrStanovanja,
	telefon, email, adrKancelarije, brLicneKarte, titula, zvanje;
	
	public IzmenaProfesora()
	{
		super();
		this.setSize(450, 250);
		this.setMinimumSize(new Dimension(450, 250));
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setModal(true);
		this.setTitle("Izmena profesora");
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
		
		Profesor p = BazaProfesor.getInstance().getProfesor(GlavniProzor.getInstance().getSelektovanuTorku());
		
		ime.setText(p.getIme());
		prezime.setText(p.getPrezime());
		datum.setText(p.getDatumRodjenja());
		adrStanovanja.setText(p.getAdresaStanovanja());
		telefon.setText(p.getKontaktTelefon());
		email.setText(p.getEmail());
		adrKancelarije.setText(p.getAdresaKancelarije());
		brLicneKarte.setText(p.getBrLicneKarte());
		titula.setText(p.getTitula());
		zvanje.setText(p.getZvanje());
		
		
		dodajButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					BazaProfesor.getInstance().izmeniProfesora(ime.getText(), prezime.getText(), datum.getText(),
							adrStanovanja.getText(), telefon.getText(), email.getText(), adrKancelarije.getText(),
							brLicneKarte.getText(), titula.getText(), zvanje.getText());
					
					
					dispose();
				}
			}
		});
		JRootPane root = SwingUtilities.getRootPane(dodajButton);
		root.setDefaultButton(dodajButton);
		
		otkaziButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
