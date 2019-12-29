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
import javax.swing.JTextField;

import studentskasluzba.model.BazaPredmet;
import studentskasluzba.model.BazaStudenata;
import studentskasluzba.model.Predmet;
import studentskasluzba.model.Student;
import studentskasluzba.view.GlavniProzor;

public class DodavanjeStudentaNaPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DodavanjeStudentaNaPredmet() {
	
		setTitle("Predmet - dodavanje studenta");
		setSize(400,150);
		setLocationRelativeTo(null);
		this.setModal(true);
		
		getContentPane().setLayout(new GridBagLayout());
		
		JLabel message = new JLabel("Indeks studenta*");
		JTextField text = new JTextField();
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
	
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		// NOTE(Jovan): Action listener za dodavanje	
		ActionListener dodavanje = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String brIndeksa=text.getText();
				Student s = BazaStudenata.getInstance().getStudent(brIndeksa);
				if (s==null) {
					JOptionPane.showMessageDialog(null, "Student ne postoji u bazi podataka!","Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Predmet p = BazaPredmet.getInstance().getPredmet(GlavniProzor.getInstance().getSelektovanuTorku());
				if (!s.getTrenutnaGodina().equalsIgnoreCase(Integer.toString(p.getGodina()))) {
					JOptionPane.showMessageDialog(null, "Trenutna godina studija studenta nije ista sa predmetom!","Warning", JOptionPane.WARNING_MESSAGE);
					dispose();
					return;
				}
				// NOTE(Jovan): U slucaju da ne uspe dodavanje
				if(!p.addStudent(s))
				{
					JOptionPane.showMessageDialog(null, "Student ve\u0107 poha\u0111a ovaj predmet.");
					dispose();
				}
				BazaStudenata.getInstance().getStudent(s.getIndeks()).addPredmet(p);
				GlavniProzor.getInstance().saveAllDBs();
				dispose();
				
			}
		};
		potvrda.addActionListener(dodavanje);
		text.addActionListener(dodavanje);
		
	}
	
	
}
