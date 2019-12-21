package dijalog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import studentskasluzba.BazaPredmet;
import studentskasluzba.BazaProfesor;
import studentskasluzba.GlavniProzor;
import studentskasluzba.Profesor;

public class DodavanjeProfesoraNaPredmet extends JDialog{
	private static final long serialVersionUID = -8256272619031522397L;

	JTextField text;
	public DodavanjeProfesoraNaPredmet()
	{
		int row = GlavniProzor.getInstance().getSelektovanuTorku();
		this.setTitle("Predmet - dodavanje profesora na: " +
				BazaPredmet.getInstance().getValueAt(row , 1));
		setSize(400,150);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		getContentPane().setLayout(new GridBagLayout());
		
		JLabel message = new JLabel("Broj li\u010Dne karte profesora*");
		text = new JTextField();
		JButton potvrda = new JButton("Potvrda");
		JButton odustanak = new JButton("Odustanak");
		
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
		getContentPane().add(text, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 1;
		c2.gridy = 1;
		c2.insets = new Insets(30, 2, 2, 2);
		c2.anchor = GridBagConstraints.EAST;
		getContentPane().add(p, c2);
		
		ActionListener dodavanje = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Profesor p = BazaProfesor.getInstance().getProfesor(text.getText());
				if(p == null)
				{
					JOptionPane.showMessageDialog(null, "Profesor ne postoji u bazi podataka!","Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				BazaPredmet.getInstance().getPredmet(GlavniProzor.getInstance().getSelektovanuTorku()).setProfesor(p);
				GlavniProzor.getInstance().azurirajPrikaz();
				GlavniProzor.getInstance().saveAllDBs();
				dispose();
				
			}
			
		};
		potvrda.addActionListener(dodavanje);
		text.addActionListener(dodavanje);
	}
}
