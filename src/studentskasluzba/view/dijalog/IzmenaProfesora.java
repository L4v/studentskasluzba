package studentskasluzba.view.dijalog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import studentskasluzba.controller.ProfesorController;
import studentskasluzba.model.Profesor;
import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.listeners.IzmenaProfesoraFocus;
import studentskasluzba.view.listeners.IzmenaProfesoraListener;

public class IzmenaProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton dodajButton, otkaziButton;
	private JTextField ime, prezime, datum, adrStanovanja,
	telefon, email, adrKancelarije, brLicneKarte, titula, zvanje;
	
	public IzmenaProfesora()
	{
		
		setTitle("Dodavanje profesora");
		setSize(450,500);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		GridBagLayout layout = new GridBagLayout();
		getContentPane().setLayout(layout);
		
		dodajButton = new JButton("Potvrda");
		otkaziButton = new JButton("Odustanak");
		
		JPanel panel = new JPanel();
		panel.add(otkaziButton);
		panel.add(dodajButton);
		
		ime = new JTextField();
		ime.addFocusListener(new IzmenaProfesoraFocus(this, 0));
		prezime = new JTextField();
		prezime.addFocusListener(new IzmenaProfesoraFocus(this, 0));
		datum = new JTextField();
		datum.addFocusListener(new IzmenaProfesoraFocus(this, -2));
		adrStanovanja = new JTextField();
		adrStanovanja.addFocusListener(new IzmenaProfesoraFocus(this, 0));
		telefon = new JTextField();
		telefon.addFocusListener(new IzmenaProfesoraFocus(this, -4));
		email = new JTextField();
		email.addFocusListener(new IzmenaProfesoraFocus(this, -3));
		adrKancelarije = new JTextField();
		adrKancelarije.addFocusListener(new IzmenaProfesoraFocus(this, 0));
		brLicneKarte = new JTextField();
		brLicneKarte.addFocusListener(new IzmenaProfesoraFocus(this, 9));
		titula = new JTextField();
		titula.addFocusListener(new IzmenaProfesoraFocus(this, 0));
		zvanje = new JTextField();
		zvanje.addFocusListener(new IzmenaProfesoraFocus(this, 0));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(15, 2, 2, 2);
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Ime*"), c);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 1;
		c1.gridy = 0;
		c1.weightx = 1;
		c1.insets = new Insets(15, 2, 2, 2);
		c1.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(ime, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;
		c2.insets = new Insets(15, 2, 2, 2);
		c2.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Prezime*"), c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1;
		c3.insets = new Insets(15, 2, 2, 2);
		c3.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(prezime, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 2;
		c4.insets = new Insets(15, 2, 2, 2);
		c4.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Datum rodjenja*"), c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 2;
		c5.insets = new Insets(15, 2, 2, 2);
		c5.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(datum, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0;
		c6.gridy = 3;
		c6.insets = new Insets(15, 2, 2, 2);
		c6.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Adresa stanovanja*"), c6);
		
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 1;
		c7.gridy = 3;
		c7.insets = new Insets(15, 2, 2, 2);
		c7.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(adrStanovanja, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 0;
		c8.gridy = 4;
		c8.insets = new Insets(15, 2, 2, 2);
		c8.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Broj telefona*"), c8);
		
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 1;
		c9.gridy = 4;
		c9.insets = new Insets(15, 2, 2, 2);
		c9.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(telefon, c9);
		
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 0;
		c10.gridy = 5;
		c10.insets = new Insets(15, 2, 2, 2);
		c10.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Email*"), c10);
		
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 1;
		c11.gridy = 5;
		c11.insets = new Insets(15, 2, 2, 2);
		c11.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(email, c11);
		
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 0;
		c12.gridy = 6;
		c12.insets = new Insets(15, 2, 2, 2);
		c12.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Adresa kancelarije*"), c12);
		
		GridBagConstraints c13 = new GridBagConstraints();
		c13.gridx = 1;
		c13.gridy = 6;
		c13.insets = new Insets(15, 2, 2, 2);
		c13.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(adrKancelarije, c13);
		
		GridBagConstraints c14 = new GridBagConstraints();
		c14.gridx = 0;
		c14.gridy = 7;
		c14.insets = new Insets(15, 2, 2, 2);
		c14.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Broj li\u010Dne karte*"), c14);
		
		GridBagConstraints c15 = new GridBagConstraints();
		c15.gridx = 1;
		c15.gridy = 7;
		c15.insets = new Insets(15, 2, 2, 2);
		c15.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(brLicneKarte, c15);
		
		GridBagConstraints c16 = new GridBagConstraints();
		c16.gridx = 0;
		c16.gridy = 8;
		c16.insets = new Insets(15, 2, 2, 2);
		c16.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Titula*"), c16);
		
		GridBagConstraints c17 = new GridBagConstraints();
		c17.gridx = 1;
		c17.gridy = 8;
		c17.insets = new Insets(15, 2, 2, 2);
		c17.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(titula, c17);
		
		GridBagConstraints c18 = new GridBagConstraints();
		c18.gridx = 0;
		c18.gridy = 9;
		c18.insets = new Insets(15, 2, 2, 2);
		c18.anchor = GridBagConstraints.WEST;
		getContentPane().add(new JLabel("Zvanje*"), c18);
		
		GridBagConstraints c19 = new GridBagConstraints();
		c19.gridx = 1;
		c19.gridy = 9;
		c19.fill = GridBagConstraints.HORIZONTAL;
		c19.insets = new Insets(15, 2, 2, 2);
		getContentPane().add(zvanje, c19);
		
		GridBagConstraints c21 = new GridBagConstraints();
		c21.gridx = 1;
		c21.gridy = 10;
		c21.insets = new Insets(40, 2, 2, 2);
		c21.anchor = GridBagConstraints.EAST;
		getContentPane().add(panel, c21);
		
		Profesor p = ProfesorController.getInstance().getProfesor(GlavniProzor.getInstance().getSelektovanuTorku());
		
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
		
		dodajButton.addActionListener(new IzmenaProfesoraListener(this));

		otkaziButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
	public JButton getDodajButton() {
		return dodajButton;
	}

	public JTextField getIme() {
		return ime;
	}

	public JTextField getPrezime() {
		return prezime;
	}

	public JTextField getDatum() {
		return datum;
	}

	public JTextField getAdrStanovanja() {
		return adrStanovanja;
	}

	public JTextField getTelefon() {
		return telefon;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getAdrKancelarije() {
		return adrKancelarije;
	}

	public JTextField getBrLicneKarte() {
		return brLicneKarte;
	}

	public JTextField getTitula() {
		return titula;
	}

	public JTextField getZvanje() {
		return zvanje;
	}


}
