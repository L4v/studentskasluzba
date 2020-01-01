package studentskasluzba.view.dijalog;

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
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import studentskasluzba.controller.PredmetController;
import studentskasluzba.model.BazaPredmet;
import studentskasluzba.view.GlavniProzor;
import studentskasluzba.view.listeners.ProfesorNaPredmetFocusTxt;
public class DodavanjeProfesoraNaPredmet extends JDialog{
	private static final long serialVersionUID = -8256272619031522397L;

	private JTextField text;
	private JButton potvrda;
	private JButton odustanak;
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
		text.addFocusListener(new ProfesorNaPredmetFocusTxt(this));
		this.potvrda = new JButton("Potvrda");
		this.odustanak = new JButton("Odustanak");
		
		JPanel p = new JPanel();
		p.add(this.odustanak);
		p.add(this.potvrda);
		
		
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
				if(!PredmetController.getInstance().addProfesor(GlavniProzor.getInstance().getSelektovanuTorku(), text.getText()) &&
						DodavanjeProfesoraNaPredmet.this.potvrda.isEnabled())
				{
					JOptionPane.showMessageDialog(null, "Profesor ne postoji!","Warning", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					dispose();
				}
			}
			
		};
		this.potvrda.addActionListener(dodavanje);
		this.text.addActionListener(dodavanje);
		JRootPane root = SwingUtilities.getRootPane(this.potvrda);
		root.setDefaultButton(this.potvrda);
		
		this.odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
	public JButton getPotvrda() {
		return potvrda;
	}
}
