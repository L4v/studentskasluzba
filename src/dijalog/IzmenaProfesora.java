package dijalog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JLabel warningLabel;
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
		
		warningLabel = new JLabel("POPUNITI SVA POLJA");
		warningLabel.setForeground(Color.RED);
		warningLabel.setVisible(false);
		ime = new JTextField();
		ime.addFocusListener(new FocusListenerObaveznoTxt());
		prezime = new JTextField();
		prezime.addFocusListener(new FocusListenerObaveznoTxt());
		datum = new JTextField();
		datum.addFocusListener(new FocusListenerObaveznoTxt());
		adrStanovanja = new JTextField();
		adrStanovanja.addFocusListener(new FocusListenerObaveznoTxt());
		telefon = new JTextField();
		telefon.addFocusListener(new FocusListenerObaveznoBroj(-1));
		email = new JTextField();
		email.addFocusListener(new FocusListenerObaveznoTxt());
		adrKancelarije = new JTextField();
		adrKancelarije.addFocusListener(new FocusListenerObaveznoTxt());
		brLicneKarte = new JTextField();
		brLicneKarte.addFocusListener(new FocusListenerObaveznoBroj(9));
		titula = new JTextField();
		titula.addFocusListener(new FocusListenerObaveznoTxt());
		zvanje = new JTextField();
		zvanje.addFocusListener(new FocusListenerObaveznoTxt());
		
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
		
		
		dodajButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
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
					warningLabel.setVisible(true);
				}
				else
				{
					BazaProfesor.getInstance().izmeniProfesora(ime.getText(), prezime.getText(), datum.getText(),
							adrStanovanja.getText(), telefon.getText(), email.getText(), adrKancelarije.getText(),
							brLicneKarte.getText(), titula.getText(), zvanje.getText());
					
					
					dispose();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		otkaziButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
