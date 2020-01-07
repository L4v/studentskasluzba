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

import studentskasluzba.view.listeners.DodavanjeStudentaNaPredmetListener;

public class DodavanjeStudentaNaPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField unos;
	JButton potvrda, odustanak;
	
	public DodavanjeStudentaNaPredmet() {
	
		setTitle("Predmet - dodavanje studenta");
		setSize(400,150);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		getContentPane().setLayout(new GridBagLayout());
		
		JLabel message = new JLabel("Indeks studenta*");
		unos = new JTextField();
		potvrda = new JButton("Potvrda");
		odustanak = new JButton("Odustanak");
		
		JPanel p = new JPanel();
		p.add(odustanak);
		p.add(potvrda);
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(15, 2, 2, 30);
		c.anchor = GridBagConstraints.WEST;
		getContentPane().add(message, c);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 1;
		c1.gridy = 0;
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.insets = new Insets(15, 2, 2, 30);
		c1.anchor = GridBagConstraints.WEST;
		getContentPane().add(unos, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 1;
		c2.gridy = 1;
		c2.insets = new Insets(30, 2, 2, 2);
		c2.anchor = GridBagConstraints.EAST;
		getContentPane().add(p, c2);
	
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		potvrda.addActionListener(new DodavanjeStudentaNaPredmetListener(this));
		//unos.addFocusListener(new DodStudNaPredFocus1(this));
		
	}

	public JButton getPotvrda() {
		return potvrda;
	}

	public JTextField getUnos() {
		return unos;
	}

	
}
