package dijalog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DodavanjeStudenta extends JDialog{

	public DodavanjeStudenta() {
		
		setTitle("Dodavanje studenta");
		
		GridBagLayout layout = new GridBagLayout();
		getContentPane().setLayout(layout);
		
		JLabel ime = new JLabel("Ime*");
		JLabel prezime = new JLabel("Prezime*");
		JLabel datRodj = new JLabel("Datum ro\u0111enja*");
		JLabel adresa = new JLabel("Adresa stanovanja*");
		JLabel brTelefona = new JLabel("Broj telefona*");
		JLabel brIndeksa = new JLabel("Broj Indeksa*");
		JLabel trenutnaGod = new JLabel("Trenutna godina*");
		
		JComboBox trenGod = new JComboBox(new String[] { "I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010Detvrta)"});
			
		JRadioButton radBtnB = new JRadioButton("Bud\u017Eet");
		JRadioButton radBtnS = new JRadioButton("Samofinansiranje");
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radBtnB);
		btnGroup.add(radBtnS);
		
		JTextField imeT = new JTextField();
		JTextField prezimeT = new JTextField();
		JTextField datRodjT = new JTextField();
		JTextField adresaT = new JTextField();
		JTextField brTelefonaT = new JTextField();
		JTextField brIndeksaT = new JTextField();
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(ime, c);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		getContentPane().add(imeT, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(prezime, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		getContentPane().add(prezimeT, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(datRodj, c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		getContentPane().add(datRodjT, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(adresa, c6);
		
		GridBagConstraints c7 = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 3;
		getContentPane().add(adresaT, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(brTelefona, c8);
		
		GridBagConstraints c9 = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 4;
		getContentPane().add(brTelefonaT, c9);
		
		GridBagConstraints c10 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 5;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(brIndeksa, c10);
		
		GridBagConstraints c11 = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 5;
		getContentPane().add(brIndeksaT, c11);
		
		GridBagConstraints c12 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(trenutnaGod, c12);
		
		GridBagConstraints c13 = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 6;
		getContentPane().add(trenGod, c13);
		
		GridBagConstraints c14 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 7;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(radBtnB, c14);
		
		GridBagConstraints c15 = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 8;
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(radBtnS, c15);
		
	}
	
}
