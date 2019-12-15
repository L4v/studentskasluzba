package dijalog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DodavanjeStudenta extends JDialog{

	public DodavanjeStudenta() {
		
		setTitle("Dodavanje studenta");
		setSize(450,450);
		setLocationRelativeTo(null);
		
		GridBagLayout layout = new GridBagLayout();
		getContentPane().setLayout(layout);
		
		JLabel ime = new JLabel("Ime*");
		JLabel prezime = new JLabel("Prezime*");
		JLabel datRodj = new JLabel("Datum ro\u0111enja*");
		JLabel adresa = new JLabel("Adresa stanovanja*");
		JLabel brTelefona = new JLabel("Broj telefona*");
		JLabel brIndeksa = new JLabel("Broj Indeksa*");
		JLabel trenutnaGod = new JLabel("Trenutna godina*");
		
		JButton potvrdi = new JButton("Potvrdi");
		JButton otkazi = new JButton("Otka\u017ei");
		
		JPanel panel = new JPanel();
		panel.add(otkazi);
		panel.add(potvrdi);
		
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
		c.insets = new Insets(15, 2, 2, 2);
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(ime, c);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 1;
		c1.gridy = 0;
		c1.weightx = 1;
		c1.insets = new Insets(15, 2, 2, 2);
		c1.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(imeT, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;
		c2.insets = new Insets(15, 2, 2, 2);
		c2.anchor = GridBagConstraints.WEST;
		getContentPane().add(prezime, c2);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 1;
		c3.gridy = 1;
		c3.insets = new Insets(15, 2, 2, 2);
		c3.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(prezimeT, c3);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 2;
		c4.insets = new Insets(15, 2, 2, 2);
		c4.anchor = GridBagConstraints.WEST;
		getContentPane().add(datRodj, c4);
		
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 1;
		c5.gridy = 2;
		c5.insets = new Insets(15, 2, 2, 2);
		c5.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(datRodjT, c5);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 0;
		c6.gridy = 3;
		c6.insets = new Insets(15, 2, 2, 2);
		c6.anchor = GridBagConstraints.WEST;
		getContentPane().add(adresa, c6);
		
		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 1;
		c7.gridy = 3;
		c7.insets = new Insets(15, 2, 2, 2);
		c7.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(adresaT, c7);
		
		GridBagConstraints c8 = new GridBagConstraints();
		c8.gridx = 0;
		c8.gridy = 4;
		c8.insets = new Insets(15, 2, 2, 2);
		c8.anchor = GridBagConstraints.WEST;
		getContentPane().add(brTelefona, c8);
		
		GridBagConstraints c9 = new GridBagConstraints();
		c9.gridx = 1;
		c9.gridy = 4;
		c9.insets = new Insets(15, 2, 2, 2);
		c9.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(brTelefonaT, c9);
		
		GridBagConstraints c10 = new GridBagConstraints();
		c10.gridx = 0;
		c10.gridy = 5;
		c10.insets = new Insets(15, 2, 2, 2);
		c10.anchor = GridBagConstraints.WEST;
		getContentPane().add(brIndeksa, c10);
		
		GridBagConstraints c11 = new GridBagConstraints();
		c11.gridx = 1;
		c11.gridy = 5;
		c11.insets = new Insets(15, 2, 2, 2);
		c11.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(brIndeksaT, c11);
		
		GridBagConstraints c12 = new GridBagConstraints();
		c12.gridx = 0;
		c12.gridy = 6;
		c12.insets = new Insets(15, 2, 2, 2);
		c12.anchor = GridBagConstraints.WEST;
		getContentPane().add(trenutnaGod, c12);
		
		GridBagConstraints c13 = new GridBagConstraints();
		c13.gridx = 1;
		c13.gridy = 6;
		c13.fill = GridBagConstraints.HORIZONTAL;
		c13.insets = new Insets(15, 2, 2, 2);
		getContentPane().add(trenGod, c13);
		
		GridBagConstraints c14 = new GridBagConstraints();
		c14.gridx = 0;
		c14.gridy = 7;
		c14.insets = new Insets(15, 2, 2, 2);
		c14.anchor = GridBagConstraints.WEST;
		getContentPane().add(radBtnB, c14);
		
		GridBagConstraints c15 = new GridBagConstraints();
		c15.gridx = 0;
		c15.gridy = 8;
		c15.insets = new Insets(2, 2, 2, 2);
		c15.anchor = GridBagConstraints.WEST;
		getContentPane().add(radBtnS, c15);
		
		GridBagConstraints c16 = new GridBagConstraints();
		c16.gridx = 1;
		c16.gridy = 10;
		c16.insets = new Insets(15, 2, 2, 2);
		c16.anchor = GridBagConstraints.EAST;
		getContentPane().add(panel, c16);
		
	}
	
}
